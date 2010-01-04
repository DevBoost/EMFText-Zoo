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
package org.emftext.language.petrinet.resource.petrinet.analysis;

public class ArcTargetReferenceResolver implements org.emftext.language.petrinet.resource.petrinet.IPetrinetReferenceResolver<org.emftext.language.petrinet.Arc, org.emftext.language.petrinet.RefNodes> {
	
	private org.emftext.language.petrinet.resource.petrinet.analysis.PetrinetDefaultResolverDelegate<org.emftext.language.petrinet.Arc, org.emftext.language.petrinet.RefNodes> delegate = new org.emftext.language.petrinet.resource.petrinet.analysis.PetrinetDefaultResolverDelegate<org.emftext.language.petrinet.Arc, org.emftext.language.petrinet.RefNodes>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.petrinet.Arc container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.language.petrinet.resource.petrinet.IPetrinetReferenceResolveResult<org.emftext.language.petrinet.RefNodes> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.petrinet.RefNodes element, org.emftext.language.petrinet.Arc container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
