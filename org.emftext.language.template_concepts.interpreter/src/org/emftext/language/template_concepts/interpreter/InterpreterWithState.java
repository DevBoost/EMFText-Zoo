/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.language.template_concepts.interpreter;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.template_concepts.ExpressionChecker;
import org.emftext.language.template_concepts.ForEach;
import org.emftext.language.template_concepts.If;
import org.emftext.language.template_concepts.IfElse;
import org.emftext.language.template_concepts.Placeholder;
import org.emftext.language.template_concepts.Template;
import org.emftext.language.template_concepts.TemplateConcept;
import org.emftext.language.template_concepts.Template_conceptsPackage;
import org.emftext.language.template_concepts.interpreter.exceptions.InterpreterException;
import org.emftext.language.template_concepts.interpreter.exceptions.TemplateException;
import org.emftext.language.template_concepts.interpreter.exceptions.TemplateMetamodelException;
import org.emftext.runtime.util.ListUtil;

/**
 * This is the actual interpreter. It maintains a state. Thus,
 * all different parameters can be interrogated just 
 * after interpretation or later on.
 * 
 * TODO InputModels shouldn't contain StringBox, etc. to be working
 * TODO use EPackage of object language instead of template language to create tiObjects
 * 
 * @author Marcel Böhme
 * Comment created on: 13.05.09
 */
public class InterpreterWithState {
	
	private final Template template;
	
	private EObject templateInstanceRoot;
	
	private Stack<EObject> inputObjectStack;
	private Stack<EObject> inputMetaClassStack;
	private LoopVariablesStack loopVariableStack;
	
	private ExpressionChecker expressionChecker;
	
	private Map<EObject, EObject> templateToInstanceObjectMap;
	private Map<EObject, EObject> instanceToTemplateObjectMap;

	private final static ListUtil listUtil = new ListUtil();
	
	public InterpreterWithState(Template template, EObject inputModelRoot) throws InterpreterException{
		this.template = template;
		
		inputObjectStack = new Stack<EObject>();
		inputMetaClassStack = new Stack<EObject>();
		loopVariableStack = new LoopVariablesStack();
		
		inputObjectStack.push(inputModelRoot);
		inputMetaClassStack.push(inputModelRoot.eClass());
		
		templateToInstanceObjectMap = new HashMap<EObject, EObject>();
		instanceToTemplateObjectMap = new HashMap<EObject, EObject>();

		expressionChecker = new ExpressionChecker();
		
		load();
	}
	
	private void load() throws InterpreterException {
		
		//find templateBody
		EStructuralFeature templateBodySF = template.eClass().getEStructuralFeature(TemplateMetamodelAssumptions.REFERENCE_TEMPLATE_BODY);
		if (templateBodySF == null) {
			throw new TemplateMetamodelException("Template has no body");
		}
		
		Object templateBodyO = template.eGet(templateBodySF);
		if (templateBodyO == null) {
			throw new TemplateMetamodelException("Template has no body");
		}
		if (templateBodyO instanceof List) {
			//Can be a list
			throw new TemplateMetamodelException("Template contains multiple root elements");
		} else {
			//or a single element
			templateInstanceRoot = evaluate((EObject) templateBodyO);
			copyCrossReferences();
		}
	}
	
	/**
	 * mboehme: What does this do? Thought we already check *.getEAllReferences() by *.eContents()?
	 */
	private void copyCrossReferences() {
		if (templateInstanceRoot == null) {
			return;
		}
		// Copy cross reference
		TreeIterator<EObject> contents = templateInstanceRoot.eAllContents();
		while (contents.hasNext()) {
			EObject nextTiObject = contents.next();
			for (EReference reference : nextTiObject.eClass().getEAllReferences()) {
				if (reference.isContainment()) {
					continue;
				}
				if (reference.isContainer()) {
					continue;
				}
				EObject tObject = instanceToTemplateObjectMap.get(nextTiObject);
				EObject referencedObjectInTemplate = (EObject) tObject.eGet(reference);
				EObject referencedObjectInInstance = templateToInstanceObjectMap.get(referencedObjectInTemplate);
				
				//System.out.println("copy cross reference " + reference.getName() + " target = " + referencedObjectInInstance);
				nextTiObject.eSet(reference, referencedObjectInInstance);
			}
		}
	}
	
