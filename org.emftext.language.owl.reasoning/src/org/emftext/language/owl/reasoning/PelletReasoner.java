package org.emftext.language.owl.reasoning;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

import org.coode.manchesterowlsyntax.ManchesterOWLSyntaxParserFactory;
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

	public Set<OWLClass> getInconsistentClasses(String owlRepresentation) {
		Set<OWLClass> inconsistentClasses = new HashSet<OWLClass>();
		
		
		try {

			OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
			ManchesterOWLSyntaxParserFactory f = new ManchesterOWLSyntaxParserFactory();
			OWLParser parser = f.createParser(manager);

			OWLOntologyInputSource inputSource = new StringInputSource(owlRepresentation);
			OWLOntology ontology = manager.createOntology(URI.create("check"));
			parser.setOWLOntologyManager(manager);
			parser.parse(inputSource, ontology);

			Reasoner reasoner = new Reasoner(manager);

			Set<OWLOntology> importsClosure = manager
					.getImportsClosure(ontology);
			reasoner.loadOntologies(importsClosure);

			inconsistentClasses = reasoner
					.getInconsistentClasses();
			return inconsistentClasses;

		} catch (OWLOntologyCreationException e) {
			System.out.println("The ontology could not be created: "
					+ e.getMessage());
		}
		return inconsistentClasses;

	}
	
}
