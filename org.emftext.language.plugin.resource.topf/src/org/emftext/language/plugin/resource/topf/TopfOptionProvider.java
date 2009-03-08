package org.emftext.language.plugin.resource.topf;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.emftext.language.plugin.PluginDataInitializer;
import org.emftext.runtime.IOptionProvider;
import org.emftext.runtime.IOptions;
import org.emftext.runtime.IResourcePostProcessorProvider;

public class TopfOptionProvider implements IOptionProvider {

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();

		LinkedList<IResourcePostProcessorProvider> postProcessors = new LinkedList<IResourcePostProcessorProvider>();
		postProcessors.add(new PluginDataInitializer());
		
		
		options.put(IOptions.RESOURCE_POSTPROCESSOR_PROVIDER, postProcessors);
		
		return options;
	}

}
