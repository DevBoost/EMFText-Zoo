package org.emftext.language.java.test;


/**
 * A test class that executed all tests from JavaParserTest but
 * does not compare the reprinting results.
 */
public class JavaLanguageFeatureTestWithoutReprintingWithSemanticErrors extends JavaLanguageFeatureTest {

	public void setUp() throws Exception {
		super.setUp();
		
		//JavaClasspath.INSTANCE.registerClassifierJar("/System/Library/Frameworks/JavaVM.framework/Classes/classes.jar");
		
	}
	
	@Override
	protected boolean isExcludedFromReprintTest(String filename) {
		return true;
	}
	
	@Override
	protected boolean ignoreSemanticErrors() {
		return false;
	}
}
