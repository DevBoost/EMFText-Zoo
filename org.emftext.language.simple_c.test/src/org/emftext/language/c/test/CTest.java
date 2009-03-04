package org.emftext.language.c.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.emftext.language.simple_c.CompilationUnit;
import org.emftext.language.simple_c.Definition;
import org.emftext.language.simple_c.Variable;

public class CTest extends AbstractCTestCase {
	
	public void testVariables() {
		try {
			CompilationUnit unit = loadResource(new FileInputStream("input\\variables.c"), "variables.c");
			List<Definition> defs = unit.getDefinitions();
			assertEquals(1, defs.size());
			Definition firstDef = defs.get(0);
			assertTrue(firstDef instanceof Variable);
			Variable v1 = (Variable) firstDef;
			assertEquals("a", v1.getName());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}
