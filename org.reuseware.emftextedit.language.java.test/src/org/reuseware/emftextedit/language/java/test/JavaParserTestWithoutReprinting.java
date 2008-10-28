package org.reuseware.emftextedit.language.java.test;

/**
 * A test class that executed all tests from JavaParserTest but
 * does not compare the reprinting results.
 */
public class JavaParserTestWithoutReprinting extends JavaParserTest {

	@Override
	protected boolean isExcludedFromReprintTest(String filename) {
		return true;
	}
}
