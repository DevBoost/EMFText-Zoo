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
package org.emftext.language.regexp.test.antlr;

import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Collection;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.regexp.resource.regexp_antlr.mopp.Regexp_antlrMetaInformation;
import org.emftext.language.regexp.resource.regexp_antlr.mopp.Regexp_antlrResourceFactory;
import org.emftext.language.regexp.test.AbstractTestCase;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.test.ConcreteSyntaxTestHelper;
import org.junit.Before;
import org.junit.Test;

public class RegExpTest extends AbstractTestCase {

	private final static String INPUT_FILE_PATH = "input" + File.separator + "test_expressions.txt";
	private final static String[] EXCLUDES = new String[] {
		".*/invalid_regex1.cs",
		".*/invalid_regex2.cs"
	};

	@Before
	public void setUp() {
		registerResourceFactories();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				new Regexp_antlrMetaInformation().getSyntaxName(),
				new Regexp_antlrResourceFactory());
	}
	
	@Test
	public void testSimpleExpressions() throws IOException {
		parse("'a'");
		parse("('a')");
		parse("'a'|'b'");
		parse("'a'..'b'");
		parse("('a'|'b')");
		parse("'a'|'b'*");
		parse("'a'+|'b'?");
		parse("('a'|'b')+");
		parse("~('a'|'b')");
		parse(".*");
	}

	@Test
	public void testExpsFromGrammars() throws IOException {
		extractExpressionsFromCSFilesToInputFile();
		LineNumberReader lnr = new LineNumberReader(new FileReader(new File(INPUT_FILE_PATH)));
		String line = lnr.readLine();
		while (line != null) {
			String nextRegexp = line;
			parse(nextRegexp);
			line = lnr.readLine();
		}
	}

	private void parse(String nextRegexp) {
		super.parse(nextRegexp, new Regexp_antlrMetaInformation().getSyntaxName());
	}

	private void extractExpressionsFromCSFilesToInputFile() throws IOException {
		Collection<String> grammars = ConcreteSyntaxTestHelper.findAllGrammars(new File(".."), EXCLUDES);
		System.out.println(RegExpTest.class.getSimpleName() + ".testExpsFromGrammars() found " + grammars.size() + " grammar files.");
		// make sure all grammars are found
		assertTrue(grammars.size() > 168);
		
		StringBuffer expressions = new StringBuffer();
		for (String grammar : grammars) {
			Resource resource = ConcreteSyntaxTestHelper.loadCsResource(grammar);

			TreeIterator<EObject> contents = resource.getAllContents();
			while (contents.hasNext()) {
				EObject object = (EObject) contents.next();
				if (object instanceof CompleteTokenDefinition) {
					CompleteTokenDefinition td = (CompleteTokenDefinition) object;
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
