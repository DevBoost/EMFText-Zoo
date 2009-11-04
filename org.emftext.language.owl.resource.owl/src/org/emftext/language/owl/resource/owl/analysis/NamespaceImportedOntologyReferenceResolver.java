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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.owl.Ontology;
import org.emftext.language.owl.OntologyDocument;

public class NamespaceImportedOntologyReferenceResolver implements org.emftext.language.owl.resource.owl.IOwlReferenceResolver<org.emftext.language.owl.Namespace, org.emftext.language.owl.Ontology> {
	
	private org.emftext.language.owl.resource.owl.analysis.OwlDefaultResolverDelegate<org.emftext.language.owl.Namespace, org.emftext.language.owl.Ontology> delegate = new org.emftext.language.owl.resource.owl.analysis.OwlDefaultResolverDelegate<org.emftext.language.owl.Namespace, org.emftext.language.owl.Ontology>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.owl.Namespace container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.owl.resource.owl.IOwlReferenceResolveResult<org.emftext.language.owl.Ontology> result) {
		OntologyDocument ontologyDocument = (OntologyDocument) container.eContainer();
		EList<Ontology> imports = ontologyDocument.getOntology().getImports();
		for (Ontology ontology : imports) {
			
			if (identifier.equals(ontology.getUri())) {
				result.addMapping(identifier, ontology);
				return;
			}
		}
	}
	
	public java.lang.String deResolve(org.emftext.language.owl.Ontology element, org.emftext.language.owl.Namespace container, org.eclipse.emf.ecore.EReference reference) {
		return element.getUri();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
