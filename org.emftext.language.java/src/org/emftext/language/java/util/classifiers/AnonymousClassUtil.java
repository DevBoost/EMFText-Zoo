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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.classifiers.AnonymousClass;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.classifiers.Enumeration;
import org.emftext.language.java.instantiations.NewConstructorCall;
import org.emftext.language.java.members.EnumConstant;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.modifiers.AnnotableAndModifiable;
import org.emftext.language.java.util.JavaClasspathUtil;
import org.emftext.language.java.util.modifiers.ModifiableUtil;
import org.emftext.language.java.util.types.TypeReferenceUtil;

public class AnonymousClassUtil {
	
	/**
	 * @param _this
	 * @param context to check protected visibility
	 * @return a view on all members including super classifiers' members
	 */
	public static EList<Member> getAllMembers(AnonymousClass _this, EObject context) {
		EList<Member> memberList = new BasicEList<Member>();
		memberList.addAll(_this.getMembers());
		memberList.addAll(_this.getDefaultMembers());
		
		NewConstructorCall ncCall = null;
		if (_this.eContainer() instanceof NewConstructorCall) {
			ncCall = (NewConstructorCall) _this.eContainer();;
		}
		if (ncCall == null) {
			return memberList;
		}
		else {
			ConcreteClassifier classifier = (ConcreteClassifier) TypeReferenceUtil.getTarget(ncCall.getType());
			if (classifier != null) {
				EList<Member> superMemberList = ClassifierUtil.getAllMembers(classifier, context);
				for(Member superMember : superMemberList) {
					//exclude private members
					if(superMember instanceof AnnotableAndModifiable) {					
						if (superMember.eIsProxy()) {
							superMember = (Member) EcoreUtil.resolve(superMember, _this);
						}
						AnnotableAndModifiable modifiable = (AnnotableAndModifiable) superMember;
						if(!ModifiableUtil.isHidden(modifiable, context)) {
							memberList.add(superMember);
						}
					}
					else {
						memberList.add(superMember);
					}
				}
			}
			return memberList;
		}
	}
	
	/**
	 * @param _this
	 * @return a view on all super classifiers
	 */
	public static EList<ConcreteClassifier> getAllSuperClassifiers(AnonymousClass _this) {
		EList<ConcreteClassifier> superClassifierList = new BasicEList<ConcreteClassifier>();
		
		ConcreteClassifier superClassifier = getSuperClassifier(_this);
		
		if (superClassifier != null) {
			superClassifierList.add(superClassifier);
			superClassifierList.addAll(ClassifierUtil.getAllSuperClassifiers(superClassifier));
		}
		else {
			superClassifierList.add(JavaClasspathUtil.getObjectClass(_this));
		}
		return superClassifierList;
	}
	
	/**
	 * @param _this
	 * @return the direct super classifier
	 */
	public static ConcreteClassifier getSuperClassifier(AnonymousClass _this) {
		NewConstructorCall ncCall = null;
		if (_this.eContainer() instanceof NewConstructorCall) {
			ncCall = (NewConstructorCall) _this.eContainer();
			ConcreteClassifier superClassifier = (ConcreteClassifier) TypeReferenceUtil.getTarget(ncCall.getType());
			return superClassifier;
		}
		else if (_this.eContainer() instanceof EnumConstant) {
			if (_this.eContainer().eContainer() instanceof Enumeration) {
				return (Enumeration) _this.eContainer().eContainer();
			}
		}
		return null;
	}
}
