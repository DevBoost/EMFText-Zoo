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
package org.emftext.language.java.util;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.annotations.AnnotationInstance;
import org.emftext.language.java.classifiers.AnonymousClass;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.containers.CompilationUnit;

/**
 * Convenient methods to navigate a Java model. 
 */
public class JavaUtil {

	public static String getName(NamedElement element) {
		return element.getName();
	}
	
	public static void setName(NamedElement element, String name) {
		element.setName(name);
	}
	
	/**
	 * @param objectContext
	 * @return all default imports (<code>java.lang</code>)
	 */
	public static EList<ConcreteClassifier> getDefaultImports(EObject objectContext) {
		return JavaClasspath.get(objectContext).getDefaultImports();
	}
	
	/**
	 * Finds the containing classifier for the given element.
	 * 
	 * @param value
	 * @return containing classifier
	 */
	public static ConcreteClassifier findContainingClassifier(EObject value) {
		while (!(value instanceof ConcreteClassifier) && value != null) {
			value = value.eContainer();
		}
		return (ConcreteClassifier) value;
	}
	
	/**
	 * Finds the containing anonymous class for the given element.
	 * 
	 * @param value
	 * @return containing anonymous class 
	 */
	public static AnonymousClass findContainingAnonymousClass(EObject value) {
		while (!(value instanceof AnonymousClass) 
				&& !(value instanceof ConcreteClassifier) //do not jump over other classifiers 
				&& value != null) {
			value = value.eContainer();
		}
		if (!(value instanceof AnonymousClass)) {
			return null;
		}
		return (AnonymousClass) value;
	}
	
	/**
	 * Finds the containing compilation unit for the given element.
	 * 
	 * @param value
	 * @return containing compilation unit
	 */
	public static CompilationUnit findContainingCompilationUnit(EObject value) {
		while (!(value instanceof CompilationUnit) && value != null) {
			value = value.eContainer();
		}
		return (CompilationUnit) value;
	}

	/**
	 * Finds the containing annotation instance for the given element.
	 * 
	 * @param value
	 * @return containing annotation instance
	 */
	public static AnnotationInstance findContainingAnnotationInstance(EObject value) {
		while (!(value instanceof AnnotationInstance) && value != null) {
			value = value.eContainer();
		}
		return (AnnotationInstance) value;
	}
	
	public static List<String> findPackageName(EObject value) {
		CompilationUnit cu = findContainingCompilationUnit(value);
		if (cu == null) {
			return null;
		}
		
		int idx = cu.getNamespaces().size();
		if(JavaUtil.getName(cu) != null) {
			char[] fullName = JavaUtil.getName(cu).toCharArray();
			for(int i = 0; i < fullName.length; i++) {
				if (fullName[i] == '$') {
					idx--;
				}
			}
		}
		return cu.getNamespaces().subList(0, idx);
	}
}
