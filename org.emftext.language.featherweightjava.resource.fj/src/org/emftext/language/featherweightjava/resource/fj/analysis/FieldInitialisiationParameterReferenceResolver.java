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

//TODO this resolver needs customization
public class FieldInitialisiationParameterReferenceResolver implements org.emftext.language.featherweightjava.resource.fj.IFjReferenceResolver<org.emftext.language.featherweightjava.FieldInitialisiation, org.emftext.language.featherweightjava.Parameter> {

	private org.emftext.language.featherweightjava.resource.fj.analysis.FjDefaultResolverDelegate<org.emftext.language.featherweightjava.FieldInitialisiation, org.emftext.language.featherweightjava.Parameter> delegate = new org.emftext.language.featherweightjava.resource.fj.analysis.FjDefaultResolverDelegate<org.emftext.language.featherweightjava.FieldInitialisiation, org.emftext.language.featherweightjava.Parameter>();

	public void resolve(java.lang.String identifier, org.emftext.language.featherweightjava.FieldInitialisiation container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.language.featherweightjava.resource.fj.IFjReferenceResolveResult<org.emftext.language.featherweightjava.Parameter> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	public java.lang.String deResolve(org.emftext.language.featherweightjava.Parameter element, org.emftext.language.featherweightjava.FieldInitialisiation container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?,?> options) {

	}

}
