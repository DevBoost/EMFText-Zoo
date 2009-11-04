/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.valueflow.diagram.part;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.valueflow.ValueflowPackage;

/**
 * @generated
 */
public class ValueflowDomainModelElementTester extends PropertyTester {

	/**
	 * @generated
	 */
	public boolean test(Object receiver, String method, Object[] args,
			Object expectedValue) {
		if (false == receiver instanceof EObject) {
			return false;
		}
		EObject eObject = (EObject) receiver;
		EClass eClass = eObject.eClass();
		if (eClass == ValueflowPackage.eINSTANCE.getNamedElement()) {
			return true;
		}
		if (eClass == ValueflowPackage.eINSTANCE.getModel()) {
			return true;
		}
		if (eClass == ValueflowPackage.eINSTANCE.getAgent()) {
			return true;
		}
		if (eClass == ValueflowPackage.eINSTANCE.getInitial()) {
			return true;
		}
		if (eClass == ValueflowPackage.eINSTANCE.getState()) {
			return true;
		}
		if (eClass == ValueflowPackage.eINSTANCE.getGiveState()) {
			return true;
		}
		if (eClass == ValueflowPackage.eINSTANCE.getTakeState()) {
			return true;
		}
		return false;
	}

}
