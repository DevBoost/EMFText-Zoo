package org.reuseware.emftextedit.language.c.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EObject;
import org.reuseware.emftextedit.language.simple_c.CompilationUnit;
import org.reuseware.emftextedit.language.simple_c.Definition;
import org.reuseware.emftextedit.language.simple_c.Variable;

public class CTest extends TestCase {
	
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


	private static CompilationUnit loadResource(InputStream inputStream,
			String fileIdentifier) throws IOException {
		
		CResourceImplTestWrapper resource = new CResourceImplTestWrapper();
		resource.load(inputStream, Collections.EMPTY_MAP);
		assertEquals("The resource should have one content element.", 1,
				resource.getContents().size());
		EObject content = resource.getContents().get(0);
		assertTrue("File '" + fileIdentifier
				+ "' was parsed to CompilationUnit.",
				content instanceof CompilationUnit);
		CompilationUnit cUnit = (CompilationUnit) content;
		return cUnit;
	}

}
