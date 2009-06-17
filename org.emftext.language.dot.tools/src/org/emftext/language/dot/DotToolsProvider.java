package org.emftext.language.dot;

import org.emftext.runtime.IResourcePostProcessor;
import org.emftext.runtime.IResourcePostProcessorProvider;

public class DotToolsProvider implements IResourcePostProcessorProvider {

	public IResourcePostProcessor getResourcePostProcessor() {
		return new DotPostProcessor();
	}
}
