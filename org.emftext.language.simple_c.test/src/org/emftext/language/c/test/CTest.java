package org.emftext.language.c.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.emftext.language.simple_c.CPackage;
import org.emftext.language.simple_c.CompilationUnit;
import org.emftext.language.simple_c.Definition;
import org.emftext.language.simple_c.Method;
import org.emftext.language.simple_c.Statement;
import org.emftext.language.simple_c.Variable;

public class CTest extends AbstractCTestCase {
	
	public void testVariables() {
		try {
			CompilationUnit unit = (CompilationUnit)loadResource(new FileInputStream("input" + File.separator + "variables.c"), "variables.c", null);
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
	
	public void testMethodFragment(){
		try {
			Method method = (Method)loadResource(new FileInputStream("input" + File.separator + "method.c"), "method.c", CPackage.eINSTANCE.getMethod());
			List<Statement> statements = method.getStatements();
			assertEquals(1, statements.size());
		} catch (IOException e) {
			fail(e.getMessage());
		}
		
	}
}
