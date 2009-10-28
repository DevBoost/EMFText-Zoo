/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.language.owl.resource.owl.analysis;

import java.util.Map;

import org.eclipse.ui.internal.handlers.ReuseEditorTester;
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
