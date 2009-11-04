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
package org.emftext.language.owl.resource.owl.analysis;

import java.util.Map;

import org.emftext.language.owl.resource.owl.IOwlTokenResolveResult;
import org.emftext.language.owl.resource.owl.IOwlTokenResolver;

public class OwlIRITokenResolver implements IOwlTokenResolver {
	
	private OwlDefaultTokenResolver defaultResolver = new OwlDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultResolver.deResolve(value, feature, container);
		if (result.indexOf("://") != -1) {
			result = "<" + result + ">";
		}
		return result;
	}
		
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, IOwlTokenResolveResult result) {
		if (lexem.startsWith("<") && lexem.endsWith(">")) {
			lexem = lexem.substring(1, lexem.length()-1);
		}
		defaultResolver.resolve(lexem, feature, result);
	}

	public void setOptions(Map<?, ?> options) {
		defaultResolver.setOptions(options);
	}
}
