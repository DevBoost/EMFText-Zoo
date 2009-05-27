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
package org.emftext.language.java.util.classifiers;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.types.PrimitiveType;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.types.TypesFactory;
import org.emftext.language.java.util.JavaClasspathUtil;
import org.emftext.language.java.util.types.TypeReferenceUtil;

public class ClassUtil {
	
	/**
	 * Recursively collects all super types (extended classes and implemented interfaces)
	 * of the given class.
	 * 
	 * @param _this
	 * @param classifierList the list for the result
	 */
	public static void collectAllSuperClassifiers(Class _this, 
			EList<ConcreteClassifier> classifierList) {
		
		//collects all superclasses
		Class superClass =  _this;
		while (superClass != null && !superClass.eIsProxy() && 
				!superClass.equals(JavaClasspathUtil.getObjectClass(_this))) {
			superClass = getSuperClass(superClass);
			if (superClass != null) {
				classifierList.add(superClass);
			}
		}
		
		EList<ConcreteClassifier> superClassList = 
			new BasicEList<ConcreteClassifier>(classifierList);
		
		//collect all implemented interfaces
		classifierList.addAll(
				InterfaceUtil.getAllSuperInterfaces(
						_this.getImplements()));
		
		//collect all implemented interfaces of super classes
		for(Classifier superClassifier : superClassList) {
			if (superClassifier instanceof Class) {
				classifierList.addAll(
						InterfaceUtil.getAllSuperInterfaces(
								((Class)superClassifier).getImplements()));
			}
		}
	}
	
	/**
	 * @param _this
	 * @return the direct super class
	 */
	public static Class getSuperClass(Class _this) {
		TypeReference superClassReference = _this.getExtends();
		if (superClassReference == null) {
			superClassReference = _this.getDefaultExtends();
		}
		Type result = TypeReferenceUtil.getTarget(superClassReference);
		if (result instanceof Class) {
			return (Class) result;
		}
		return null;
	}
	
	/**
	 * @param _this
	 * @return primitive type, if the class can be wrapped
	 */
	public static PrimitiveType unWrapPrimitiveType(Class _this) {	
		if (JavaClasspathUtil.getClass("Boolean", _this).equals(_this)) {
			return TypesFactory.eINSTANCE.createBoolean();
		}
		if (JavaClasspathUtil.getClass("Byte", _this).equals(_this)) {
			return TypesFactory.eINSTANCE.createByte();
		}
		if (JavaClasspathUtil.getClass("Character", _this).equals(_this)) {
			return TypesFactory.eINSTANCE.createChar();
		}
		if (JavaClasspathUtil.getClass("Float", _this).equals(_this)) {
			return TypesFactory.eINSTANCE.createFloat();
		}
		if (JavaClasspathUtil.getClass("Double", _this).equals(_this)) {
			return TypesFactory.eINSTANCE.createDouble();
		}
		if (JavaClasspathUtil.getClass("Integer", _this).equals(_this)) {
			return TypesFactory.eINSTANCE.createInt();
		}
		if (JavaClasspathUtil.getClass("Long", _this).equals(_this)) {
			return TypesFactory.eINSTANCE.createLong();
		}
		if (JavaClasspathUtil.getClass("Short", _this).equals(_this)) {
			return TypesFactory.eINSTANCE.createShort();
		}
		if (JavaClasspathUtil.getClass("Void", _this).equals(_this)) {
			return TypesFactory.eINSTANCE.createVoid();
		}
		return null;
	}



}
