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

/**
 * This is the actual interpreter. It maintains a state. Thus,
 * all different parameters can be interrogated just 
 * after interpretation or later on.
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
	private EObject evaluate(EObject tObject) throws InterpreterException{
		if (tObject == null) {
			return null;
		}
		String className = tObject.eClass().getName();
	
		//find respective language class in this package
		//and instantiate it as EObject
		EObject tiObject = createObjectOfSameClass(tObject);
		if (tiObject == null) {
			throw new InterpreterException("Didn't find respective template instance class for template class '" + className + "'");
		}
		//System.out.println("Copied " + tObject + " to " + tiObject);
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
				evaluateTReference(tObject, tReferenceObject, tiObject);
			}
		}
		
		//Now just copy attributes which have not been treated as PlaceHolder
		for (EAttribute tiAttributeClass : tiObject.eClass().getEAllAttributes()) {
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
		EObject evaluatedEObject = (EObject) evaluatedObject;
		EClass tiAttributeElementClass = tiAttributeElement.eClass();
		EClass evaluateEObjectClass = evaluatedEObject.eClass();
		tiAttributeElement.eSet(tiAttributeElementClass.getEStructuralFeature("value"), evaluatedEObject.eGet(evaluateEObjectClass.getEStructuralFeature("value")));
		
		//now attach tiAttributeElement to tiObject
		EReference tReference = (EReference)placeHolder.eContainingFeature();
		if (tReference == null) {
			throw new InterpreterException("Placeholder must be contained by some container");
		}
		EReference tiReference = (EReference)tiObject.eClass().getEStructuralFeature(tReference.getName());
		if (tiReference == null) {
			throw new TemplateMetamodelException("References to placeholder and attributeElement in TI should be the same");
		}
		//multiplicity > 1
		if (tiObject.eGet(tiReference) instanceof List) {
			castToEObjectList(tiObject.eGet(tiReference)).add(tiAttributeElement);
		//multiplicity <=1
		} else {
			tiObject.eSet(tiReference,tiAttributeElement);
		}
	}

	private EClass findSubClass(EClass abstractAttributeClass) {
		EPackage ePackage = (EPackage) abstractAttributeClass.eContainer();
		for (EClassifier classifier : ePackage.getEClassifiers()) {
			if (!(classifier instanceof EClass)) {
				continue;
			}
			EClass eClass = (EClass) classifier;
			if (eClass.getEAllSuperTypes().contains(abstractAttributeClass)) {
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
		for (EReference ref : tiObject.eClass().getEReferences()) {
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
			if (forBodyO instanceof List) {
				for(EObject forBody : castToEObjectList(forBodyO)){
					castToEObjectList(tiObject.eGet(tiReference)).add(evaluate(forBody));
				}
			} else {
				castToEObjectList(tiObject.eGet(tiReference)).add(evaluate((EObject) forBodyO));
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
		for (EReference ref : tiObject.eClass().getEReferences()) {
			if (ifElseCondition.eContainingFeature().getName().matches(ref.getName())) {
				tiReference = ref;
				break;
			}
		}
		if (tiReference == null) {
			throw new TemplateMetamodelException("For-Loop: Didn't find reference " + ifElseCondition.eContainingFeature().getName() + " in tiObject");
		}
		
		evaluateIf(ifElseCondition, ifBodyO, elseBodyO, tiObject, tiReference);
	}
	
	private void evaluateIf(TemplateConcept ifOrIfElse, Object ifBodyO, Object elseBodyO, EObject tiObject, EReference tiReference) throws InterpreterException{
		
		Boolean condition = (Boolean) evaluateExpression(ifOrIfElse);
		
		//IF-CONDITION
		if (condition) {
			//ifBody
			if (ifBodyO instanceof List) {
				for(EObject ifBody : castToEObjectList(ifBodyO)) {
					castToEObjectList(tiObject.eGet(tiReference)).add(evaluate(ifBody));
				}
			} else {
				castToEObjectList(tiObject.eGet(tiReference)).add(evaluate((EObject) ifBodyO));
			}
		} else {
			//elseBody (may be null)
			if (elseBodyO != null) {
				if (elseBodyO instanceof List) {
					for (EObject elseBody : castToEObjectList(elseBodyO)) {
						castToEObjectList(tiObject.eGet(tiReference)).add(evaluate(elseBody));
					}
				} else {
					castToEObjectList(tiObject.eGet(tiReference)).add(evaluate((EObject) elseBodyO));
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private List<EObject> castToEObjectList(Object list) {
		return (List<EObject>) list;
	}
	
	private void evaluateTReference(EObject tObject, EObject tReferenceObject, EObject tiObject) throws InterpreterException{
		if (tReferenceObject == null) {
			System.err.println("tReferenceObject was null?");
			return;
		}
		
		EReference tReference = (EReference) tReferenceObject.eContainingFeature();
		if (tReference == null) {
			throw new InterpreterException("tReference from tObject to tReferenceObject not found in tObject");
		}
		
		EReference tiReference = null;
		for (EReference ref : tiObject.eClass().getEReferences()) {
			if (tReference.getName().matches(ref.getName())) {
				tiReference = ref;
				break;
			}
		}
		if (tiReference == null) {
			throw new TemplateMetamodelException("tiObject Reference missing: "+tReference.getName()+" Found an object which is neither meta language nor object language");
		}
		
		//tReferenceObject can also be a listMember
		if (tReference.isMany()) {
			castToEObjectList(tiObject.eGet(tiReference)).add(evaluate(tReferenceObject));
		} else {
			tiObject.eSet(tiReference, evaluate(tReferenceObject));
		}
	}
	
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
