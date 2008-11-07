package org.reuseware.emftextedit.language.java.test;

import static org.junit.Assert.assertEquals;
import static org.reuseware.emftextedit.test.ConcreteSyntaxTestHelper.createANTLRGenerator;
import static org.reuseware.emftextedit.test.ConcreteSyntaxTestHelper.generateANTLRGrammarToTempFile;
import static org.reuseware.emftextedit.test.ConcreteSyntaxTestHelper.getConcreteSyntax;
import static org.reuseware.emftextedit.test.ConcreteSyntaxTestHelper.getConcreteSyntaxResource;
import static org.reuseware.emftextedit.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import junit.framework.Assert;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.junit.Before;
import org.junit.Test;
import org.reuseware.emftextedit.GenPackageByNameFinder;
import org.reuseware.emftextedit.MetamodelManager;
import org.reuseware.emftextedit.codegen.IGenerator;
import org.reuseware.emftextedit.codegen.ResourcePackageGenerator;
import org.reuseware.emftextedit.concretesyntax.ConcreteSyntax;
import org.reuseware.emftextedit.resource.TextResource;

/**
 * This test checks whether regenerating the parser with EMFText
 * results in the same Java code.
 * 
 * This test runs as JUnit test.
 */
public class ParserGenerationTest {
	
	@Before
	public void setUp() {
		MetamodelManager.INSTANCE.addGenPackageFinder(new GenPackageByNameFinder());
		registerResourceFactories();
	}
	
	@Test
	public void parserRegeneration() throws IOException, CoreException, InterruptedException {
		String path = "..\\org.reuseware.emftextedit.language.java\\metamodel\\java.cs";
		String absolutePath = new File(path).getAbsolutePath();
		System.out.println(absolutePath);
		URI fileURI = URI.createFileURI(absolutePath);
		
		File result1 = generateANTLRGrammarToTempFile(fileURI, true);
		String content1 = getContent(result1);
		File result2 = generateANTLRGrammarToTempFile(fileURI, true);
		String content2 = getContent(result2);
		assertEquals(content1, content2);

		String grammar1 = getGrammar(fileURI);
		String grammar2 = getGrammar(fileURI);
		assertEquals(grammar1, grammar2);
	}

	private String getGrammar(URI fileURI) throws CoreException {
		TextResource concreteSyntaxResource = (TextResource) getConcreteSyntaxResource(fileURI, true);
		ConcreteSyntax concreteSyntax = getConcreteSyntax(concreteSyntaxResource);
		IGenerator antlrGen = createANTLRGenerator(concreteSyntax);
		InputStream grammarStream = ResourcePackageGenerator.deriveGrammar(concreteSyntaxResource, antlrGen);
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
