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
package org.emftext.language.featherweightjava.resource.fj.analysis;

import org.emftext.language.featherweightjava.resource.fj.analysis.helper.ClassResolver;

public class CastTypeReferenceResolver implements org.emftext.language.featherweightjava.resource.fj.IFjReferenceResolver<org.emftext.language.featherweightjava.Cast, org.emftext.language.featherweightjava.Class> {

	private ClassResolver delegate = new ClassResolver();

	public void resolve(java.lang.String identifier, org.emftext.language.featherweightjava.Cast container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.language.featherweightjava.resource.fj.IFjReferenceResolveResult<org.emftext.language.featherweightjava.Class> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	public java.lang.String deResolve(org.emftext.language.featherweightjava.Class element, org.emftext.language.featherweightjava.Cast container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?,?> options) {

	}

}
