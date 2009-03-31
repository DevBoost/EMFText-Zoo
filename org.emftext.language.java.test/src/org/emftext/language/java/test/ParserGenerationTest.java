package org.emftext.language.java.test;

import static org.emftext.test.ConcreteSyntaxTestHelper.createANTLRGenerator;
import static org.emftext.test.ConcreteSyntaxTestHelper.generateANTLRGrammarToTempFile;
import static org.emftext.test.ConcreteSyntaxTestHelper.getConcreteSyntax;
import static org.emftext.test.ConcreteSyntaxTestHelper.getConcreteSyntaxResource;
import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import junit.framework.Assert;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.junit.Before;
import org.junit.Test;

/**
 * This test checks whether regenerating the parser with EMFText
 * results in the same ANTLR grammar.
 * 
 * This test runs as JUnit test.
 */
public class ParserGenerationTest {
	
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
		String content1 = getContent(result1);
		File result2 = generateANTLRGrammarToTempFile(fileURI);
		String content2 = getContent(result2);
		assertEquals(content1, content2);

		String grammar1 = getGrammar(fileURI);
		String grammar2 = getGrammar(fileURI);
		assertEquals(grammar1, grammar2);
	}

	private String getGrammar(URI fileURI) throws CoreException {
		ITextResource concreteSyntaxResource = (ITextResource) getConcreteSyntaxResource(fileURI);
		ConcreteSyntax concreteSyntax = getConcreteSyntax(concreteSyntaxResource);
		IGenerator antlrGen = createANTLRGenerator(concreteSyntax);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		antlrGen.generate(new PrintWriter(out));
		InputStream grammarStream = new ByteArrayInputStream(out.toByteArray());
		return getContent(grammarStream);
	}

	private String getContent(InputStream grammarStream) {
		StringBuffer content = new StringBuffer();
		try {
			InputStreamReader reader = new InputStreamReader(grammarStream);
			int next = -1;
			while ((next = reader.read()) >= 0) {
				content.append((char) next);
			}
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
		return content.toString();
	}

	private String getContent(File file) {
		try {
			return getContent(new FileInputStream(file));
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
		return null;
	}
}
