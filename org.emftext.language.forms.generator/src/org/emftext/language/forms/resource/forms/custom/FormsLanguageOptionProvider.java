package org.emftext.language.forms.resource.forms.custom;

import java.util.HashMap;
import java.util.Map;

import org.emftext.language.forms.resource.forms.IFormsOptionProvider;
import org.emftext.language.forms.resource.forms.IFormsOptions;

public class FormsLanguageOptionProvider implements IFormsOptionProvider {

	public FormsLanguageOptionProvider() {
	}

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(IFormsOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new GeneratingResourceProcessor());
		return options;
	}

}
