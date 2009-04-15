package org.emftext.language.owl.reasoning;

import java.util.Set;

import org.semanticweb.owl.model.OWLClass;

public interface EMFTextOWLReasoner {
	
	public Set<OWLClass> getInconsistentClasses(String owlRepresentation);
	
}
