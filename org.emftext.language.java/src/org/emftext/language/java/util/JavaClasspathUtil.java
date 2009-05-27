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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.classifiers.Interface;

/**
 * Utility methods to for common class path queries.
 */
public class JavaClasspathUtil {
	
	/**
	 * Finds the <code>org.emftext.language.java.classifiers.Class</code>
	 * representing the class with the given name located in <code>java.lang</code>.
	 * 
     * @param objectContext a context object whose resource set is used to obtain the class model element
	 * @return the Class
	 */
	public static Class getClass(String name, EObject objectContext) {
		if (objectContext.eResource() == null) {
			throw new IllegalArgumentException("object context element must have a resource");
		}
		Class classClass = (Class) JavaClasspath.get(objectContext).getClassifier(
				"java.lang." + name);
		classClass = (Class) EcoreUtil.resolve(classClass, objectContext);
		return classClass;
	}
	
	public static Interface getInterface(String name, EObject objectContext) {
		if (objectContext.eResource() == null) {
			throw new IllegalArgumentException("object context element  must have a resource");
		}
		ConcreteClassifier classClass = JavaClasspath.get(objectContext).getClassifier(
				"java.lang." + name);
		return (Interface) EcoreUtil.resolve(classClass, objectContext);
	}
	
	/**
	 * Finds the <code>org.emftext.language.java.classifiers.Class</code>
	 * representing <code>java.lang.Class</code>.
	 * 
     * @param objectContext a context object whose resource set is used to obtain the class model element
	 * @return the Class
	 */
	public static Class getClassClass(EObject objectContext)  {
		return getClass("Class", objectContext);
	}
	
	/**
	 * Finds the <code>org.emftext.language.java.classifiers.Class</code>
	 * representing <code>java.lang.Object</code>.
	 * 
     * @param objectContext a context object whose resource set is used to obtain the class model element
	 * @return the Class
	 */
	public static Class getObjectClass(EObject objectContext)  {
		return getClass("Object", objectContext);
	}
	
	/**
	 * Finds the <code>org.emftext.language.java.classifiers.Class</code>
	 * representing <code>java.lang.String</code>.
	 * 
     * @param objectContext a context object whose resource set is used to obtain the class model element
	 * @return the Class
	 */
	public static Class getStringClass(EObject objectContext) {
		return getClass("String", objectContext);
	}
	
	public static Interface getAnnotationClass(EObject objectContext) {
		if (objectContext.eResource() == null) {
			throw new IllegalArgumentException("object context element must have a resource");
		}
		Interface annotationClass = (Interface) EcoreUtil.resolve(
				JavaClasspath.get(objectContext).getClassifier("java.lang.annotation.Annotation"), objectContext);
		return annotationClass;
	}
	

}
