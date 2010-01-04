/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.language.simple_gui.resource.simplegui.analysis;

import java.util.Map;

import org.emftext.language.simple_gui.resource.simplegui.ISimpleguiTokenResolveResult;
import org.emftext.language.simple_gui.resource.simplegui.ISimpleguiTokenResolver;

public class SimpleguiTEXTTokenResolver implements ISimpleguiTokenResolver {
	
	private SimpleguiDefaultTokenResolver defaultResolver = new SimpleguiDefaultTokenResolver();

	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultResolver.deResolve(value, feature, container);
		return result;
	}

	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, ISimpleguiTokenResolveResult result) {
		defaultResolver.resolve(lexem, feature, result);
	}

	public void setOptions(Map<?, ?> options) {
		defaultResolver.setOptions(options);
	}
}
