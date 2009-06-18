package org.emftext.language.forms.resource.forms.custom;

import java.util.HashMap;
import java.util.Map;

import org.emftext.runtime.IOptions;

public class FormsLanguageOptionProvider implements org.emftext.runtime.IOptionProvider {

	public FormsLanguageOptionProvider() {
	}

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(IOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new GeneratingResourceProcessor());
		return options;
	}

}
