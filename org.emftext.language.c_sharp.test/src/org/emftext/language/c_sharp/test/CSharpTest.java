package org.emftext.language.c_sharp.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.emftext.language.c_sharp.CompilationUnit;
import org.emftext.language.c_sharp.Definition;
import org.emftext.language.c_sharp.Variable;

public class CSharpTest extends AbstractCSharpTest {
	
	public void testVariables() {
		try {
			CompilationUnit unit = loadResource(new FileInputStream("input"+File.separator+"variables.c"), "variables.c");
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
