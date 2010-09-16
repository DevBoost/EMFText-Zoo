package org.emftext.language.eocl.staticsemantics.provider;

import org.emftext.language.eocl.resource.eocl.IEoclResourcePostProcessor;
import org.emftext.language.eocl.resource.eocl.IEoclResourcePostProcessorProvider;

public class EOclResourcePostProcessorProvider implements
		IEoclResourcePostProcessorProvider {

	private IEoclResourcePostProcessor oclResourcePostProcessor;

	public EOclResourcePostProcessorProvider() {
		oclResourcePostProcessor = new EOclStaticSemanticsPostProcessor();
	}

	public IEoclResourcePostProcessor getResourcePostProcessor() {
		return oclResourcePostProcessor;
	}

}
