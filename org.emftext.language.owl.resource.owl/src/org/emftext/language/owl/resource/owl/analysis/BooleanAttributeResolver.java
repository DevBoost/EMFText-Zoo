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

public class BooleanAttributeResolver implements IOwlTokenResolver {
	
	private OwlDefaultTokenResolver defaultResolver = new OwlDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value,
			org.eclipse.emf.ecore.EStructuralFeature feature,
			org.eclipse.emf.ecore.EObject container) {
		if ((Boolean) value) {
			return feature.getName().substring(0, 1).toLowerCase()
					+ feature.getName().substring(1);
		} else {
			return "";
		}
	}

	
	public void resolve(java.lang.String lexem,
			org.eclipse.emf.ecore.EStructuralFeature feature,
			IOwlTokenResolveResult result) {
		if (feature.getName().equalsIgnoreCase(lexem)) {
			result.setResolvedToken(true);
		} else {
			result.setResolvedToken(false);
		}
	}


	public void setOptions(Map<?, ?> options) {
		defaultResolver.setOptions(options);
	}
}
