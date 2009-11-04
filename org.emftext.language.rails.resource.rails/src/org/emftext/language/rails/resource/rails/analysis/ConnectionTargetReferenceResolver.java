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
package org.emftext.language.rails.resource.rails.analysis;

public class ConnectionTargetReferenceResolver implements org.emftext.language.rails.resource.rails.IRailsReferenceResolver<org.emftext.language.rails.Connection, org.emftext.language.rails.In> {
	
	private org.emftext.language.rails.resource.rails.analysis.RailsDefaultResolverDelegate<org.emftext.language.rails.Connection, org.emftext.language.rails.In> delegate = new org.emftext.language.rails.resource.rails.analysis.RailsDefaultResolverDelegate<org.emftext.language.rails.Connection, org.emftext.language.rails.In>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.rails.Connection container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.rails.resource.rails.IRailsReferenceResolveResult<org.emftext.language.rails.In> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.rails.In element, org.emftext.language.rails.Connection container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
