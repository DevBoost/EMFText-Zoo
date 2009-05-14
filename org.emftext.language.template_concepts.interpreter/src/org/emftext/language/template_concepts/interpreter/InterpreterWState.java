package org.emftext.language.template_concepts.interpreter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl; 
import org.emftext.language.template_concepts.ExpressionChecker;
import org.emftext.language.template_concepts.ForEach;
import org.emftext.language.template_concepts.If;
import org.emftext.language.template_concepts.IfElse;
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
	private String variableName = "self"; //The only variable possible as for now
	
	private final Template template;
	private final EObject rootOfParameterModel;
	private final EObject currentInputObject;
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
		currentInputObject = rootOfParameterModel;
		
		load();
	}
	
	private void load() throws InterpreterException{
		System.out.println("Interpreter.process()");
	
		//Get root package in template instance
		//tiRootPackage = EPackage.Registry.INSTANCE.getEPackage(TEMPLATE_INSTANCE_METAMODEL);
		EObject templateBody = (EObject) template.eGet(template.eClass().getEStructuralFeature("body"));
		tiRootPackage = templateBody.eClass().getEPackage();
		
		Resource tiResource = new ResourceImpl();
		
		//find templateBody
		EStructuralFeature templateBodySF = template.eClass().getEStructuralFeature(TemplateMetamodelAssumptions.REFERENCE_TEMPLATE_BODY);
		if(templateBodySF==null) throw new TemplateMetamodelException("Template has no body");
		
		Object templateBodyO = template.eGet(templateBodySF);
		if(templateBodyO == null) throw new TemplateMetamodelException("Template has no body");
		EClass currentInputMetaClass = (EClass) template.getInputMetaClass();
		//Can be a list
		if(templateBodyO instanceof List){
			// TODO this will not work
			// TODO mboehme: Why not? Is there always just one root object?
			//What about files containing two elements (e.g. classes) next to each other.
			//Isn't there "two roots" with the actual root(-container) being the resource itself?
			for(EObject rootObject : ((List<EObject>)templateBodyO)){
				EObject toAdd = evaluate(rootObject,tiRootPackage, currentInputMetaClass);
				if(toAdd!=null){
					tiResource.getContents().add(toAdd);
				}
			}
		//or a single element
		} else {
			EObject tiObject = evaluate((EObject)templateBodyO,tiRootPackage, currentInputMetaClass);
			tiResource.getContents().add(tiObject);
			templateInstanceRoot = tiObject;
		}
	}
	
	/**
	 * @param tObject eObject in the template language
	 * @param tiPackage an ePackage in the template instance  
	 * @return Returns the representative of parent in the template instance
	 */
	private EObject evaluate(EObject tObject, EPackage tiRootPackage, EClass currentInputMetaClass) throws InterpreterException{
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
				if(tReferenceObject instanceof Placeholder){
					evaluatePlaceHolder((Placeholder)tReferenceObject,tObject,tiObject, currentInputMetaClass);
				} else if(tReferenceObject instanceof ForEach){
					evaluateForLoop((ForEach)tReferenceObject,tObject,tiObject, currentInputMetaClass);
				} else if(tReferenceObject instanceof If){
					evaluateIfCondition((If)tReferenceObject,tObject,tiObject, currentInputMetaClass);
				} else if(tReferenceObject instanceof IfElse){
					evaluateIfElseCondition((IfElse)tReferenceObject,tObject,tiObject, currentInputMetaClass);
				} else throw new TemplateMetamodelException("Unkown TemplateConcept: " + tReferenceObject.getClass());
			//Evaluate recursively
			} else {
				evaluateTReference(tObject,tReferenceObject,tiObject,tiRootPackage, currentInputMetaClass);
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
			EObject tObject,EObject tiObject, EClass currentInputMetaClass) throws InterpreterException{
		
		Object evaluatedObject = expressionChecker.evaluateExpression(
				currentInputMetaClass, 
				placeHolder.getExpression(), //expression
				currentInputObject);
				//context.getVariableValue(variableName)); //context for only possible variable;
		
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
		if(!tAttributeElementClass.getName().startsWith(TemplateMetamodelAssumptions.FEATURE))
			throw new InterpreterException("AttributeElements should begin with "+TemplateMetamodelAssumptions.FEATURE);
		String derivedTIAttributeElementName = tAttributeElementClass.getName().substring(TemplateMetamodelAssumptions.FEATURE.length());
		
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
	
	private void evaluateForLoop(ForEach forLoop,EObject tObject,EObject tiObject, EClass currentInputMetaClass) throws InterpreterException{
		//Find forBody
		Object forBodyO = forLoop.eGet(forLoop.eClass().getEStructuralFeature(TemplateMetamodelAssumptions.REFERENCE_FOR_BODY));
		if(forBodyO==null) throw new TemplateMetamodelException("ForLoop without body: " + forLoop);
		
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
		
		Collection<?> inputCollection = null;
		try{
			inputCollection = (Collection<?>) expressionChecker.evaluateExpression(
					currentInputMetaClass, 
					forLoop.getExpression(), //expression
					currentInputObject); //context
		// TODO remove this
		} catch (StackOverflowError e) {
			e.printStackTrace();
		}
		/** Global **/
		//String varibleName = "self"; //The only variable possible as for now
		
		// TODO remove this
		if (inputCollection == null) {
			inputCollection = new ArrayList<Object>();
		}
		//THE FORLOOP
		for(Object o : inputCollection){
			if(!(o instanceof EObject)){
				throw new TemplateException("For-loop methodCall ("+forLoop.getExpression()+") does not return a list of ModelElements but Attributes");
			}
			context.pushVariable(variableName,(EObject)o);
			//BODY (can contain multiple elements)
			if(forBodyO instanceof List){
				for(EObject forBody : (List<EObject>)forBodyO){
					((List<EObject>)tiObject.eGet(tiReference)).add(evaluate(forBody, tiRootPackage, currentInputMetaClass));
				}
			} else {
				((List<EObject>)tiObject.eGet(tiReference)).add(evaluate((EObject)forBodyO, tiRootPackage, currentInputMetaClass));
			}
			context.pullVariable(variableName);
		}
	}
	
	private void evaluateIfCondition(If ifCondition,EObject tObject,EObject tiObject, EClass currentInputMetaClass) throws InterpreterException{
		Object ifBodyO = ifCondition.eGet(ifCondition.eClass().getEStructuralFeature(TemplateMetamodelAssumptions.REFERENCE_IF_BODY));
		if(ifBodyO==null) throw new TemplateMetamodelException("IfCondition without body: " + ifCondition);
		
		//Find tiReference
		EReference tiReference = null;
		for(EReference ref : tiObject.eClass().getEReferences()){
			if(ifCondition.eContainingFeature().getName().matches(ref.getName())){
				tiReference = ref;
				break;
			}
		}
		if(tiReference == null) throw new TemplateMetamodelException("For-Loop: Didn't find reference " + ifCondition.eContainingFeature().getName() + " in tiObject");
		
		evaluateIf(ifCondition.getExpression(),ifBodyO,null,tObject,tiObject,tiReference, currentInputMetaClass);
	}
	
	private void evaluateIfElseCondition(IfElse ifElseCondition,EObject tObject,EObject tiObject, EClass currentInputMetaClass) throws InterpreterException{
		Object ifBodyO = ifElseCondition.eGet(ifElseCondition.eClass().getEStructuralFeature(TemplateMetamodelAssumptions.REFERENCE_IF_BODY));
		if(ifBodyO==null) throw new TemplateMetamodelException("IfElseCondition without ifBody: " + ifElseCondition);
		Object elseBodyO = ifElseCondition.eGet(ifElseCondition.eClass().getEStructuralFeature(TemplateMetamodelAssumptions.REFERENCE_ELSE_BODY));
		if(elseBodyO==null) throw new TemplateMetamodelException("IfElseCondition without elseBody: " + ifElseCondition);
		
		//Find tiReference
		EReference tiReference = null;
		for(EReference ref : tiObject.eClass().getEReferences()){
			if(ifElseCondition.eContainingFeature().getName().matches(ref.getName())){
				tiReference = ref;
				break;
			}
		}
		if(tiReference == null) throw new TemplateMetamodelException("For-Loop: Didn't find reference " + ifElseCondition.eContainingFeature().getName() + " in tiObject");
		
		evaluateIf(ifElseCondition.getExpression(),ifBodyO,elseBodyO,tObject,tiObject,tiReference, currentInputMetaClass);
	}
	
	private void evaluateIf(String expression, Object ifBodyO, Object elseBodyO, EObject tObject, EObject tiObject, EReference tiReference, EClass currentInputMetaClass) throws InterpreterException{
		Boolean condition = null;
		condition = (Boolean)expressionChecker.evaluateExpression(
				currentInputMetaClass, //TODO put correct inputMetaClass 
				expression, //expression
				currentInputObject);
				//context.getVariableValue(variableName)); //context for only possible variable
		
		// TODO remove this
		if (condition == null) {
			condition = Boolean.TRUE;
		}
		
		//IF-CONDITION
		if(condition){
			//ifBody
			if(ifBodyO instanceof List){
				for(EObject ifBody : (List<EObject>)ifBodyO){
					((List<EObject>)tiObject.eGet(tiReference)).add(evaluate(ifBody, tiRootPackage, currentInputMetaClass));
				}
			} else {
				((List<EObject>)tiObject.eGet(tiReference)).add(evaluate((EObject)ifBodyO, tiRootPackage, currentInputMetaClass));
			}
		} else {
			//elseBody (may be null)
			if(elseBodyO!=null){
				if(elseBodyO instanceof List){
					for(EObject elseBody : (List<EObject>)elseBodyO){
						((List<EObject>)tiObject.eGet(tiReference)).add(evaluate(elseBody, tiRootPackage, currentInputMetaClass));
					}
				} else {
					((List<EObject>)tiObject.eGet(tiReference)).add(evaluate((EObject)elseBodyO, tiRootPackage, currentInputMetaClass));
				}
			}
		}
	}
	
	private void evaluateTReference(EObject tObject, EObject tReferenceObject, EObject tiObject, EPackage tiRootPackage, EClass currentInputMetaClass) throws InterpreterException{
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
			((List<EObject>)tiObject.eGet(tiReference)).add(evaluate(tReferenceObject, tiRootPackage, currentInputMetaClass));
		} else {
			tiObject.eSet(tiReference, evaluate(tReferenceObject, tiRootPackage, currentInputMetaClass));
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
