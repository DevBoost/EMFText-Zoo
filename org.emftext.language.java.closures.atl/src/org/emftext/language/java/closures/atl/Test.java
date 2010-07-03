package org.emftext.language.java.closures.atl;

import java.util.HashMap;
import java.util.Map;

import org.emftext.language.java.closures.resource.closure.IClosureOptionProvider;
import org.emftext.language.java.closures.resource.closure.IClosureOptions;
import org.emftext.language.java.closures.resource.closure.IClosureResourcePostProcessor;
import org.emftext.language.java.closures.resource.closure.IClosureResourcePostProcessorProvider;
import org.emftext.language.java.closures.resource.closure.mopp.ClosureResource;

public class Test implements IClosureOptionProvider,
		IClosureResourcePostProcessor, IClosureResourcePostProcessorProvider {

	public IClosureResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public void process(ClosureResource resource) {
		// TODO Auto-generated method stub

	}

	public Map<?, ?> getOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IClosureOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return map;
	}

}
