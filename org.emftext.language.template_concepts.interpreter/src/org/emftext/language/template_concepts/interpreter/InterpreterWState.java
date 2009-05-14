package org.emftext.language.template_concepts.interpreter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl; 
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.emftext.language.template_concepts.ExpressionChecker;
import org.emftext.language.template_concepts.ForEach;
import org.emftext.language.template_concepts.If;
import org.emftext.language.template_concepts.Placeholder;
import org.emftext.language.template_concepts.Template;
import org.emftext.language.template_concepts.TemplateConcept;
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
public class InterpreterWState {
	
	//TODO make relative referenced
	private static final String TEMPLATE_INSTANCE_METAMODEL = "http://www.emftext.org/language/sandwich";
	private String varibleName = "self"; //The only variable possible as for now
	
	private final Template template;
	private final EObject rootOfParameterModel;
	private EObject templateInstanceRoot;
	private EPackage tiRootPackage;
	
	private Context context;
	private ExpressionChecker expressionChecker;
	
	private List<EAttribute> treatedByPlaceholderList;
	
	public InterpreterWState(Template template, EObject rootOfParameterModel) throws InterpreterException{
		this.template = template;
		this.rootOfParameterModel = rootOfParameterModel;
		treatedByPlaceholderList = new ArrayList<EAttribute>();
		context = new Context();
		expressionChecker = new ExpressionChecker();
		
		load();
	}
	
	private void load() throws InterpreterException{
		System.out.println("Interpreter.process()");
	
		//Get root package in template instance
		tiRootPackage = EPackage.Registry.INSTANCE.getEPackage(TEMPLATE_INSTANCE_METAMODEL);
		Resource tiResource = new ResourceImpl();
		
		//find templateBody
		EStructuralFeature templateBodySF = template.eClass().getEStructuralFeature(TemplateMetamodelAssumptions.REFERENCE_TEMPLATE_BODY);
		if(templateBodySF==null) throw new TemplateMetamodelException("Template has no body");
		EObject templateBody = (EObject)template.eGet(templateBodySF);
		if(templateBody == null) throw new TemplateMetamodelException("Template has no body");
		
		EObject tiObject = evaluate(templateBody,tiRootPackage);
		tiResource.getContents().add(tiObject);
		//Add for all non template instances respective language instances
//		for(EObject rootObject : templateBody.eContents()){
//			System.out.println("Eval: " + rootObject.getClass());
//			EObject toAdd = evaluate(rootObject,tiRootPackage);
//			if(toAdd!=null){
//				tiResource.getContents().add(toAdd);
//			}
//		}
	}
	
	/**
	 * @param tObject eObject in the template language
	 * @param tiPackage an ePackage in the template instance  
	 * @return Returns the representative of parent in the template instance
	 */
	private EObject evaluate(EObject tObject, EPackage tiRootPackage) throws InterpreterException{
		if(tObject == null) return null;
		String className = tObject.eClass().getName();
	
		//find respective language class in this package
		//and instantiate it as EObject
		EObject tiObject = findInPackageAndInstantiate(className, tiRootPackage);
		if(tiObject==null){
			throw new InterpreterException("Didn't find respective template instance class for template class " + className);
		}
		
		for(EObject tReferenceObject : tObject.eContents()){
			//Evaluate TemplateConcept
			if(tReferenceObject instanceof TemplateConcept){
				System.out.println("TemplateConcept: "+tReferenceObject.getClass());
				if(tReferenceObject instanceof Placeholder){
					evaluatePlaceHolder((Placeholder)tReferenceObject,tObject,tiObject);
				} else if(tReferenceObject instanceof ForEach){
					evaluateForLoop((ForEach)tReferenceObject,tObject,tiObject);
				} else if(tReferenceObject instanceof If){
					evaluateIfCondition((If)tReferenceObject,tObject,tiObject);
				} else throw new TemplateMetamodelException("Unkown TemplateConcept: " + tReferenceObject.getClass());
			//Evaluate recursively
			} else {
				System.out.println("NO TemplateConcept: "+tReferenceObject.getClass());
				evaluateTReference(tObject,tReferenceObject,tiObject,tiRootPackage);
			}
		}
		
		//Now just copy attributes which have not been treated as PlaceHolder
		for(EAttribute tiAttributeClass : tiObject.eClass().getEAllAttributes()){
			if(!treatedByPlaceholderList.contains(tiAttributeClass)){
				String attributeName = tiAttributeClass.getName();
				//find respective langParentAttributeClass
				EAttribute tAttributeClass = null;
				for(EAttribute attClass : tObject.eClass().getEAllAttributes()){
					if(attClass.getName().matches(attributeName)){
						tAttributeClass = attClass;
						break;
					}
				}
				if(tAttributeClass==null){
					throw new TemplateMetamodelException("No tAttributeClass found for tiAttributeClass " + tObject.eClass().getName()+"."+attributeName);
				}
				Object tAttribute = tObject.eGet(tAttributeClass);
				//attribute-OBJECTS just need to be set. No need to transform them
				tiObject.eSet(tiAttributeClass, tAttribute);
			}
		}
		return tiObject;
	}
	
