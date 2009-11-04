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

import org.emftext.language.owl.resource.owl.IOwlReferenceResolveResult;
import org.emftext.language.owl.resource.owl.IOwlReferenceResolver;
import org.emftext.language.owl.resource.owl.analysis.custom.CrossResourceIRIResolver;

public class DataPropertySuperPropertiesReferenceResolver implements IOwlReferenceResolver<org.emftext.language.owl.DataProperty, org.emftext.language.owl.DataProperty> {
	
	private OwlDefaultResolverDelegate<org.emftext.language.owl.DataProperty, org.emftext.language.owl.DataProperty> delegate = 
		new OwlDefaultResolverDelegate<org.emftext.language.owl.DataProperty, org.emftext.language.owl.DataProperty>();
	
	public java.lang.String deResolve(org.emftext.language.owl.DataProperty element, org.emftext.language.owl.DataProperty container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
		
	public void resolve(java.lang.String identifier, org.emftext.language.owl.DataProperty container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IOwlReferenceResolveResult<org.emftext.language.owl.DataProperty> result) {
		CrossResourceIRIResolver.theInstance().doResolve(identifier, container, resolveFuzzy, result, org.emftext.language.owl.DataProperty.class);
			
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

    public void setOptions(Map<?, ?> options) {}
}
