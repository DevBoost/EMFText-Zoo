package org.emftext.language.java.test;

/**
 * A test class that executed all tests from JavaParserTest but
 * does not compare the reprinting results.
 */
public class JavaLanguageFeatureTestWithoutReprinting extends JavaLanguageFeatureTest {

	public JavaLanguageFeatureTestWithoutReprinting() throws Exception {
		super();
	}

	@Override
	protected boolean isExcludedFromReprintTest(String filename) {
		return true;
	}
	
	@Override
	protected boolean ignoreSemanticErrors(String filename) {
		return true;
	}
}
