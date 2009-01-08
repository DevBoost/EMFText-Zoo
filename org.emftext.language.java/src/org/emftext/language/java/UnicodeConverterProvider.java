package org.emftext.language.java;

import java.io.InputStream;

import org.emftext.runtime.InputStreamProcessor;
import org.emftext.runtime.IInputStreamProcessorProvider;

public class UnicodeConverterProvider implements IInputStreamProcessorProvider {
	public InputStreamProcessor getInputStreamProcessor(InputStream inputStream) {
		return new UnicodeConverter(inputStream);
	}
}
