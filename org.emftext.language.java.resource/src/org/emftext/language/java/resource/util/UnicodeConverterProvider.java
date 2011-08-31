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
package org.emftext.language.java.resource.util;

import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

import org.emftext.language.java.resource.java.IJavaInputStreamProcessorProvider;
import org.emftext.language.java.resource.java.IJavaOptionProvider;
import org.emftext.language.java.resource.java.IJavaOptions;
import org.emftext.language.java.resource.java.mopp.JavaInputStreamProcessor;
import org.emftext.language.java.resource.java.util.JavaUnicodeConverter;

/**
 * Provides the instances of the UnicodeConverter class to be used when
 * reading Java source files. The UnicodeConverter convert Unicode escape
 * sequences to real characters.
 * Adds the UnicodeConverterProvider to the list of input stream pre-processor
 * providers.
 */
public class UnicodeConverterProvider implements IJavaOptionProvider, IJavaInputStreamProcessorProvider {

	public JavaInputStreamProcessor getInputStreamProcessor(InputStream inputStream) {
		return new JavaUnicodeConverter(inputStream);
	}

	public Map<?, ?> getOptions() {
		return Collections.singletonMap(IJavaOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER, new UnicodeConverterProvider());
	}
}
