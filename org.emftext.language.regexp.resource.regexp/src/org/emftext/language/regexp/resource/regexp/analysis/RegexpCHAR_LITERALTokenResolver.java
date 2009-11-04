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
package org.emftext.language.regexp.resource.regexp.analysis;

import java.util.Map;

import org.emftext.language.regexp.resource.regexp.IRegexpTokenResolveResult;
import org.emftext.language.regexp.resource.regexp.IRegexpTokenResolver;

public class RegexpCHAR_LITERALTokenResolver implements IRegexpTokenResolver {
	
	private RegexpDefaultTokenResolver defaultResolver = new RegexpDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, IRegexpTokenResolveResult result) {
		defaultResolver.resolve(lexem, feature, result);
	}

	public void setOptions(Map<?, ?> options) {
	}
}
