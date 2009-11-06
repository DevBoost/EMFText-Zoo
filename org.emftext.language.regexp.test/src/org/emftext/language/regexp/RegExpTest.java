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

import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Collection;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.regexp.resource.regexp.mopp.RegexpMetaInformation;
import org.emftext.language.regexp.resource.regexp.mopp.RegexpResourceFactory;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.test.ConcreteSyntaxTestHelper;
import org.junit.Before;
import org.junit.Test;

// TODO mseifert: add some basic tests for parsing regular expressions
public class RegExpTest extends TestCase {

	private static final String INPUT_FILE_PATH = "input" + File.separator + "test_expressions.txt";

	@Before
	public void setUp() {
		registerResourceFactories();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				new RegexpMetaInformation().getSyntaxName(),
				new RegexpResourceFactory());
	}
	
	@Test
	public void testSimpleExpressions() throws IOException {
		parse("'a'");
	}

	@Test
	public void testExpsFromGrammars() throws IOException {
		// TODO enable this
		//extractExpressionsFromCSFilesToInputFile();
		/*
		LineNumberReader lnr = new LineNumberReader(new FileReader(new File(INPUT_FILE_PATH)));
		String line = lnr.readLine();
		while (line != null) {
			String nextRegexp = line;
			parse(nextRegexp);
			line = lnr.readLine();
		}
		*/
	}

	private void parse(String nextRegexp) {
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createURI("temp." + new RegexpMetaInformation().getSyntaxName()));
		try {
			System.out.println("RegExpTest.parse(): " + nextRegexp);
			r.load(new ByteArrayInputStream(nextRegexp.getBytes()), null);
			EList<Diagnostic> errors = r.getErrors();
			for (Diagnostic error : errors) {
				System.out.println("Error: " + error.getMessage() + "(" + error.getColumn() + ")");
			}
			assertTrue("Errors are found.", errors.size() == 0);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	private void extractExpressionsFromCSFilesToInputFile() throws IOException {
		Collection<String> grammars = ConcreteSyntaxTestHelper.findAllGrammars(new File(".."));
		System.out.println(RegExpTest.class.getSimpleName() + ".testExpsFromGrammars() found " + grammars.size() + " grammar files.");
		// make sure all grammars are found
		assertTrue(grammars.size() > 168);
		
		StringBuffer expressions = new StringBuffer();
		for (String grammar : grammars) {
			Resource resource = ConcreteSyntaxTestHelper.loadCsResource(grammar);

			TreeIterator<EObject> contents = resource.getAllContents();
			while (contents.hasNext()) {
				EObject object = (EObject) contents.next();
				if (object instanceof TokenDefinition) {
					TokenDefinition td = (TokenDefinition) object;
					String regex = td.getRegex();
					regex = regex.replace("\n", "");
					regex = regex.replace("\r", "");
					System.out.println(regex);
					expressions.append(regex + System.getProperty("line.separator"));
				}
			}
		}
		FileWriter writer = new FileWriter(new File(INPUT_FILE_PATH));
		writer.write(expressions.toString());
		writer.close();
	}
}