	private void evaluatePlaceHolder(Placeholder placeHolder,
			EObject tObject,EObject tiObject) throws InterpreterException{
		
		Object evaluatedObject = expressionChecker.evaluateExpression(
				null, //TODO mseifert what is the inputMetaClass for a forLoop? 
				placeHolder.getExpression(), //expression
				context.getVariableValue(varibleName)); //context for only possible variable;
		
		//placeHolder extends from PlaceHolder and the tiAttributeClass
		List<EClass> superClasses = placeHolder.eClass().getESuperTypes();
		if(superClasses.size()!=2) throw new TemplateMetamodelException("The type of a concrete placeholder extends from PlaceHolder and the extended attribute");
		EClass tAttributeElementClass = null;
		for(EClass superClass : superClasses){
			if(superClass.getName()!=Placeholder.class.getName()){
				tAttributeElementClass = superClass;
			}
		}
		if(tAttributeElementClass==null) throw new TemplateMetamodelException("The type of a concrete placeholder extends from PlaceHolder and the extended attribute");
		
		//derive tiAttributeElementName
		if(!tAttributeElementClass.getName().startsWith(TemplateMetamodelAssumptions.ATT))
			throw new InterpreterException("AttributeElements should begin with "+TemplateMetamodelAssumptions.ATT);
		String derivedTIAttributeElementName = tAttributeElementClass.getName().substring(TemplateMetamodelAssumptions.ATT.length());
		
		//find tiAttributeElement
		EObject tiAttributeElement = findInPackageAndInstantiate(derivedTIAttributeElementName, tiRootPackage);
		if(tiAttributeElement==null) throw new TemplateMetamodelException("Didn't find tiAttributeElement with name: " + derivedTIAttributeElementName);
		
		//contains exactly one attribute
		if(tiAttributeElement.eClass().getEAllAttributes().size()!=1){
			throw new TemplateMetamodelException("An attributeElement only contains one attribute, but it contains " + tiAttributeElement.eClass().getEAllAttributes().size() + " attributes");
		}
		EAttribute tiAttribute = tiAttributeElement.eClass().getEAllAttributes().get(0);
		tiAttributeElement.eSet(tiAttribute, evaluatedObject);
		
		//put into treatedByPlaceHolderList
		treatedByPlaceholderList.add(tiAttribute);
		
		//now attach tiAttributeElement to tiObject
		EReference tReference = (EReference)placeHolder.eContainingFeature();
		if(tReference==null) throw new InterpreterException("Placeholder must be contained by some container");
		EReference tiReference = (EReference)tiObject.eClass().getEStructuralFeature(tReference.getName());
		if(tiReference==null) throw new TemplateMetamodelException("References to placeholder and attributeElement in TI should be the same");
		//multiplicity > 1
		if(tiObject.eGet(tiReference) instanceof List){
			((List)tiObject.eGet(tiReference)).add(tiAttributeElement);
		//multiplicity <=1
		} else {
			tiObject.eSet(tiReference,tiAttributeElement);
		}
	}
	
