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
package org.emftext.language.java.test.analysis;

import static org.junit.Assert.assertEquals;

import org.emftext.language.java.resource.java.IJavaTokenResolveResult;
import org.emftext.language.java.resource.java.analysis.JavaCHARACTER_LITERALTokenResolver;
import org.emftext.language.java.resource.java.mopp.JavaTokenResolveResult;
import org.junit.Test;

/**
 * Tests the JavaSTRING_LITERALTokenResolver class.
 */
public class JavaCHARACTER_LITERALTokenResolverTest {

	@Test
	public void testUnicodeEscaping() {
		JavaCHARACTER_LITERALTokenResolver resolver = new JavaCHARACTER_LITERALTokenResolver();
		
		//String character = "\t";	
		//System.out.println("ORIG: " + character);
		//System.out.println("RES:  " + resolve(resolver, character));
		//System.out.println("DRES: " + resolver.deResolve(resolve(resolver, character), null,null));
		
		assertEquals('\\', resolve(resolver, "\\\\"));
		assertEquals('\n', resolve(resolver, "\n"));
		assertEquals('\b', resolve(resolver, "\b"));
		assertEquals('\f', resolve(resolver, "\f"));
		assertEquals('\t', resolve(resolver, "\t"));
		assertEquals('\r', resolve(resolver, "\r"));
		assertEquals('\"', resolve(resolver, "\""));
		assertEquals('"', resolve(resolver, "\""));
		assertEquals('\"', resolve(resolver, "\""));
		assertEquals('\'', resolve(resolver, "\'"));
	}

	private char resolve(JavaCHARACTER_LITERALTokenResolver resolver, String lexem) {
		IJavaTokenResolveResult result = new JavaTokenResolveResult();
		resolver.resolve("\'" + lexem + "\'", null, result);
		return (Character) result.getResolvedToken();
	}
}
