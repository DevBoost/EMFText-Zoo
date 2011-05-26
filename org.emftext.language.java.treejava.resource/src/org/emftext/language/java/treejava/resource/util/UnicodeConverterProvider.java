/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java.treejava.resource.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.emftext.language.java.treejava.resource.treejava.ITreejavaInputStreamProcessorProvider;
import org.emftext.language.java.treejava.resource.treejava.ITreejavaOptionProvider;
import org.emftext.language.java.treejava.resource.treejava.ITreejavaOptions;
import org.emftext.language.java.treejava.resource.treejava.mopp.TreejavaInputStreamProcessor;
import org.emftext.language.java.treejava.resource.treejava.util.TreejavaUnicodeConverter;

/**
 * Provides the instances of the UnicodeConverter class to be used when
 * reading Java source files. The UnicodeConverter convert Unicode escape
 * sequences to real characters.
 * Adds the UnicodeConverterProvider to the list of input stream pre-processor
 * providers.
 */
public class UnicodeConverterProvider implements ITreejavaOptionProvider, ITreejavaInputStreamProcessorProvider {

	public TreejavaInputStreamProcessor getInputStreamProcessor(InputStream inputStream) {
		return new TreejavaUnicodeConverter(inputStream);
	}

	public Map<?, ?> getOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(ITreejavaOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER, new UnicodeConverterProvider());
		return map;
	}
}
