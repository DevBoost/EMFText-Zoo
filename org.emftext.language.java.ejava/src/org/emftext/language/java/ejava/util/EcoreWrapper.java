package org.emftext.language.java.ejava.util;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.JavaUniquePathConstructor;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.ejava.EClassifierClassWrapper;
import org.emftext.language.java.ejava.EClassifierInterfaceWrapper;
import org.emftext.language.java.ejava.EClassifierWrapper;
import org.emftext.language.java.ejava.EOperationWrapper;
import org.emftext.language.java.ejava.EPackageWrapper;
import org.emftext.language.java.ejava.EStructuralFeatureGetWrapper;
import org.emftext.language.java.ejava.EjavaFactory;
import org.emftext.language.java.generics.GenericsFactory;
import org.emftext.language.java.generics.QualifiedTypeArgument;
import org.emftext.language.java.parameters.Parameter;
import org.emftext.language.java.parameters.ParametersFactory;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.PrimitiveType;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.types.TypesFactory;
import org.emftext.language.java.types.TypesPackage;
import org.emftext.language.java.types.Void;
import org.emftext.language.java.util.containers.CompilationUnitUtil;
import org.emftext.language.java.util.members.MemberContainerUtil;
import org.emftext.language.java.util.types.PrimitiveTypeUtil;

/**
 * Wraps an Ecore model in an eJava model. This was, the Ecore types can be interpreted as 
 * Java types by JaMoPP.
 *
 */
public class EcoreWrapper {
	
	public static void wrap(EPackageWrapper mainEPackageWrapper) {
		EMap<EList<String>, EPackage> ePackages = findEPackagesInScope(mainEPackageWrapper);
		
		for(EList<String> namespaces : ePackages.keySet()) {
			wrapEPackage(ePackages.get(namespaces), namespaces, mainEPackageWrapper);
		}
		
	}

	public static void wrapEPackage(EPackage ePackage, EList<String> namespaces, EPackageWrapper mainEPackageWrapper) {
		EPackageWrapper wrapper = null;
		Resource wrapperResource = null;
		JavaClasspath cp = JavaClasspath.get(mainEPackageWrapper);
		String packageName = "";
		for(String s : namespaces) { packageName += s + "."; }
		
		if (mainEPackageWrapper.getNamespaces().equals(namespaces)) {
			wrapper = mainEPackageWrapper;
			wrapperResource = mainEPackageWrapper.eResource();
			wrapper.setEPackage(ePackage);
		}
		
		for(EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (wrapper == null) {
				URI uri = JavaUniquePathConstructor.getJavaFileResourceURI(packageName + eClassifier.getName());
				ResourceSet rs = mainEPackageWrapper.eResource().getResourceSet();
				wrapperResource = rs.getResource(uri, false);
				if (wrapperResource == null) {
					wrapperResource = new ResourceImpl(uri);
					rs.getResources().add(wrapperResource);
				}
				else {
					wrapperResource.getContents().clear();
				}
				wrapper = EjavaFactory.eINSTANCE.createEPackageWrapper();
				wrapperResource.getContents().add(wrapper);
				wrapper.getNamespaces().addAll(namespaces);
				wrapper.setEPackage(ePackage);
			}
			wrapEClassifier(eClassifier, wrapper);
			cp.registerClassifier(packageName, eClassifier.getName(), wrapperResource.getURI());
		}
	}

