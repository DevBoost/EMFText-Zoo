/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java.properties.resource.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.emftext.language.java.properties.resource.propjava.IPropjavaInputStreamProcessorProvider;
import org.emftext.language.java.properties.resource.propjava.IPropjavaOptionProvider;
import org.emftext.language.java.properties.resource.propjava.IPropjavaOptions;
import org.emftext.language.java.properties.resource.propjava.mopp.PropjavaInputStreamProcessor;
import org.emftext.language.java.properties.resource.propjava.util.PropjavaUnicodeConverter;

/**
 * Provides the instances of the UnicodeConverter class to be used when
 * reading Java source files. The UnicodeConverter convert Unicode escape
 * sequences to real characters.
 * Adds the UnicodeConverterProvider to the list of input stream pre-processor
 * providers.
 */
public class UnicodeConverterProvider implements IPropjavaOptionProvider, IPropjavaInputStreamProcessorProvider {
	
	public PropjavaInputStreamProcessor getInputStreamProcessor(InputStream inputStream) {
		return new PropjavaUnicodeConverter(inputStream);
	}
	
	public Map<?, ?> getOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IPropjavaOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER, new UnicodeConverterProvider());
		return map;
	}
}
