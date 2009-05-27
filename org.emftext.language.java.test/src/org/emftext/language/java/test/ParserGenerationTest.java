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
package org.emftext.language.java.test;

import static org.emftext.test.ConcreteSyntaxTestHelper.generateANTLRGrammarToTempFile;
import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.emftext.test.GrammarGenerationTestUtil;
import org.junit.Before;
import org.junit.Test;

/**
 * This test checks whether regenerating the parser with EMFText
 * results in the same ANTLR grammar.
 * 
 * This test runs as JUnit test.
 */
public class ParserGenerationTest extends TestCase {
	
	private final static GrammarGenerationTestUtil genUtil = new GrammarGenerationTestUtil();
	
	@Before
	public void setUp() {
		registerResourceFactories();
	}
	
	@Test
	public void testDeterministicParserGeneration() throws IOException, CoreException, InterruptedException {
		String path = ".." + File.separator + "org.emftext.language.java" + File.separator + "metamodel" + File.separator + "java.cs";
		String absolutePath = new File(path).getAbsolutePath();
		System.out.println(absolutePath);
		URI fileURI = URI.createFileURI(absolutePath);
		
		File result1 = generateANTLRGrammarToTempFile(fileURI);
		String content1 = genUtil.getContent(result1);
		File result2 = generateANTLRGrammarToTempFile(fileURI);
		String content2 = genUtil.getContent(result2);
		assertEquals(content1, content2);

		String grammar1 = genUtil.getGrammar(fileURI);
		String grammar2 = genUtil.getGrammar(fileURI);
		assertEquals(grammar1, grammar2);
	}
}
