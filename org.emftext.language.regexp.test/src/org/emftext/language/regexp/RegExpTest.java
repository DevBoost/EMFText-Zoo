/*******************************************************************************
 * Copyright (c) 2006-2009 
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
package org.emftext.language.regexp;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.test.ConcreteSyntaxTestHelper;
import org.junit.Test;

// TODO mseifert: add some basic tests for parsing regular expressions
public class RegExpTest extends TestCase {

	@Test
	public void testExpsFromGrammars() throws IOException {
		
		Collection<String> grammars = ConcreteSyntaxTestHelper.findAllGrammars(new File(".."));
		System.out.println(RegExpTest.class.getSimpleName() + ".testExpsFromGrammars() found " + grammars.size() + " grammar files.");
		// make sure all grammars are found
		assertTrue(grammars.size() > 140);
		
		for (String grammar : grammars) {
			System.out.println("AntlrTranslationTest.testExpsFromGrammars() testing " + grammar);
			Resource resource = ConcreteSyntaxTestHelper.loadCsResource(grammar);

			TreeIterator<EObject> contents = resource.getAllContents();
			while (contents.hasNext()) {
				EObject object = (EObject) contents.next();
				if (object instanceof TokenDefinition) {
					TokenDefinition td = (TokenDefinition) object;
					String regex = td.getRegex();
					System.out.println(regex);
				}
			}
		}
	}
}
