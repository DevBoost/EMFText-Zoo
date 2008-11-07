package org.reuseware.emftextedit.language.java.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Before;
import org.junit.Test;
import org.reuseware.emftextedit.GenPackageByNameFinder;
import org.reuseware.emftextedit.MetamodelManager;
import org.reuseware.emftextedit.codegen.BaseGenerator;
import org.reuseware.emftextedit.codegen.IGenerator;
import org.reuseware.emftextedit.codegen.ResourcePackageGenerator;
import org.reuseware.emftextedit.codegen.TextParserGenerator;
import org.reuseware.emftextedit.concretesyntax.ConcreteSyntax;
import org.reuseware.emftextedit.concretesyntax.resource.cs.CsResourceImpl;
import org.reuseware.emftextedit.resource.TextResource;
import org.reuseware.emftextedit.resource.impl.TextResourceImpl;

/**
 * This test checks whether regenerating the parser with EMFText
 * results in the same Java code.
 * 
 * This test must be run as JUnit Plug-in test.
 */
public class ParserGenerationTest {
	
	@Before
	public void setUp() {
		MetamodelManager.INSTANCE.addGenPackageFinder(new GenPackageByNameFinder());
		org.reuseware.emftextedit.concretesyntax.resource.cs.CsResourceFactoryImpl csResourceFactoryImpl = new org.reuseware.emftextedit.concretesyntax.resource.cs.CsResourceFactoryImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"genmodel", new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"cs", csResourceFactoryImpl);
	}
	
	@Test
	public void parserRegeneration() throws IOException, CoreException, InterruptedException {
		String path = "..\\org.reuseware.emftextedit.language.java\\metamodel\\java.cs";
		String absolutePath = new File(path).getAbsolutePath();
		System.out.println(absolutePath);
		URI fileURI = URI.createFileURI(absolutePath);
		
		File result1 = generateToTempFile(fileURI);
		String content1 = getContent(result1);
		File result2 = generateToTempFile(fileURI);
		String content2 = getContent(result2);
		assertEquals(content1, content2);

		String grammar1 = getGrammar(fileURI);
		String grammar2 = getGrammar(fileURI);
		assertEquals(grammar1, grammar2);
	}

	private String getGrammar(URI fileURI) throws CoreException {
		TextResource concreteSyntaxResource = (TextResource) getConcreteSyntaxResource(fileURI);
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

	private File generateToTempFile(URI fileURI)
			throws IOException, FileNotFoundException {
		ConcreteSyntax concreteSyntax = getConcreteSyntax(getConcreteSyntaxResource(fileURI));
		assertNotNull("The concrete syntax should be successfully loaded.", concreteSyntax);
		
		IGenerator antlrGenerator = createANTLRGenerator(concreteSyntax);

		File tempGrammarFile = File.createTempFile(ParserGenerationTest.class.getSimpleName(), ".g");
		tempGrammarFile.deleteOnExit();
	    boolean success = antlrGenerator.generate(new PrintWriter(new FileOutputStream(tempGrammarFile)));
	    assertTrue(success);
	    return tempGrammarFile;
	}

	private IGenerator createANTLRGenerator(ConcreteSyntax concreteSyntax) {
		String antlrName = BaseGenerator.cap(concreteSyntax.getName());
		GenPackage csPackage = concreteSyntax.getPackage();
		String csBasePackage = csPackage.getBasePackage();
		EPackage ecorePackage = csPackage.getEcorePackage();
		String csPackageName = (csBasePackage == null ? "" : csBasePackage + ".") + ecorePackage.getName() + ".resource." + concreteSyntax.getName();
		String tokenResolverFactoryName = antlrName + ResourcePackageGenerator.CLASS_TOKEN_RESOLVER_FACTORY;
		
		IGenerator antlrGenerator = new TextParserGenerator(
	    		concreteSyntax,
	    		antlrName,
	    		csPackageName,
	    		tokenResolverFactoryName
	    );
		return antlrGenerator;
	}

	private Resource getConcreteSyntaxResource(URI fileURI) {
		CsResourceImpl resource = new CsResourceImpl(fileURI);
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(TextResourceImpl.OPTION_NO_VALIDATE, Boolean.TRUE);
		try {
			resource.load(options);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		return resource;
	}

	private ConcreteSyntax getConcreteSyntax(Resource csResource) {
		ConcreteSyntax concreteSyntax = (ConcreteSyntax) csResource.getContents().get(0);
		return concreteSyntax;
	}
}
