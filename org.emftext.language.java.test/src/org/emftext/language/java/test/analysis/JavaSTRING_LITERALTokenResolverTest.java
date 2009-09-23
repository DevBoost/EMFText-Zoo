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
package org.emftext.language.java.test.analysis;

import static org.junit.Assert.assertEquals;

import org.emftext.language.java.resource.java.IJavaTokenResolveResult;
import org.emftext.language.java.resource.java.analysis.JavaSTRING_LITERALTokenResolver;
import org.emftext.language.java.resource.java.mopp.JavaTokenResolveResult;
import org.junit.Test;

/**
 * Tests the JavaSTRING_LITERALTokenResolver class.
 */
public class JavaSTRING_LITERALTokenResolverTest {

	@Test
	public void testUnicodeEscaping() {
		JavaSTRING_LITERALTokenResolver resolver = new JavaSTRING_LITERALTokenResolver();
		assertEquals("\0\07\007\0007", resolve(resolver, "\\0\\07\\007\\0007"));
		assertEquals("\07", resolve(resolver, "\\07"));
		assertEquals("\007", resolve(resolver, "\\007"));
		assertEquals("\0007", resolve(resolver, "\\0007"));

		// test ordinary unicode escape sequence
		assertEquals("\u0020", resolve(resolver, "\\u0020"));
		// test escaped backslash (not a unicode sequence)
		assertEquals("\\u0020", resolve(resolver, "\\\\u0020"));

		assertEquals("\\", resolve(resolver, "\\\\"));
		assertEquals("\n", resolve(resolver, "\\n"));
		assertEquals("\b", resolve(resolver, "\\b"));
		assertEquals("\f", resolve(resolver, "\\f"));
		assertEquals("\t", resolve(resolver, "\\t"));
		assertEquals("\r", resolve(resolver, "\\r"));
		assertEquals("\"", resolve(resolver, "\\\""));
		assertEquals("\'", resolve(resolver, "\\\'"));
		
		assertEquals("\0", resolve(resolver, "\\0"));
		assertEquals("\10", resolve(resolver, "\\10"));
		assertEquals("\377", resolve(resolver, "\\377"));
	}

	private String resolve(JavaSTRING_LITERALTokenResolver resolver, String lexem) {
		IJavaTokenResolveResult result = new JavaTokenResolveResult();
		resolver.resolve("\"" + lexem + "\"", null, result);
		return (String) result.getResolvedToken();
	}
}
