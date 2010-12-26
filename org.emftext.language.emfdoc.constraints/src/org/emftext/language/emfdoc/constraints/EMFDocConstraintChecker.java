package org.emftext.language.emfdoc.constraints;

import org.emftext.language.emfdoc.resource.emfdoc.IEmfdocResourcePostProcessor;
import org.emftext.language.emfdoc.resource.emfdoc.mopp.EmfdocResource;

public class EMFDocConstraintChecker implements IEmfdocResourcePostProcessor {

	public void process(EmfdocResource resource) {
		new DuplicateDocumentationElementChecker().process(resource);
	}

	public void terminate() {
		// do nothing
	}
}
