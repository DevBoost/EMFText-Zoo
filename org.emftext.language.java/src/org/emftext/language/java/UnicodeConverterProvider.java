package org.emftext.language.java;

import java.io.InputStream;

import org.emftext.runtime.InputStreamProcessor;
import org.emftext.runtime.InputStreamProcessorProvider;

public class UnicodeConverterProvider implements InputStreamProcessorProvider {
	public InputStreamProcessor getInputStreamProcessor(InputStream inputStream) {
		return new UnicodeConverter(inputStream);
	}
}
