/*******************************************************************************
 * Copyright (c) 2006-2011
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
package org.emftext.language.java.resource.java.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.java.resource.java.IJavaTokenResolveResult;
import org.emftext.language.java.resource.java.IJavaTokenResolver;

// TODO @mseifert: add conversion of supplementary unicode characters
// see JavaSTRING_LITERALTokenResolver
public class JavaIDENTIFIERTokenResolver implements IJavaTokenResolver {

	private JavaDefaultTokenResolver defaultResolver = new JavaDefaultTokenResolver();

	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = defaultResolver.deResolve(value,feature,container);
		return result;
	}

	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, IJavaTokenResolveResult result) {
		defaultResolver.resolve(lexem, feature, result);
	}

	public void setOptions(Map<?, ?> options) {
		defaultResolver.setOptions(options);
	}
}
