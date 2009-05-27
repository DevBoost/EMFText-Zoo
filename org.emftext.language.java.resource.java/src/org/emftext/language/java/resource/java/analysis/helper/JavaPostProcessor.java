package org.emftext.language.java.resource.java.analysis.helper;

import java.util.HashMap;
import java.util.Map;

import org.emftext.language.java.util.JavaModelCompletion;
import org.emftext.runtime.IOptionProvider;
import org.emftext.runtime.IOptions;
import org.emftext.runtime.IResourcePostProcessor;
import org.emftext.runtime.IResourcePostProcessorProvider;
import org.emftext.runtime.resource.ITextResource;

/**
 * Post processor that performs 
 * <i>cast repair</i> and 
 * <i>java model completion</i>
 * on a resource after parsing.
 */
public class JavaPostProcessor implements IOptionProvider, IResourcePostProcessor, IResourcePostProcessorProvider {
	
	public Map<?, ?> getOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return map;
	}

	public void process(ITextResource resource) {
		JavaModelRepair.repair(resource);
		JavaModelCompletion.complete(resource);
	}

	public IResourcePostProcessor getResourcePostProcessor() {
		return this;
	}
}
