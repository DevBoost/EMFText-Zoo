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
package org.emftext.language.simple_math.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.simple_math.Additive;
import org.emftext.language.simple_math.IntegerLiteralExp;
import org.emftext.language.simple_math.NumberAtom;

public class SimpleMathTest extends TestCase {
	
	public void testOnePlusTwo() {
		try {
			Additive root = loadResource(new FileInputStream("input" + File.separator + "one_plus_two.sm"), "one_plus_two.sm");
			// check left
			NumberAtom leftAtom = root.getLeft().getLeft().getAtom();
			assertTrue(leftAtom instanceof IntegerLiteralExp);
			IntegerLiteralExp left = (IntegerLiteralExp) leftAtom;
			assertEquals(1, left.getIntValue());
			
			// check operator
			assertEquals("+", root.getRight().get(0).getOperator());
			
			// check right
			NumberAtom rightAtom = root.getRight().get(0).getMul().getLeft().getAtom();
			assertTrue(rightAtom instanceof IntegerLiteralExp);
			IntegerLiteralExp right = (IntegerLiteralExp) rightAtom;
			assertEquals(2, right.getIntValue());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	public void testBrackets() {
		try {
			Additive root = loadResource(new FileInputStream("input" + File.separator + "brackets.sm"), "brackets.sm");
			assertNotNull(root);
			// check left
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	private static Additive loadResource(InputStream inputStream,
			String fileIdentifier) throws IOException {
		
		SmResourceImplTestWrapper resource = new SmResourceImplTestWrapper();
		resource.load(inputStream, Collections.EMPTY_MAP);
		assertEquals("The resource should have one content element.", 1,
				resource.getContents().size());
		EObject content = resource.getContents().get(0);
		assertTrue("File '" + fileIdentifier
				+ "' was parsed to Additive.",
				content instanceof Additive);
		assertEquals(0, resource.getErrors().size());
		assertEquals(0, resource.getWarnings().size());
		Additive root = (Additive) content;
		return root;
	}

}