	/**
	 * @param tObject eObject in the template language
	 * @param tiPackage an ePackage in the template instance
	 * @return Returns the representative of parent in the template instance
	 */
	private EObject evaluate(EObject tObject) throws InterpreterException {
		if (tObject == null) {
			return null;
		}
		//TODO treat cycles (if needed), but watch context! 
		//if(templateToInstanceObjectMap.get(tObject)!=null){
		//	return templateToInstanceObjectMap.get(tObject); (Code not watching variable context)
	    //}
		
		String className = tObject.eClass().getName();
	
		//find respective language class in this package
		//and instantiate it as EObject
		EObject tiObject = createObjectOfSameClass(tObject);
		if (tiObject == null) {
			throw new InterpreterException("Didn't find respective template instance class for template class '" + className + "'");
		}
		//System.out.println("Copied " + tObject + " to " + tiObject);
		//FIXME mboehme: doesn't work! For instance in a forLoop the same tObject results in different tiObjects 
		templateToInstanceObjectMap.put(tObject, tiObject);
		instanceToTemplateObjectMap.put(tiObject, tObject);
		
		for (EObject tReferenceObject : tObject.eContents()) {
			//Evaluate TemplateConcept
			if (tReferenceObject instanceof TemplateConcept) {
				if (tReferenceObject instanceof Placeholder) {
					evaluatePlaceHolder((Placeholder) tReferenceObject, tiObject);
				} else if(tReferenceObject instanceof ForEach) {
					evaluateForLoop((ForEach) tReferenceObject, tiObject);
				} else if(tReferenceObject instanceof If) {
					evaluateIfCondition((If) tReferenceObject, tiObject);
				} else if(tReferenceObject instanceof IfElse) {
					evaluateIfElseCondition((IfElse) tReferenceObject, tiObject);
				} else {
					throw new TemplateMetamodelException("Unkown TemplateConcept: " + tReferenceObject.getClass());
				}
			//Evaluate recursively
			} else {
				evaluateTReference(tReferenceObject, tiObject);
			}
		}
		
		//Now just copy attributes which have not been treated as PlaceHolder
		for (EAttribute tiAttributeClass : tiObject.eClass().getEAllAttributes()) {
			
			//TODO Check if this is an instance of primitive_type (only primitive type has attributes)
			//TODO Import primitive_type into project dependencies 
			//AND every primitive type should inherit an abstract type: PrimitiveType
			//if(!(tiObject instanceof PrimitiveType)) throw new TemplateMetamodelException("Attributes must be wrapped in a Primitive Type");
			
			String attributeName = tiAttributeClass.getName();
			//find respective langParentAttributeClass
						
			EAttribute tAttributeClass = null;
			for (EAttribute attClass : tObject.eClass().getEAllAttributes()) {
				if (attClass.getName().matches(attributeName)) {
					tAttributeClass = attClass;
					break;
				}
			}
			if (tAttributeClass == null) {
				throw new TemplateMetamodelException("No tAttributeClass found for tiAttributeClass " + tObject.eClass().getName()+"."+attributeName);
			}
			Object tAttribute = tObject.eGet(tAttributeClass);
			//System.out.println("Copied attribute " + attributeName + " (" + tAttribute + ") to " + tiObject);
			//attribute-OBJECTS just need to be set. No need to transform them
			tiObject.eSet(tiAttributeClass, tAttribute);
		}
		
		return tiObject;
	}
	
	private void evaluatePlaceHolder(Placeholder placeHolder, EObject tiObject) throws InterpreterException{
		
		Object evaluatedObject = evaluateExpression(placeHolder);
		
		//placeHolder extends from PlaceHolder and the tiAttributeClass
		List<EClass> superClasses = placeHolder.eClass().getESuperTypes();
		if (superClasses.size() != 2) {
			throw new TemplateMetamodelException("The type of a concrete placeholder extends from PlaceHolder and the extended attribute");
		}
		EClass tAttributeElementClass = null;
		for (EClass superClass : superClasses) {
			if (!superClass.equals(Template_conceptsPackage.eINSTANCE.getPlaceholder())) {
				tAttributeElementClass = superClass;
			}
		}
		if (tAttributeElementClass == null) {
			throw new TemplateMetamodelException("The type of a concrete placeholder extends from PlaceHolder and the extended attribute");
		}
		
		EClass tiConcreteAttributeClass = findSubClass(tAttributeElementClass);
		
		//find tiAttributeElement
		EObject tiAttributeElement = createObject(tiConcreteAttributeClass);
		if (tiAttributeElement == null) {
			throw new TemplateMetamodelException("Couldn't create tiAttributeElement - class: " + tAttributeElementClass);
		}
		
		// TODO mseifert: this is a dirty hack, but it works, since all primitive types
		// have the attribute 'value'.
		// mboehme: Should be resolved when no PrimitiveTypes are needed in inputModels anymore
		EObject evaluatedEObject = (EObject) evaluatedObject;
		EClass evaluateEObjectClass = evaluatedEObject.eClass();
		tiAttributeElement.eSet(tiConcreteAttributeClass.getEStructuralFeature("value"), evaluatedEObject.eGet(evaluateEObjectClass.getEStructuralFeature("value")));
		
		//now attach tiAttributeElement to tiObject
		EReference tReference = (EReference)placeHolder.eContainingFeature();
		if (tReference == null) {
			throw new InterpreterException("Placeholder must be contained by some container");
		}
		EReference tiReference = (EReference)tiObject.eClass().getEStructuralFeature(tReference.getName());
		if (tiReference == null) {
			throw new TemplateMetamodelException("References to placeholder and attributeElement in TI should have the same name");
		}
		//multiplicity > 1
		if (tiObject.eGet(tiReference) instanceof List) {
			listUtil.castListUnchecked(tiObject.eGet(tiReference)).add(tiAttributeElement);
		//multiplicity <=1
		} else {
			tiObject.eSet(tiReference,tiAttributeElement);
		}
	}
	
