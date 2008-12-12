package org.emftext.language.java;

import java.util.HashMap;
import java.util.Map;

import org.emftext.runtime.IOptionProvider;
import org.emftext.runtime.IOptions;

public class UnicodeConverterOption implements IOptionProvider {
	
	public Map<?, ?> getOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER, new UnicodeConverterProvider());
		return map;
	}
}
