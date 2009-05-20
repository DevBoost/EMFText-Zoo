package org.emftext.language.java.javabehavior4uml.util;

import java.util.Arrays;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.emftext.language.java.JavaUniquePathConstructor;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.containers.ContainersFactory;
import org.emftext.language.java.javabehavior4uml.Javabehavior4umlFactory;
import org.emftext.language.java.javabehavior4uml.UMLClassWrapper;
import org.emftext.language.java.javabehavior4uml.UMLPropertyWrapper;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.TypesFactory;
import org.emftext.language.java.util.JavaClasspathUtil;
import org.emftext.language.java.util.JavaUtil;

public class UML2JavaWrapper {
	
	private static Javabehavior4umlFactory f = Javabehavior4umlFactory.eINSTANCE;
	
	public static EList<CompilationUnit> wrapPackage(Package umlPackage) {
		EList<CompilationUnit> result = new BasicEList<CompilationUnit>();
		for(PackageableElement element : umlPackage.getPackagedElements()) {
			if(element instanceof Class) {
				UMLClassWrapper wrappedClass = wrapClass((Class) element);
				
				CompilationUnit cu = ContainersFactory.eINSTANCE.createCompilationUnit();
				cu.getNamespaces().addAll(
						Arrays.asList(umlPackage.getName().split("\\.")));
				
				cu.getClassifiers().add(wrappedClass);
				
				result.add(cu);
			}
		}
		return result;
	}
	
	public static UMLClassWrapper wrapClass(Class umlClass) {
		UMLClassWrapper wrapper = f.createUMLClassWrapper();
		JavaUtil.setName(wrapper, umlClass.getName());
		wrapper.setUmlClass(umlClass);
		
		for(Property umlProperty : umlClass.getAttributes()) {
			UMLPropertyWrapper wrappedPropery = wrapProperty(umlProperty);
			wrapper.getMembers().add(wrappedPropery);
		}
		
		return wrapper;
	}
	
	public static UMLPropertyWrapper wrapProperty(Property umlProperty) {
		UMLPropertyWrapper wrapper = f.createUMLPropertyWrapper();
		JavaUtil.setName(wrapper, umlProperty.getName());
		wrapper.setUmlProperty(umlProperty);
		
		ClassifierReference type = TypesFactory.eINSTANCE.createClassifierReference();
		if (umlProperty.getType().getName().equals("String")) {
			type.setTarget(JavaClasspathUtil.getStringClass(umlProperty));
		}
		else {
			UMLClassWrapper wrapperProxy = f.createUMLClassWrapper();
			URI proxyURI = JavaUniquePathConstructor.getClassifierURI(
					umlProperty.getType().getPackage().getName() + "." + 
					umlProperty.getType().getName());
			((InternalEObject)wrapperProxy).eSetProxyURI(proxyURI);
			type.setTarget(wrapperProxy);
		}
		wrapper.setType(type);
		
		return wrapper;
	}

}
