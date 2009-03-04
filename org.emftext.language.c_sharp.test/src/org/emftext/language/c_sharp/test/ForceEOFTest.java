package org.emftext.language.c_sharp.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.emftext.language.c_sharp.resource.cs.CsResource;

public class ForceEOFTest extends AbstractCSharpTestCase {
	
	private static final String TEST_INPUT_FROM_MEMORY = "int x;;";

	public void testForceEOF() {
		try {
			CsResource resource = tryToLoadResource(new ByteArrayInputStream(TEST_INPUT_FROM_MEMORY.getBytes()), "test_input_from_memory.c");
			assertTrue("Additional semicolon at the end should prevent successful parsing", resource.getErrors().size() > 0);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}