	public static EClassifierWrapper wrapEClassifier(EClassifier eClassifier, EPackageWrapper ePackageWrapper)  {
		EClassifierWrapper wrapper = (EClassifierWrapper) CompilationUnitUtil.getClassifier(ePackageWrapper, eClassifier.getName());
		
		if (wrapper == null) {
			wrapper = EjavaFactory.eINSTANCE.createEClassifierInterfaceWrapper();
			wrapper.setName(eClassifier.getName());
			ePackageWrapper.getClassifiers().add(wrapper);
		}
		wrapper.setEClassifier(eClassifier);
		wrapper.setEClassifier(eClassifier);

		if (eClassifier instanceof EClass) {
			EClass eClass = (EClass)eClassifier;
			EList<TypeReference> superTypeList = null;
			if (wrapper instanceof EClassifierInterfaceWrapper) {
				superTypeList = 
					((EClassifierInterfaceWrapper)wrapper).getExtends();
			}
			else /*wrapper instanceof EClassifierClassWrapper*/ {
				superTypeList = 
					((EClassifierClassWrapper)wrapper).getImplements();
			}
			
			for(EClass extendedEClass : eClass.getESuperTypes()) {
				superTypeList.add(createTypeReferenceForEClassifier(extendedEClass));
			}
			JavaClasspath cp = JavaClasspath.get(eClassifier);
			ClassifierReference eObjectRef = TypesFactory.eINSTANCE.createClassifierReference();
			eObjectRef.setTarget(cp.getClassifier("org.eclipse.emf.ecore.EObject"));
			superTypeList.add(eObjectRef);
			for(EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()) {
				wrapEStructuralFeatureForGet(eStructuralFeature, wrapper);
				if (!eStructuralFeature.isMany()) {
					wrapEStructuralFeatureForSet(eStructuralFeature, wrapper);
				}
			}
			for(EOperation eOperation : eClass.getEOperations()) {
				wrapEOperation(eOperation, wrapper);
			}
		}
		
		return wrapper;
	}

	public static void wrapEStructuralFeatureForGet(
			EStructuralFeature eStructuralFeature, EClassifierWrapper eClassifierWrapper) {
		
		EStructuralFeatureGetWrapper wrapper = EjavaFactory.eINSTANCE.createEStructuralFeatureGetWrapper();
		wrapper.setEStructuralFeature(eStructuralFeature);
		eClassifierWrapper.getMembers().add(wrapper);
		
		wrapper.setName("get" + firstToUpperCase(eStructuralFeature.getName()));
		wrapper.setType(createTypeReferenceForETypedElement(eStructuralFeature));
	}
	
	public static void wrapEStructuralFeatureForSet(
			EStructuralFeature eStructuralFeature, EClassifierWrapper eClassifierWrapper) {
		
		EStructuralFeatureGetWrapper wrapper = EjavaFactory.eINSTANCE.createEStructuralFeatureGetWrapper();
		wrapper.setEStructuralFeature(eStructuralFeature);
		eClassifierWrapper.getMembers().add(wrapper);
		
		wrapper.setName("set" + firstToUpperCase(eStructuralFeature.getName()));
		wrapper.setType(TypesFactory.eINSTANCE.createVoid());
		
		Parameter parameter = ParametersFactory.eINSTANCE.createOrdinaryParameter();
		parameter.setName("value");
		parameter.setType(createTypeReferenceForETypedElement(eStructuralFeature));
		wrapper.getParameters().add(parameter);
	}
	
	private static EMap<EList<String>, EPackage> findEPackagesInScope(EPackageWrapper context) {
		Resource eJavaResource = context.eResource();
		if (eJavaResource == null) {
			return ECollections.emptyEMap();
		}
		ResourceSet rs = eJavaResource.getResourceSet();
		if (rs == null) {
			return ECollections.emptyEMap();
		}
		
		String fileName = context.getNamespaces().get(0) + ".ecore";
		URI ecoreURI = eJavaResource.getURI().trimSegments(
				1 + context.getNamespaces().size()).appendSegment(fileName);
		Resource ecoreResource = rs.getResource(ecoreURI, true);
		EcoreUtil.resolveAll(ecoreResource);
		
		EMap<EList<String>, EPackage> result = new BasicEMap<EList<String>, EPackage>();
		for(Resource r : rs.getResources()) {
			if (!r.getContents().isEmpty() && r.getContents().get(0) instanceof EPackage) {
				collectEPackages((EPackage)r.getContents().get(0), new BasicEList<String>(), result);
			}
		}
		
		return result;
	}

