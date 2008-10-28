package org.reuseware.emftextedit.language.java.test;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;

import junit.framework.Test;
import junit.framework.TestSuite;


public class AllTests {
	
	public static Test suite() throws CoreException, IOException {
		TestSuite suite = new TestSuite(
				"Test for org.reuseware.emftextedit.language.java.test");
		//$JUnit-BEGIN$
		suite.addTestSuite(JavaParserTest.class);
		suite.addTest(AutomatedJavaParserTest.suite());
		suite.addTest(AutomatedJacksTest.suite());
		
		//$JUnit-END$
		return suite;
	}
}
