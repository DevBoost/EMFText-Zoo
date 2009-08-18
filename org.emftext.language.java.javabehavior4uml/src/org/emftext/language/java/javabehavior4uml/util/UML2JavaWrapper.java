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
package org.emftext.language.java.javabehavior4uml.util;

import java.util.Arrays;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.JavaUniquePathConstructor;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.containers.ContainersFactory;
import org.emftext.language.java.javabehavior4uml.Javabehavior4umlFactory;
import org.emftext.language.java.javabehavior4uml.UMLClassWrapper;
import org.emftext.language.java.javabehavior4uml.UMLPropertyWrapper;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.TypesFactory;

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
		wrapper.setName(umlClass.getName());
		wrapper.setUmlClass(umlClass);
		
		for(Property umlProperty : umlClass.getAttributes()) {
			UMLPropertyWrapper wrappedPropery = wrapProperty(umlProperty);
			wrapper.getMembers().add(wrappedPropery);
		}
		
		return wrapper;
	}
	
	public static UMLPropertyWrapper wrapProperty(Property umlProperty) {
		UMLPropertyWrapper wrapper = f.createUMLPropertyWrapper();
		wrapper.setName(umlProperty.getName());
		wrapper.setUmlProperty(umlProperty);
		
		ClassifierReference type = TypesFactory.eINSTANCE.createClassifierReference();
		if (umlProperty.getType().getName().equals("String")) {
			JavaClasspath cp = JavaClasspath.get(umlProperty);
			Classifier stringCLass = (Classifier) EcoreUtil.resolve(
					cp.getClassifier("java.lang.String"), umlProperty);
			type.setTarget(stringCLass);
		}
		else {
			UMLClassWrapper wrapperProxy = f.createUMLClassWrapper();
			URI proxyURI = JavaUniquePathConstructor.getClassifierURI(
					umlProperty.getType().getPackage().getName() + "." + 
					umlProperty.getType().getName());
			((InternalEObject)wrapperProxy).eSetProxyURI(proxyURI);
			type.setTarget(wrapperProxy);
		}
		wrapper.setTypeReference(type);
		
		return wrapper;
	}

}
