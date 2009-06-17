package org.emftext.language.dot;

import java.util.HashMap;
import java.util.Map;

import org.emftext.runtime.IOptionProvider;
import org.emftext.runtime.IOptions;

public class DotToolsOptionProvider implements IOptionProvider {

	public Map<?, ?> getOptions() {
		Map<Object, Object> options = new HashMap<Object, Object>();
		options.put(IOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new DotToolsProvider());
		return options;
	}

}
