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

import org.emftext.language.owl.Ontology;
import org.emftext.language.owl.loading.RemoteLoader;
import org.emftext.language.owl.resource.owl.IOwlReferenceResolveResult;
import org.emftext.language.owl.resource.owl.IOwlReferenceResolver;
import org.emftext.language.owl.resource.owl.analysis.custom.CrossResourceIRIResolver;

public class OntologyImportsReferenceResolver implements IOwlReferenceResolver<org.emftext.language.owl.Ontology, org.emftext.language.owl.Ontology> {
	
	private RemoteLoader remoteLoader = CrossResourceIRIResolver.theInstance().getRemoteLoader();
	
	private OwlDefaultResolverDelegate<org.emftext.language.owl.Ontology, org.emftext.language.owl.Ontology> delegate = 
		new OwlDefaultResolverDelegate<org.emftext.language.owl.Ontology, org.emftext.language.owl.Ontology>();
		
	public java.lang.String deResolve(org.emftext.language.owl.Ontology element, org.emftext.language.owl.Ontology container, org.eclipse.emf.ecore.EReference reference) {
		return element.getUri();
	}
	
		
	public void resolve(java.lang.String identifier, org.emftext.language.owl.Ontology container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IOwlReferenceResolveResult<org.emftext.language.owl.Ontology> result) {
		Ontology loadedOntology = remoteLoader.loadOntology(identifier, container);
		if (loadedOntology != null) {
			result.addMapping(identifier, loadedOntology);
		}
	}

    public void setOptions(Map<?, ?> options) {}
}
