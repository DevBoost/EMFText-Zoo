package org.emftext.language.java.test.resolving;

import java.io.IOException;

import org.eclipse.jface.text.BadLocationException;
import org.junit.Test;

public class ReferenceToInheritedMethodTest extends AbstractResolverTestCase {
	
	@Test
	public void testReferencing() throws Exception {
		// TODO jjohannes: fix this test cases and enabled them afterwards
		//testReferencing("MethodCallsWithoutInheritance");
		//testReferencing("ReferenceToInheritedMethod");
	}

	private void testReferencing(String typename) throws IOException, BadLocationException {
		String filename =  typename + ".java";
		parseAndReprint(filename);
	}
}