	/**
	 * Finds the subclass which extends from this attribute-wrapper, 
	 * which is not the placeholder 
	 * TODO Use EPackage of object language instead
	 * @param abstractAttributeClass The attribute-wrapper
	 * @return Returns the subclass extending from abstractAttributeClass (NOT the placeholder)
	 */
	private EClass findSubClass(EClass abstractAttributeClass) {
		EPackage ePackage = (EPackage) abstractAttributeClass.eContainer();
		for (EClassifier classifier : ePackage.getEClassifiers()) {
			if (!(classifier instanceof EClass)) {
				continue;
			}
			EClass eClass = (EClass) classifier;
			//mboehme: Bugfix: Shouldn't return eClass if it is a template concept (e.g. placeholder)
			if (eClass.getEAllSuperTypes().contains(abstractAttributeClass)
					&& !eClass.getEAllSuperTypes().contains(Template_conceptsPackage.eINSTANCE.getTemplateConcept())) {
				return eClass;
			}
		}
		return null;
	}

	private Object evaluateExpression(TemplateConcept concept) {
		EObject peek = inputObjectStack.peek();
		return expressionChecker.evaluateExpression(
				peek.eClass(), 
				peek,
				loopVariableStack.getTopMostVariables(),
				concept.getExpression());
	}
	
	private void evaluateForLoop(ForEach forLoop, EObject tiObject) throws InterpreterException{
		//Find forBody
		Object forBodyO = forLoop.eGet(forLoop.eClass().getEStructuralFeature(TemplateMetamodelAssumptions.REFERENCE_FOR_BODY));
		if (forBodyO == null) {
			throw new TemplateMetamodelException("ForLoop without body: " + forLoop);
		}
		
		//Find tiReference
		EReference tiReference = null;
		for (EReference ref : tiObject.eClass().getEAllReferences()) {
			if (forLoop.eContainingFeature().getName().matches(ref.getName())) {
				tiReference = ref;
				break;
			}
		}
		if (tiReference == null) {
			throw new TemplateMetamodelException("For-Loop: Didn't find reference " + forLoop.eContainingFeature().getName() + " in tiObject");
		}
		
		//Resolve the collection
		Collection<?> inputCollection = (Collection<?>) evaluateExpression(forLoop);
		
		//THE FORLOOP
		for (Object o : inputCollection) {
			if (!(o instanceof EObject)) {
				throw new TemplateException("For-loop methodCall ("+forLoop.getExpression()+") does not return a list of ModelElements but Attributes");
			}
			EObject next = (EObject) o;
			inputObjectStack.push(next);
			String variableName = forLoop.getVariable();
			if (variableName != null) {
				loopVariableStack.push(variableName, next);
			}
			//BODY (can contain multiple elements)
			List<EObject> tiList = listUtil.castListUnchecked(tiObject.eGet(tiReference)); 
			if (forBodyO instanceof List<?>) {
				List<EObject> forBodyList = listUtil.castListUnchecked(forBodyO);
				for(EObject forBody : forBodyList){
					tiList.add(evaluate(forBody));
				}
			} else {
				tiList.add(evaluate((EObject) forBodyO));
			}
			if (variableName != null) {
				loopVariableStack.pop();
			}
			inputObjectStack.pop();
		}
	}
	
	private void evaluateIfCondition(If ifCondition, EObject tiObject) throws InterpreterException{
		Object ifBodyO = ifCondition.eGet(ifCondition.eClass().getEStructuralFeature(TemplateMetamodelAssumptions.REFERENCE_IF_BODY));
		if (ifBodyO == null) {
			throw new TemplateMetamodelException("IfCondition without body: " + ifCondition);
		}
		
		//Find tiReference
		EReference tiReference = null;
		String featureName = ifCondition.eContainingFeature().getName();
		EClass tiObjectType = tiObject.eClass();
		for (EReference ref : tiObjectType.getEAllReferences()) {
			if (featureName.matches(ref.getName())) {
				tiReference = ref;
				break;
			}
		}
		if (tiReference == null) {
			throw new TemplateMetamodelException("IF: Didn't find reference '" + featureName + "' in tiObject (" + tiObjectType + ")");
		}
		
		evaluateIf(ifCondition, ifBodyO, null, tiObject, tiReference);
	}
	
