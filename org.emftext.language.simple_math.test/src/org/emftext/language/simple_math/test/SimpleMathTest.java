package org.emftext.language.simple_math.test;

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
			Additive root = loadResource(new FileInputStream("input\\one_plus_two.sm"), "one_plus_two.sm");
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
			Additive root = loadResource(new FileInputStream("input\\brackets.sm"), "brackets.sm");
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
