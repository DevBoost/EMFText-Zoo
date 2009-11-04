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
package org.emftext.language.owl.reasoning;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

import org.coode.manchesterowlsyntax.ManchesterOWLSyntaxParserFactory;
import org.mindswap.pellet.exceptions.InternalReasonerException;
import org.mindswap.pellet.owlapi.Reasoner;
import org.semanticweb.owl.apibinding.OWLManager;
import org.semanticweb.owl.io.OWLOntologyInputSource;
import org.semanticweb.owl.io.OWLParser;
import org.semanticweb.owl.io.StringInputSource;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyCreationException;
import org.semanticweb.owl.model.OWLOntologyManager;

public class PelletReasoner implements org.emftext.language.owl.reasoning.EMFTextOWLReasoner {

	public Set<OWLClass> getInconsistentClasses(String owlRepresentation) throws ReasoningException {
		Set<OWLClass> inconsistentClasses = new HashSet<OWLClass>();
		
		
		try {
			// prepare infrastructure
			OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
			ManchesterOWLSyntaxParserFactory f = new ManchesterOWLSyntaxParserFactory();
			OWLParser parser = f.createParser(manager);

			// load and parse ontology in manchester syntax
			OWLOntologyInputSource inputSource = new StringInputSource(owlRepresentation);
			OWLOntology ontology = manager.createOntology(URI.create("check"));
			
			parser.setOWLOntologyManager(manager);
			parser.parse(inputSource, ontology);
			
			// load ontology in pellet 
			Reasoner reasoner = new Reasoner(manager);
			Set<OWLOntology> importsClosure = manager
					.getImportsClosure(ontology);
			reasoner.loadOntologies(importsClosure);

			// derive inconsistent classes
			inconsistentClasses = reasoner
					.getInconsistentClasses();
			return inconsistentClasses;

		} catch (OWLOntologyCreationException e) {
			String message = "The ontology could not be checked for consistency: "
					+ e.getMessage();
			throw new ReasoningException(message, e);
		} catch (InternalReasonerException e) {
			String message = "The ontology could not be checked for consistency: "+ e.getMessage();
			throw new ReasoningException(message, e);
		}
	

	}
	
}
