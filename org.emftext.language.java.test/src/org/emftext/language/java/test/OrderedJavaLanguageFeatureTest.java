package org.emftext.language.java.test;

import org.junit.Test;

public class OrderedJavaLanguageFeatureTest {

	@Test
	public void testOrdered() throws Exception {
		JavaLanguageFeatureTest test = new JavaLanguageFeatureTest() {

			@Override
			protected boolean isExcludedFromReprintTest(String filename) {
				return true;
			}
		};
		
		test.testUnicode();
		test.testVariableReferencing();
		
		test.testEmptyClass();
		test.testBooleanExpressions();
		
		test.testEmptyEnum();
		test.testBlocks();
		test.testArguments();
		test.testSuperKeyword();
		test.testBasicEnums();
		//test.testPrimitiveTypeArrays();
		test.testTypeReferencing();
		
		//test.testHasMissingParses();
	}
}
