package org.emftext.language.formular.resource.formular.custom;

import java.util.HashMap;
import java.util.Map;

import org.emftext.runtime.IOptions;

public class FormularLanguageOptionProvider implements org.emftext.runtime.IOptionProvider {

	public FormularLanguageOptionProvider() {
	}

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(IOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new GeneratingResourceProcessor());
		return options;
	}

}
