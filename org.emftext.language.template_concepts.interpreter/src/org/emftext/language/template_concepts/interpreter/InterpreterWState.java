package org.emftext.language.template_concepts.interpreter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.template_concepts.ExpressionChecker;
import org.emftext.language.template_concepts.ForLoop;
import org.emftext.language.template_concepts.IfCondition;
import org.emftext.language.template_concepts.Placeholder;
import org.emftext.language.template_concepts.Template;
import org.emftext.language.template_concepts.impl.PlaceholderImpl;
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
		EObject inputMetaClass = template.getInputMetaClass();
		if(!(inputMetaClass instanceof EClass)){
			throw new TemplateMetamodelException("inputMetaClass is no EClass");
		}
		EClass rootElementClass = (EClass)inputMetaClass;
		//Get root package in template instance
		tiRootPackage = rootElementClass.getEPackage();
		Resource tiResource = new ResourceImpl();
		
		//find templateBody
		EStructuralFeature templateBodySF = template.eClass().getEStructuralFeature(TemplateMetamodelAssumptions.CLASS_TEMPLATE_BODY);
		if(templateBodySF==null) throw new TemplateMetamodelException("Template has no body");
		EObject templateBody = (EObject)template.eGet(templateBodySF);
		if(templateBody == null) throw new TemplateMetamodelException("Template has no body");
		
		
		//Add for all non template instances respective language instances
		for(EObject rootObject : templateBody.eContents()){
			EObject toAdd = evaluate(rootObject,tiRootPackage);
			if(toAdd!=null){
				tiResource.getContents().add(toAdd);
			}
		}
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
			if(tReferenceObject instanceof Placeholder){
				evaluatePlaceHolder((Placeholder)tReferenceObject,tObject,tiObject);
			} else if(tReferenceObject instanceof ForLoop){
				//TODO evaluateForLoop(tReferenceObject,tObject,tiObject);
			} else if(tReferenceObject instanceof IfCondition){
				//TODO evaluateIfCondition(tReferenceObject,tObject,tiObject);
			} else {
				//TODO evaluateTReference(tObject,tReferenceObject,tiObject,tiRootPackage);
			}
		}
		
		//Now just copy attributes which have not been treated as PlaceHolder
		for(EAttribute tAttributeClass : tObject.eClass().getEAllAttributes()){
			if(!treatedByPlaceholderList.contains(tAttributeClass)){
				String attributeName = tAttributeClass.getName();
				//find respective langParentAttributeClass
				EAttribute tiAttributeClass = null;
				for(EAttribute attClass : tiObject.eClass().getEAttributes()){
					if(attClass.getName().matches(attributeName)){
						tiAttributeClass = attClass;
						break;
					}
				}
				if(tiAttributeClass==null){
					throw new TemplateMetamodelException("No tiAttributeClass found for tAttributeClass " + tObject.eClass().getName()+"."+attributeName);
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
		
		Object evaluatedObject = null;
		//TODO mseifert: evaluatedObject = expressionChecker. ....
		//TODO You probably need to convert my "context" into your ocl-context-EObject
		
		//placeHolder extends from PlaceHolder and the tiAttributeClass
		List<EClass> superClasses = placeHolder.eClass().getESuperTypes();
		if(superClasses.size()!=2) throw new TemplateMetamodelException("The type of a concrete placeholder extends from PlaceHolder and the extended attribute");
		EClass attributeElement = null;
		for(EClass superClass : superClasses){
			if(superClass.getName()!=Placeholder.class.getName()){
				attributeElement = superClass;
			}
		}
		if(attributeElement==null) throw new TemplateMetamodelException("The type of a concrete placeholder extends from PlaceHolder and the extended attribute");
		
		//derive tiAttributeElementName
		if(!attributeElement.getName().startsWith(TemplateMetamodelAssumptions.ATT))
			throw new InterpreterException("AttributeElements should begin with "+TemplateMetamodelAssumptions.ATT);
		String derivedTIAttributeElementName = attributeElement.getName().substring(TemplateMetamodelAssumptions.ATT.length());
		
		//find tiAttributeElement
		EObject tiAttributeElement = findInPackageAndInstantiate(derivedTIAttributeElementName, tiRootPackage);
		if(tiAttributeElement==null) throw new TemplateMetamodelException("Didn't find tiAttributeElement with name: " + derivedTIAttributeElementName);
		
		//contains exactly one attribute
		if(tiAttributeElement.eClass().getEAllAttributes().size()!=1){
			throw new TemplateMetamodelException("An attributeElement only contains one attribute, but it contains " + tiAttributeElement.eClass().getEAllAttributes().size() + " attributes");
		}
		EAttribute tiAttribute = tiAttributeElement.eClass().getEAllAttributes().get(0);
		tiAttributeElement.eSet(tiAttribute, evaluatedObject);
		
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
	
//	public EPackage findRootPackage(EPackage pack){
//		if(pack.getESuperPackage()!=null) return findRootPackage(pack.getESuperPackage());
//		return pack;
//	}
	
	/**
	 * TODO make className being an EClass
	 * @param className
	 * @param currentPackage
	 * @return
	 */
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
			throw new TemplateException("Couldn't instantiate " + className);
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
