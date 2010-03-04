/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
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
		
		test.testSpecialCharacters();
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
