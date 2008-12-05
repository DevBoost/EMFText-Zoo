package org.reuseware.emftextedit.language.c.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.reuseware.emftextedit.language.simple_c.CompilationUnit;

public class ForceEOFTest extends AbstractCTest {
	
	private static final String TEST_INPUT_FROM_MEMORY = "int x;;";

	public void testForceEOF() {
		try {
			CompilationUnit unit = loadResource(new ByteArrayInputStream(TEST_INPUT_FROM_MEMORY.getBytes()), "test_input_from_memory.c");
			assertNotNull(unit);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}
