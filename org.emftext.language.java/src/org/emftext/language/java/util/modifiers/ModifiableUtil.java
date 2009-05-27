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
package org.emftext.language.java.util.modifiers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.AnonymousClass;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.commons.Commentable;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.literals.Self;
import org.emftext.language.java.modifiers.AnnotableAndModifiable;
import org.emftext.language.java.modifiers.AnnotationInstanceOrModifier;
import org.emftext.language.java.modifiers.Private;
import org.emftext.language.java.modifiers.Protected;
import org.emftext.language.java.modifiers.Public;
import org.emftext.language.java.modifiers.Static;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.references.ReferencesPackage;
import org.emftext.language.java.references.SelfReference;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.util.JavaUtil;
import org.emftext.language.java.util.classifiers.AnonymousClassUtil;
import org.emftext.language.java.util.references.ReferenceUtil;
import org.emftext.language.java.util.types.TypeUtil;

public class ModifiableUtil {

	public static boolean isStatic(AnnotableAndModifiable _this) {
		for(AnnotationInstanceOrModifier modifier : _this.getAnnotationsAndModifiers()) {
			if(modifier instanceof Static) {
				return true;
			}
		}
		return false;
	}

	public static boolean isHidden(AnnotableAndModifiable _this, EObject context) {
		if(context.eIsProxy()) {
			context = (Commentable) EcoreUtil.resolve(context, _this);
		}
		
		ConcreteClassifier contextClassifier = JavaUtil.findContainingClassifier(context); 
		ConcreteClassifier myClassifier = findOuterClassifier(_this);
		
		//special case: self reference to outer instance
		if(context.eContainmentFeature().equals(ReferencesPackage.Literals.REFERENCE__NEXT)) {
			if (context.eContainer() instanceof SelfReference) {
				SelfReference selfReference = (SelfReference) context.eContainer();
				if (selfReference.getSelf() instanceof Self) {
					if(selfReference.eContainmentFeature().equals(ReferencesPackage.Literals.REFERENCE__NEXT)) {
						Type type = ReferenceUtil.getType((Reference) selfReference.eContainer());
						if (type instanceof ConcreteClassifier) {
							contextClassifier = (ConcreteClassifier) type;
						}
					}
				}
			}
		}
		
		for(AnnotationInstanceOrModifier modifier : _this.getAnnotationsAndModifiers()) {
			if(modifier instanceof Private) {
				if (TypeUtil.equalsType(myClassifier, 0, contextClassifier, 0)) {
					return false;
				}
				return true;
			}
			if(modifier instanceof Public) {
				return false;
			}
			if(modifier instanceof Protected) {
				//package visibility
				if (JavaUtil.findPackageName(_this) != null && 
						JavaUtil.findPackageName(_this).equals(JavaUtil.findPackageName(context))) {
					return false;
				}
				return isInSuperOrOuterType(
						myClassifier, contextClassifier, context);
			}
		}
		//package visibility?
		if (JavaUtil.findPackageName(_this) != null && 
				JavaUtil.findPackageName(_this).equals(JavaUtil.findPackageName(context))) {
			return false;
		}

		return true;
	}

	private static ConcreteClassifier findOuterClassifier(
			AnnotableAndModifiable child) {
		ConcreteClassifier classifier = JavaUtil.findContainingClassifier(child.eContainer()); //eContainer() in case this is a classifier contained in another one
		if(classifier == null) {
			CompilationUnit cu = JavaUtil.findContainingCompilationUnit(child);
			//maybe the outer classifier is in an extra cu
			JavaClasspath cp = JavaClasspath.get(child);
			classifier = (ConcreteClassifier) EcoreUtil.resolve(
					cp.getClassifier(cp.getContainerNameFromNamespace(cu)), child);
			if(classifier.eIsProxy())  {
				classifier = null;
			}
		}
		return classifier;
	}

	private static boolean isInSuperOrOuterType(ConcreteClassifier myClassifier,
			ConcreteClassifier contextClassifier, EObject context) {
		//try outer classifiers as well 
		while(contextClassifier instanceof Classifier) {
			if (TypeUtil.isSuperType(contextClassifier, 0, myClassifier, null)) {
				return false;
			}
			contextClassifier = findOuterClassifier(contextClassifier);

			if (contextClassifier != null && !contextClassifier.eIsProxy() && 
					TypeUtil.isSuperType(contextClassifier, 0, myClassifier, null)) {
				return false;
			}
		}
		//visibility through anonymous subclass
		AnonymousClass anonymousClass = JavaUtil.findContainingAnonymousClass(context);
		while (anonymousClass != null) {
			contextClassifier = AnonymousClassUtil.getSuperClassifier(anonymousClass);
			if (TypeUtil.isSuperType(contextClassifier, 0, myClassifier, null)) {
				return false;
			}
			anonymousClass =  JavaUtil.findContainingAnonymousClass(anonymousClass.eContainer());
		}
		return true;
	}
	
	

}
