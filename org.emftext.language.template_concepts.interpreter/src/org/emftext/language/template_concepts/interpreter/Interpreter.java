package org.emftext.language.template_concepts.interpreter;

import java.util.HashMap;
import java.util.Map;

import org.emftext.runtime.IOptionProvider;
import org.emftext.runtime.IOptions;
import org.emftext.runtime.IResourcePostProcessor;
import org.emftext.runtime.IResourcePostProcessorProvider;
import org.emftext.runtime.resource.ITextResource;

public class Interpreter implements IOptionProvider, IResourcePostProcessorProvider, IResourcePostProcessor {

	public void process(ITextResource resource) {
		System.out.println("Interpreter.process()");
		// TODO mboehme instantiate template and write output to a file
	}

	public IResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(IOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return options;
	}
}
