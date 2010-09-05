package org.emftext.language.test.code_completion;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.regexp.resource.regexp_antlr.IRegexp_antlrTextResource;
import org.emftext.language.regexp.resource.regexp_antlr.mopp.Regexp_antlrMetaInformation;
import org.emftext.language.regexp.resource.regexp_antlr.mopp.Regexp_antlrResourceFactory;
import org.emftext.language.regexp.resource.regexp_antlr.ui.Regexp_antlrCodeCompletionHelper;
import org.emftext.language.regexp.resource.regexp_antlr.ui.Regexp_antlrCompletionProposal;

import junit.framework.TestCase;

public class Bug1379Test extends TestCase {

	private static final String FILE_EXTENSION = new Regexp_antlrMetaInformation().getSyntaxName();

	public void setUp() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				FILE_EXTENSION,
				new Regexp_antlrResourceFactory());
	}
	
	public void testPerformance() {
		long startTime = System.currentTimeMillis();
		testPerformance(10);
		testPerformance(100);
		// 1000 is about the size which was reported in the bug report.
		// before the fix, this took about 15 seconds. subsequent calls
		// with bigger input data could not be handled at all, because
		// the complexity of the algorithm was O(n^2) before the fix.
		testPerformance(1000);
		testPerformance(10000);
		testPerformance(100000);
		// now the overall test takes about 10 seconds
		long endTime = System.currentTimeMillis();
		assertTrue("Code completion computations must not take more than one minute.", endTime - startTime < 60000);
	}

	private void testPerformance(int size) {
		String largeRegex = createLargeRegex(size);
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(URI.createURI("temp." + FILE_EXTENSION));
		try {
			resource.load(new ByteArrayInputStream(largeRegex.getBytes()), null);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		assertEquals("Resource must not have errors.", 0, resource.getErrors().size());
		assertTrue(resource instanceof IRegexp_antlrTextResource);
		IRegexp_antlrTextResource textResource = (IRegexp_antlrTextResource) resource;
		Regexp_antlrCodeCompletionHelper helper = new Regexp_antlrCodeCompletionHelper();
		long before = System.currentTimeMillis();
		Regexp_antlrCompletionProposal[] proposals = helper.computeCompletionProposals(textResource, largeRegex, largeRegex.length());
		for (Regexp_antlrCompletionProposal proposal : proposals) {
			System.out.println("Bug1379Test.testPerformance() " + proposal.getInsertString());
		}
		assertEquals(6, proposals.length);
		long after = System.currentTimeMillis();
		System.out.println("testPerformance(" + size + ") took " + (after - before) + "ms");
	}

	private String createLargeRegex(int size) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append("'a'|");
		}
		sb.append("'b'");
		return sb.toString();
	}
}
