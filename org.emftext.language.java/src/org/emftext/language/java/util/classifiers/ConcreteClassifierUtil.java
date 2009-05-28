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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.classifiers.Interface;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.util.JavaClasspathUtil;
import org.emftext.language.java.util.modifiers.ModifiableUtil;
import org.emftext.language.java.util.types.ClassifierReferenceUtil;

/**
 * A utility class that provides methods that belong to class 
 * ConcreteClassifier, but can not go there, because ConcreteClassifier 
 * is generated.
 */
public class ConcreteClassifierUtil {
	
	public static EList<ConcreteClassifier> getAllInnerClassifiers(ConcreteClassifier _this) {
		EList<ConcreteClassifier> innerClassifierList = new BasicEList<ConcreteClassifier>();
		
		innerClassifierList.addAll(
				JavaClasspath.get(_this).getInnnerClassifiers(_this));
		
		for(ConcreteClassifier superClassifier : ClassifierUtil.getAllSuperClassifiers(_this)) {
			EList<ConcreteClassifier> superInnerList = 
				JavaClasspath.get(_this).getInnnerClassifiers(superClassifier);
			
			for(ConcreteClassifier superInner : superInnerList) {
				if (superInner.eIsProxy()) {
					superInner = (ConcreteClassifier) EcoreUtil.resolve(superInner, _this);
				}
				if(!superInner.eIsProxy() && !ModifiableUtil.isHidden(superInner, _this)) {
					innerClassifierList.add(superInner);
				}
			}
		}
		
		return innerClassifierList;
	}
	
	public static EList<ClassifierReference> getSuperTypeReferences(ConcreteClassifier _this) {
		EList<ClassifierReference> typeReferenceList = new BasicEList<ClassifierReference>();
		if(_this == null) {
			return typeReferenceList;
		}

		if (_this instanceof Class) {
			Class javaClass = (Class) _this;
			if (javaClass.getExtends() != null) {
				ClassifierReference classifierReference = ClassifierReferenceUtil.getPureClassifierReference(javaClass.getExtends());
				typeReferenceList.add(classifierReference);
				ConcreteClassifier target = (ConcreteClassifier) classifierReference.getTarget();
				if (!target.equals(JavaClasspathUtil.getObjectClass(_this))) {
					typeReferenceList.addAll(getSuperTypeReferences(target));
				}
			}	
			for(TypeReference interfaceReference : javaClass.getImplements()) {
				ClassifierReference classifierReference = ClassifierReferenceUtil.getPureClassifierReference(interfaceReference);
				typeReferenceList.add(classifierReference);
				typeReferenceList.addAll(getSuperTypeReferences((ConcreteClassifier) classifierReference.getTarget()));
			}
		} else if (_this instanceof Interface) {
			Interface javaInterface = (Interface) _this;
			for(TypeReference interfaceReference : javaInterface.getExtends()) {
				ClassifierReference classifierReference = ClassifierReferenceUtil.getPureClassifierReference(interfaceReference);
				typeReferenceList.add(classifierReference);
				typeReferenceList.addAll(getSuperTypeReferences((ConcreteClassifier) classifierReference.getTarget()));
			}
		}
		return typeReferenceList;
	}
	
}
