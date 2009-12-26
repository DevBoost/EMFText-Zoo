package org.emftext.language.efactory.resource.efactory.post_processing;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.emftext.language.efactory.resource.efactory.IEfactoryOptionProvider;
import org.emftext.language.efactory.resource.efactory.IEfactoryOptions;
import org.emftext.language.efactory.resource.efactory.IEfactoryResourcePostProcessor;
import org.emftext.language.efactory.resource.efactory.IEfactoryResourcePostProcessorProvider;
import org.emftext.language.efactory.resource.efactory.mopp.EfactoryPlugin;
import org.emftext.language.efactory.resource.efactory.mopp.EfactoryResource;

public class EFactoryPostProcessor implements IEfactoryOptionProvider, IEfactoryResourcePostProcessorProvider, IEfactoryResourcePostProcessor {

	private List<IEfactoryResourcePostProcessor> postProcessors;
	
	public EFactoryPostProcessor() {
		super();
		postProcessors = new ArrayList<IEfactoryResourcePostProcessor>();
		postProcessors.add(new FeatureBoundAnalyser());
		postProcessors.add(new FeatureTypeAnalyser());
	}

	public void process(EfactoryResource resource) {
		for (IEfactoryResourcePostProcessor postProcessor : postProcessors) {
			try {
				postProcessor.process(resource);
			} catch (Exception e) {
				EfactoryPlugin.logError("Exception while running post processor.", e);
			}
		}
	}

	public Map<?, ?> getOptions() {
		Map<Object, Object> optionsMap = new LinkedHashMap<Object, Object>();
		optionsMap.put(IEfactoryOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return optionsMap;
	}

	public IEfactoryResourcePostProcessor getResourcePostProcessor() {
		return this;
	}
}
