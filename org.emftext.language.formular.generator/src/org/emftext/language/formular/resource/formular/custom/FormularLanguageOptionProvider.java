package org.emftext.language.formular.resource.formular.custom;

import java.util.HashMap;
import java.util.Map;

import org.emftext.language.formular.resource.formular.IFormularOptionProvider;
import org.emftext.language.formular.resource.formular.IFormularOptions;

public class FormularLanguageOptionProvider implements IFormularOptionProvider {

	public FormularLanguageOptionProvider() {
	}

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(IFormularOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new GeneratingResourceProcessor());
		return options;
	}

}