	private static void collectEPackages(EPackage ePackage,
			EList<String> basePackageName, EMap<EList<String>, EPackage> result) {
		basePackageName.add(ePackage.getName());
		result.put(ECollections.unmodifiableEList(basePackageName), ePackage);
		for(EPackage subEPackage : ePackage.getESubpackages()) {
			collectEPackages(subEPackage, new BasicEList<String>(basePackageName), result);
		}
		
	}
	
	public static void wrapEOperation(
			EOperation eOperation, EClassifierWrapper eClassifierWrapper) { 
		EOperationWrapper wrapper = (EOperationWrapper) MemberContainerUtil.getOnlyMethodWithName(
				eClassifierWrapper, eOperation.getName());
		
		if (wrapper == null) {
			wrapper = EjavaFactory.eINSTANCE.createEOperationWrapper();
			wrapper.setName(eOperation.getName());
			eClassifierWrapper.getMembers().add(wrapper);
		}
		wrapper.setEOperation(eOperation);
		wrapper.setType(createTypeReferenceForETypedElement(eOperation));
		
		for(EParameter eParameter : eOperation.getEParameters()) {
			Parameter parameter = ParametersFactory.eINSTANCE.createOrdinaryParameter();
			parameter.setName(eParameter.getName());
			parameter.setType(createTypeReferenceForETypedElement(eParameter));
			wrapper.getParameters().add(parameter);
		}
	}
	
	private static Type getType(EClassifier eClassifier)  {
		if (eClassifier == null) {
			return TypesFactory.eINSTANCE.createVoid();
		}
		
		String javaTypeName = null;
		if (eClassifier instanceof EClass) {
			javaTypeName = getFullPackageName(eClassifier.getEPackage()) + "." + eClassifier.getName();
		}
		else /*if (eClassifier instanceof EDataType)*/ {
			javaTypeName = ((EDataType)eClassifier).getInstanceTypeName();
			if (!javaTypeName.contains(".")) {
				//primitive type
				return (Type) TypesFactory.eINSTANCE.create(
						(EClass) TypesPackage.eINSTANCE.getEClassifier(
								firstToUpperCase(javaTypeName)));
			}
			
		}
		JavaClasspath cp = JavaClasspath.get(eClassifier);
		return cp.getClassifier(javaTypeName);
	}
	
	private static TypeReference createTypeReferenceForEClassifier(EClassifier eClassifier) {
		Type type = getType(eClassifier);
		if (type instanceof TypeReference) {
			return (TypeReference) type;
		}
		ClassifierReference ref = TypesFactory.eINSTANCE.createClassifierReference();
		ref.setTarget((Classifier)type);
		return ref;
	}
	
	private static TypeReference createTypeReferenceForETypedElement(ETypedElement eTypedElement) {
		
		TypeReference baseTypeRef = createTypeReferenceForEClassifier(eTypedElement.getEType());
		if (baseTypeRef instanceof Void) {
			return baseTypeRef;
		}
		if (!eTypedElement.isMany()) {
			return baseTypeRef;
		}
		else {
			if (baseTypeRef instanceof PrimitiveType) {
				baseTypeRef = TypesFactory.eINSTANCE.createClassifierReference();
				((ClassifierReference)baseTypeRef).setTarget(PrimitiveTypeUtil.wrapPrimitiveType((PrimitiveType)baseTypeRef));
			}
			Classifier listType = JavaClasspath.get(eTypedElement).getClassifier("org.eclipse.emf.common.util.EList");
			ClassifierReference listTypeRef = TypesFactory.eINSTANCE.createClassifierReference();
			listTypeRef.setTarget((Classifier)listType);
			QualifiedTypeArgument typeArgument = GenericsFactory.eINSTANCE.createQualifiedTypeArgument();
			typeArgument.setType(baseTypeRef);
			listTypeRef.getTypeArguments().add(typeArgument);
			return listTypeRef;
		}
	}
	
	private static String getFullPackageName(EPackage ePackage) {
		String s = ePackage.getName();
		while (ePackage.getESuperPackage() != null) {
			ePackage = ePackage.getESuperPackage();
			s = ePackage.getName() + "." + s;
		}
		return s;
	}
	
	private static String firstToUpperCase(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

}
