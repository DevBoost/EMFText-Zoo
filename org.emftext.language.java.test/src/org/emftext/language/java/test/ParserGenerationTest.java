package org.emftext.language.java.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.emftext.test.ConcreteSyntaxTestHelper.createANTLRGenerator;
import static org.emftext.test.ConcreteSyntaxTestHelper.generateANTLRGrammarToTempFile;
import static org.emftext.test.ConcreteSyntaxTestHelper.getConcreteSyntax;
import static org.emftext.test.ConcreteSyntaxTestHelper.getConcreteSyntaxResource;
import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.junit.Before;
import org.junit.Test;
import org.emftext.sdk.GenPackageByNameFinder;
import org.emftext.sdk.MetamodelHelper;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.IProblemCollector;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.ResourcePackageGenerator;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.runtime.resource.ITextResource;

/**
 * This test checks whether regenerating the parser with EMFText
 * results in the same ANTLR grammar.
 * 
 * This test runs as JUnit test.
 */
public class ParserGenerationTest {
	
	private Map<String, Object> options;
	
	@Before
	public void setUp() {
		options = new HashMap<String, Object>();
		options.put(MetamodelHelper.GEN_PACKAGE_FINDER_KEY, new GenPackageByNameFinder());
		registerResourceFactories();
	}
	
	@Test
	public void testDeterministicParserGeneration() throws IOException, CoreException, InterruptedException {
		String path = "..\\org.reuseware.emftextedit.language.java\\metamodel\\java.cs";
		String absolutePath = new File(path).getAbsolutePath();
		System.out.println(absolutePath);
		URI fileURI = URI.createFileURI(absolutePath);
		
		File result1 = generateANTLRGrammarToTempFile(fileURI, options);
		String content1 = getContent(result1);
		File result2 = generateANTLRGrammarToTempFile(fileURI, options);
		String content2 = getContent(result2);
		assertEquals(content1, content2);

		String grammar1 = getGrammar(fileURI);
		String grammar2 = getGrammar(fileURI);
		assertEquals(grammar1, grammar2);
	}

	private String getGrammar(URI fileURI) throws CoreException {
		ITextResource concreteSyntaxResource = (ITextResource) getConcreteSyntaxResource(fileURI, options);
		ConcreteSyntax concreteSyntax = getConcreteSyntax(concreteSyntaxResource);
		IGenerator antlrGen = createANTLRGenerator(concreteSyntax);
		GenerationContext context = new GenerationContext(concreteSyntax, new IProblemCollector() {

			public void addProblem(GenerationProblem problem) {
				fail(problem.getMessage());
			}
		});
		InputStream grammarStream = ResourcePackageGenerator.deriveGrammar(antlrGen, context);
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
