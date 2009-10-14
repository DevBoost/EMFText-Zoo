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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.parameters.Parameter;
import org.emftext.language.java.parameters.ParametersPackage;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.statements.StatementsPackage;

/**
 * A decider that looks for parameters.
 */
public class ParameterDecider extends AbstractDecider {

	public boolean continueAfterReference() {
		return false;
	}

	public boolean isPossibleTarget(String id, EObject element) {
		if (element instanceof Parameter) {
			NamedElement ne = (NamedElement) element;
			return id.equals(ne.getName());
		}
		return false;
	}

	public boolean containsCandidates(EObject container, EReference containingReference) {
		if (ParametersPackage.Literals.PARAMETRIZABLE__EXTENSIBLE_PARAMETERS.equals(containingReference)) {
			return  true;
		}
		if (StatementsPackage.Literals.CATCH_BLOCK__EXTENSIBLE_PARAMETER.equals(containingReference)) {
			return  true;
		}
		if (StatementsPackage.Literals.FOR_EACH_LOOP__EXTENSIBLE_NEXT.equals(containingReference)) {
			return  true;
		}
		return false;
	}
	
	public boolean walkInto(EObject element) {
		return false;
	}

	public boolean canFindTargetsFor(EObject referenceContainer,
			EReference containingReference) {
		return referenceContainer instanceof Reference && !(referenceContainer instanceof MethodCall);
	}

}
