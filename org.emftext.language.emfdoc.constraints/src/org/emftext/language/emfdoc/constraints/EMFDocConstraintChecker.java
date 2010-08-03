package org.emftext.language.emfdoc.constraints;

import org.emftext.language.ecoredoc.resource.ecoredoc.IEcoredocResourcePostProcessor;
import org.emftext.language.ecoredoc.resource.ecoredoc.mopp.EcoredocResource;

public class EMFDocConstraintChecker implements IEcoredocResourcePostProcessor {

	public void process(EcoredocResource resource) {
		new DuplicateDocumentationElementChecker().process(resource);
	}
}
