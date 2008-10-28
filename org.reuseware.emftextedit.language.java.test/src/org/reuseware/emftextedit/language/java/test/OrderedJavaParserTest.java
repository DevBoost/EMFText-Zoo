package org.reuseware.emftextedit.language.java.test;

import org.junit.Test;

public class OrderedJavaParserTest {

	@Test
	public void testOrdered() throws Exception {
		JavaParserTest test = new JavaParserTest() {

			@Override
			protected boolean isExcludedFromReprintTest(String filename) {
				return true;
			}
		};
		test.testEmptyClass();
		test.testEmptyEnum();
		test.testBlocks();
		test.testArguments();
		test.testSuperKeyword();
		test.testBasicEnums();
		test.testPrimitiveTypeArrays();
		test.testTypeReferencing();
		test.testHasMissingParses();
	}
}
