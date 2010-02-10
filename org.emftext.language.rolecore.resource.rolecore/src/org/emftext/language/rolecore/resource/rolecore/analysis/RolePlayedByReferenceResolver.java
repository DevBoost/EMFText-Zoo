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

package org.emftext.language.rolecore.resource.rolecore.analysis;

public class RolePlayedByReferenceResolver implements org.emftext.language.rolecore.resource.rolecore.IRolecoreReferenceResolver<org.emftext.language.rolecore.Role, org.emftext.language.rolecore.CoreClass> {
	
	private org.emftext.language.rolecore.resource.rolecore.analysis.RolecoreDefaultResolverDelegate<org.emftext.language.rolecore.Role, org.emftext.language.rolecore.CoreClass> delegate = new org.emftext.language.rolecore.resource.rolecore.analysis.RolecoreDefaultResolverDelegate<org.emftext.language.rolecore.Role, org.emftext.language.rolecore.CoreClass>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.rolecore.Role container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.rolecore.resource.rolecore.IRolecoreReferenceResolveResult<org.emftext.language.rolecore.CoreClass> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.rolecore.CoreClass element, org.emftext.language.rolecore.Role container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
