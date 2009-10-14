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
package org.emftext.language.java.resource.java.analysis.decider;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.java.annotations.AnnotationAttributeSetting;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.members.InterfaceMethod;
import org.emftext.language.java.members.MemberContainer;
import org.emftext.language.java.members.MembersPackage;
import org.emftext.language.java.members.Method;

/**
 * To resolve annotation attributes.
 */
public class InterfaceMethodDecider extends AbstractDecider {


	public boolean canFindTargetsFor(EObject referenceContainer,
			EReference containingReference) {
		if (referenceContainer instanceof AnnotationAttributeSetting) {
			return true;
		}
		return false;
	}

	public EList<? extends EObject> getAdditionalCandidates(String identifier, EObject container) {
		if (container instanceof Classifier) {
			return ((Classifier)container).getAllMembers((Classifier)container);
		}
		return null;
	}

	public boolean isPossibleTarget(String id, EObject element) {
		if (element instanceof InterfaceMethod) {
			Method method = (Method) element;
			if (id.equals(method.getName())) {
				NamedElement ne = (NamedElement) element;
				return id.equals(ne.getName());
			}
		}
		return false;
	}

	public boolean containsCandidates(EObject container, EReference containingReference) {
		if (container instanceof MemberContainer) {
			if (MembersPackage.Literals.MEMBER_CONTAINER__EXTENSIBLE_MEMBERS.equals(containingReference)) {
				return  true;
			}
		}
		return false;
	}


}
