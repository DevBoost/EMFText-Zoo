/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.forms.resource.forms.analysis;

public class FormsTEXTTokenResolver implements org.emftext.language.forms.resource.forms.IFormsTokenResolver {

	private org.emftext.language.forms.resource.forms.analysis.FormsDefaultTokenResolver defaultTokenResolver = new org.emftext.language.forms.resource.forms.analysis.FormsDefaultTokenResolver();

	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}

	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.forms.resource.forms.IFormsTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}

	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}

}
