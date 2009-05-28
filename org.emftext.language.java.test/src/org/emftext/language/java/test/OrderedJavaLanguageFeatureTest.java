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
package org.emftext.language.java.test;

import org.junit.Test;

/**
 * A test that can be used to execute the test methods from the
 * JavaLanguageFeatureTest in a specified order. This is useful
 * when a particular test method fails and one wants to run this
 * one first.
 */
public class OrderedJavaLanguageFeatureTest {

	@Test
	public void testOrdered() throws Exception {
		JavaLanguageFeatureTest test = new JavaLanguageFeatureTest() {

			@Override
			protected boolean isExcludedFromReprintTest(String filename) {
				return false;
			}
		};
		
		test.testNoTypeArgument();
		test.testRoundedLiterals();
		test.testTempLiterals();
//		test.testBooleanExpressions();
//		test.testEmptyEnum();
//		test.testBlocks();
//		test.testArguments();
//		test.testSuperKeyword();
//		test.testBasicEnums();
//		test.testPrimitiveTypeArrays();
//		test.testTypeReferencing();
		
		//test.testHasMissingParses();
	}
}
