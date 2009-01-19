package org.emftext.language.java.resource.java.analysis.helper;

import java.util.HashMap;
import java.util.Map;

import org.emftext.runtime.IOptionProvider;
import org.emftext.runtime.IOptions;

public class ExpressionSimplifierOption implements IOptionProvider {
	
	public Map<?, ?> getOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new ExpressionSimplifier());
		return map;
	}
}
