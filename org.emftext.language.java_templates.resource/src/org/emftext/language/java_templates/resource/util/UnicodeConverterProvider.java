/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.language.java_templates.resource.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.emftext.language.java_templates.resource.java_template.IJava_templateInputStreamProcessorProvider;
import org.emftext.language.java_templates.resource.java_template.IJava_templateOptionProvider;
import org.emftext.language.java_templates.resource.java_template.IJava_templateOptions;
import org.emftext.language.java_templates.resource.java_template.mopp.Java_templateInputStreamProcessor;
import org.emftext.language.java_templates.resource.java_template.util.Java_templateUnicodeConverter;

/**
 * Provides the instances of the UnicodeConverter class to be used when
 * reading Java source files. The UnicodeConverter convert Unicode escape
 * sequences to real characters.
 * Adds the UnicodeConverterProvider to the list of input stream pre-processor
 * providers.
 */
public class UnicodeConverterProvider implements IJava_templateOptionProvider, IJava_templateInputStreamProcessorProvider {
	
	public Java_templateInputStreamProcessor getInputStreamProcessor(InputStream inputStream) {
		return new Java_templateUnicodeConverter(inputStream);
	}
	
	public Map<?, ?> getOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IJava_templateOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER, new UnicodeConverterProvider());
		return map;
	}
}
