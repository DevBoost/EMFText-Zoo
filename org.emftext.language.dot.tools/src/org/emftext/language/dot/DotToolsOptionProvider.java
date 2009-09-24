package org.emftext.language.dot;

import java.util.HashMap;
import java.util.Map;

import org.emftext.language.dot.resource.dot.IDotOptionProvider;
import org.emftext.language.dot.resource.dot.IDotOptions;

public class DotToolsOptionProvider implements IDotOptionProvider {

	public Map<?, ?> getOptions() {
		Map<Object, Object> options = new HashMap<Object, Object>();
		options.put(IDotOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new DotToolsProvider());
		return options;
	}

}