	private void evaluateIfElseCondition(IfElse ifElseCondition, EObject tiObject) throws InterpreterException{
		Object ifBodyO = ifElseCondition.eGet(ifElseCondition.eClass().getEStructuralFeature(TemplateMetamodelAssumptions.REFERENCE_IF_BODY));
		if (ifBodyO == null) {
			throw new TemplateMetamodelException("IfElseCondition without ifBody: " + ifElseCondition);
		}
		Object elseBodyO = ifElseCondition.eGet(ifElseCondition.eClass().getEStructuralFeature(TemplateMetamodelAssumptions.REFERENCE_ELSE_BODY));
		if (elseBodyO == null) {
			throw new TemplateMetamodelException("IfElseCondition without elseBody: " + ifElseCondition);
		}
		
		//Find tiReference
		EReference tiReference = null;
		for (EReference ref : tiObject.eClass().getEAllReferences()) {
			if (ifElseCondition.eContainingFeature().getName().matches(ref.getName())) {
				tiReference = ref;
				break;
			}
		}
		if (tiReference == null) {
			throw new TemplateMetamodelException("IfElse: Didn't find reference " + ifElseCondition.eContainingFeature().getName() + " in tiObject");
		}
		
		evaluateIf(ifElseCondition, ifBodyO, elseBodyO, tiObject, tiReference);
	}
	
	private void evaluateIf(TemplateConcept ifOrIfElse, Object ifBodyO, Object elseBodyO, EObject tiObject, EReference tiReference) throws InterpreterException{
		
		Boolean condition = (Boolean) evaluateExpression(ifOrIfElse);
		List<EObject> tiList = listUtil.castListUnchecked(tiObject.eGet(tiReference));
		
		//IF-CONDITION
		if (condition) {
			//ifBody
			if (ifBodyO instanceof List) {
				List<EObject> ifBodyList = listUtil.castListUnchecked(ifBodyO);
				for (EObject ifBody : ifBodyList) {
					tiList.add(evaluate(ifBody));
				}
			} else {
				tiList.add(evaluate((EObject) ifBodyO));
			}
		} else {
			//elseBody (may be null)
			if (elseBodyO != null) {
				if (elseBodyO instanceof List) {
					List<EObject> elseBodyList = listUtil.castListUnchecked(elseBodyO);
					for (EObject elseBody : elseBodyList) {
						tiList.add(evaluate(elseBody));
					}
				} else {
					tiList.add(evaluate((EObject) elseBodyO));
				}
			}
		}
	}

	private void evaluateTReference(EObject tReferenceObject, EObject tiObject) throws InterpreterException{
		//System.out.println("evaluateTReference(\n\t"+tReferenceObject+",\n\t" + tiObject + "\n)");
		if (tReferenceObject == null) {
			System.err.println("tReferenceObject was null?");
			return;
		}
		
		EReference tReference = (EReference) tReferenceObject.eContainingFeature();
		if (tReference == null) {
			throw new InterpreterException("tReference from tObject to tReferenceObject not found in tObject");
		}
		
		EReference tiReference = null;
		for (EReference ref : tiObject.eClass().getEAllReferences()) {
			if (tReference.getName().matches(ref.getName())) {
				tiReference = ref;
				break;
			}
		}
		if (tiReference == null) {
			throw new TemplateMetamodelException("tiObject Reference missing: "+tReference.getName()+" Found an object which is neither meta language nor object language: " +tiObject + " tReferenceObject=" + tReferenceObject);
		}
		
		//tReferenceObject can also be a listMember
		EObject subEvaluation = evaluate(tReferenceObject);
		if (tReference.isMany()) {
			listUtil.castListUnchecked(tiObject.eGet(tiReference)).add(subEvaluation);
		} else {
			tiObject.eSet(tiReference, subEvaluation);
		}
	}
	
	/**
	 * TODO: Actually tiObject should be created from object language.
	 * Returning one is created from template language
	 */
	private EObject createObjectOfSameClass(EObject original) throws InterpreterException {
		return createObject(original.eClass());
	}

	private EObject createObject(EClass eClass) throws InterpreterException {
		EPackage ePackage = (EPackage) eClass.eContainer();
		EObject newInstance = ePackage.getEFactoryInstance().create(eClass);
		//System.out.println("createObject() created " + newInstance.getClass().getSimpleName());
		return newInstance;
	}
	
	public EObject getTemplateInstanceRoot() {
		return templateInstanceRoot;
	}
}
