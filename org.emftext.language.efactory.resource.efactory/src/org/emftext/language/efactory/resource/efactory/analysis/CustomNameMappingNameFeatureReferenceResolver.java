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
package org.emftext.language.efactory.resource.efactory.analysis;

public class CustomNameMappingNameFeatureReferenceResolver implements org.emftext.language.efactory.resource.efactory.IEfactoryReferenceResolver<org.emftext.language.efactory.CustomNameMapping, org.eclipse.emf.ecore.EAttribute> {
	
	private org.emftext.language.efactory.resource.efactory.analysis.EfactoryDefaultResolverDelegate<org.emftext.language.efactory.CustomNameMapping, org.eclipse.emf.ecore.EAttribute> delegate = new org.emftext.language.efactory.resource.efactory.analysis.EfactoryDefaultResolverDelegate<org.emftext.language.efactory.CustomNameMapping, org.eclipse.emf.ecore.EAttribute>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.efactory.CustomNameMapping container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.efactory.resource.efactory.IEfactoryReferenceResolveResult<org.eclipse.emf.ecore.EAttribute> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.eclipse.emf.ecore.EAttribute element, org.emftext.language.efactory.CustomNameMapping container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
