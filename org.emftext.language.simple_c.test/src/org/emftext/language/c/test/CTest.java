/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
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
