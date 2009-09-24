package org.emftext.language.dot;

import org.emftext.language.dot.resource.dot.IDotResourcePostProcessor;
import org.emftext.language.dot.resource.dot.IDotResourcePostProcessorProvider;

public class DotToolsProvider implements IDotResourcePostProcessorProvider {

	public IDotResourcePostProcessor getResourcePostProcessor() {
		return new DotPostProcessor();
	}
}
