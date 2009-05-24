package org.emftext.language.java.test;

import org.junit.Test;

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
