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
package org.emftext.language.java.test.bcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import junit.framework.TestCase;

import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.Field;
import org.apache.bcel.classfile.JavaClass;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;

public class BCELTest extends TestCase {

	public void testParsingOfDuplicateFinalStaticFields() {
		JavaClass myClass = readClassFile("bin", ClassWithTwoFinalStaticFields.class);
		
		Field[] fields = myClass.getFields();
		assertEquals(2, fields.length);
		
		assertIsFinalAndStatic(fields[0]);
		assertIsFinalAndStatic(fields[1]);
	}

	public void testParsingOfClassASTNode() {
		testParsingOfClassASTNode("src");
		testParsingOfClassASTNode("bin");
	}

	private void testParsingOfClassASTNode(String folder) {
		JavaClass myClass = readClassFile(folder, ASTNode.class);
		
		Field[] fields = myClass.getFields();
		int f = 0;
		boolean foundDidResolveField = false;
		for (Field field : fields) {
			assertNotNull("Field " + f + " is null.", field);
			if (field.isStatic() && field.isFinal()) {
				f++;
			}
			if (field.getName().equals("DidResolve")) {
				foundDidResolveField = true;
			}
		}
		assertEquals(128, f);
		assertTrue(foundDidResolveField);
	}

	private JavaClass readClassFile(String folder, Class<?> aClass) {
		try {
			String classFileName = aClass.getSimpleName() + ".class";
	
			String path = folder + 
				File.separator + 
				aClass.getName().replace(".", File.separator) +
				".class";
			
			FileInputStream fis = new FileInputStream(path);
			
			JavaClass myClass = new ClassParser(fis, classFileName).parse();
			return myClass;
		} catch (IOException e) {
			fail(e.getMessage());
		}
		return null;
	}

	private void assertIsFinalAndStatic(Field field) {
		assertTrue(field + " should be static.", field.isStatic());
		assertTrue(field + " should be final.", field.isFinal());
	}
}
