package org.emftext.language.chess.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.chess.resource.cg.mopp.CgMetaInformation;
import org.emftext.language.chess.resource.cg.mopp.CgResourceFactory;

import junit.framework.TestCase;

/**
 * This is a test case for bug 1400 (Printing Chess Language fails).
 */
public class ChessPrintingTest extends TestCase {

	private static final String NEW_LINE = System.getProperty("line.separator");
	private static final String FILE_EXTENSION = new CgMetaInformation().getSyntaxName();
	
	public void setUp() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				FILE_EXTENSION,
				new CgResourceFactory());
	}

	public void testPrinting() {
		String input = 
			"  |a |b |c |d |e |f |g |h |" + NEW_LINE +
			"-----------------------------" + NEW_LINE +
			"#1|bR|bk|bB|bQ|bK|bB|bk|bR|#1" + NEW_LINE +
			"-----------------------------" + NEW_LINE +
			"#2|bP|bP|bP|bP|bP|bP|bP|bP|#2" + NEW_LINE +
			"-----------------------------" + NEW_LINE +
			"#3|  |  |  |  |  |  |  |  |#3" + NEW_LINE +
			"-----------------------------" + NEW_LINE +
			"#4|  |  |  |  |  |  |  |  |#4" + NEW_LINE +
			"-----------------------------" + NEW_LINE +
			"#5|  |  |  |  |  |  |  |  |#5" + NEW_LINE +
			"-----------------------------" + NEW_LINE +
			"#6|  |  |  |  |  |  |  |  |#6" + NEW_LINE +
			"-----------------------------" + NEW_LINE +
			"#7|wP|wP|wP|wP|wP|wP|wP|wP|#7" + NEW_LINE +
			"-----------------------------" + NEW_LINE +
			"#8|wR|wk|wB|bQ|bK|wB|wk|wR|#8" + NEW_LINE +
			"-----------------------------" + NEW_LINE +
			"  |a |b |c |d |e |f |g |h |";
		
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(URI.createURI("test." + FILE_EXTENSION));
		try {
			resource.load(new ByteArrayInputStream(input.getBytes()), null);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			resource.save(outputStream, null);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		// check the reprinted version of the model is equal to the original input
		String reprintResult = outputStream.toString();
		assertEquals(input, reprintResult);
	}
}