	private void evaluateForLoop(ForEach forLoop,EObject tObject,EObject tiObject) throws InterpreterException{
		//Find forBody
		EObject forBody = (EObject)forLoop.eGet(forLoop.eClass().getEStructuralFeature(TemplateMetamodelAssumptions.REFERENCE_FOR_BODY));
		if(forBody==null) throw new TemplateMetamodelException("ForLoop without body: " + forLoop);
		//Find tiReference
		EReference tiReference = null;
		for(EReference ref : tiObject.eClass().getEReferences()){
			if(forLoop.eContainingFeature().getName().matches(ref.getName())){
				tiReference = ref;
				break;
			}
		}
		if(tiReference == null) throw new TemplateMetamodelException("For-Loop: Didn't find reference " + forLoop.eContainingFeature().getName() + " in tiObject");
		
		//Resolve the collection
		
		List<Object> inputCollection = new ArrayList<Object>();
		try{
			inputCollection = (List<Object>)expressionChecker.evaluateExpression(
					null, //TODO mseifert what is the inputMetaClass for a forLoop? 
					forLoop.getExpression(), //expression
					null); //context is empty
		} catch (StackOverflowError e){
			e.printStackTrace();
		}
		/** Global **/
		//String varibleName = "self"; //The only variable possible as for now
		
		//THE FORLOOP
		for(Object o : inputCollection){
			if(!(o instanceof EObject)){
				throw new TemplateException("For-loop methodCall ("+forLoop.getExpression()+") does not return a list of ModelElements but Attributes");
			}
			context.pushVariable(varibleName,(EObject)o);
			//BODY
			((List<EObject>)tiObject.eGet(tiReference)).add(evaluate(forBody, tiRootPackage));
			context.pullVariable(varibleName);
		}
	}
	
	private void evaluateIfCondition(If ifCondition,EObject tObject,EObject tiObject) throws InterpreterException{
		//TODO not yet implemented
		//else body missing?
	}
	
	private void evaluateTReference(EObject tObject, EObject tReferenceObject, EObject tiObject, EPackage tiRootPackage) throws InterpreterException{
		if(tReferenceObject==null){
			System.err.println("tReferenceObject was null?");
			return;
		}
		
		EReference tReference = (EReference)tReferenceObject.eContainingFeature();
		if(tReference == null) throw new InterpreterException("tReference from tObject to tReferenceObject not found in tObject");
		
		EReference tiReference = null;
		for(EReference ref : tiObject.eClass().getEReferences()){
			if(tReference.getName().matches(ref.getName())){
				tiReference = ref;
				break;
			}
		}
		if(tiReference==null) throw new TemplateMetamodelException("tiObject Reference missing: "+tReference.getName()+" Found an object which is neither meta language nor object language");
		
		//tReferenceObject can also be a listMember
		if(tReference.isMany()){
			((List<EObject>)tiObject.eGet(tiReference)).add(evaluate(tReferenceObject, tiRootPackage));
		} else {
			tiObject.eSet(tiReference, evaluate(tReferenceObject, tiRootPackage));
		}
	}
	
//	public EPackage findRootPackage(EPackage pack){
//		if(pack.getESuperPackage()!=null) return findRootPackage(pack.getESuperPackage());
//		return pack;
//	}
	
	private EObject findInPackageAndInstantiate(String className, EPackage currentPackage) throws InterpreterException{
		try{
			for(EClassifier tiClassifier : currentPackage.getEClassifiers()){
				if(tiClassifier instanceof EClass){
					EClass tiClass = (EClass)tiClassifier;
					if(tiClass.getName().matches(className)){
						return currentPackage.getEFactoryInstance().create(tiClass);
					}
				}
			}
		} catch(Exception e){
			throw new TemplateException("Couldn't instantiate " + className,e);
		}
		//not found in this package search deeper
		for(EPackage subPackage : currentPackage.getESubpackages()){
			EObject toReturn = findInPackageAndInstantiate(className, subPackage);
			if(toReturn!=null) return toReturn;
		}		
		return null;
	}
	
	
	
	public EObject getTemplateInstanceRoot(){
		return templateInstanceRoot;
	}
}
