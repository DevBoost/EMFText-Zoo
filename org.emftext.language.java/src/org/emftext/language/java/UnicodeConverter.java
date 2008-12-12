package org.emftext.language.java;

import java.io.IOException;
import java.io.InputStream;

import org.emftext.runtime.InputStreamProcessor;

public class UnicodeConverter extends InputStreamProcessor {

	private InputStream inputStream;

	public UnicodeConverter(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public int read() throws IOException {
		// TODO mseifert: do unicode conversion
		int read = inputStream.read();
		System.out.println(this + ".read() " + read);
		return read;
	}
}
