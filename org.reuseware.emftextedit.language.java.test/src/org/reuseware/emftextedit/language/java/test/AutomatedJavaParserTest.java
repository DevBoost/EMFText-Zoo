package org.reuseware.emftextedit.language.java.test;

import java.io.File;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.runtime.CoreException;


public class AutomatedJavaParserTest extends AbstractJavaParserTest {
	
	protected static final String TEST_INPUT_FOLDER_NAME = "input";
	protected static final String TEST_OUTPUT_FOLDER_NAME = "output";
	
	public static Test suite() throws CoreException {
		final AutomatedJavaParserTest test = new AutomatedJavaParserTest();
		
		TestSuite suite = new ThreadedTestSuite(
		"Suite testing all files in the input directory automatically", 1000);
		File inputFolder = new File("./" + TEST_INPUT_FOLDER_NAME);
		List<File> allTestFiles = collectAllFilesRecursive(inputFolder);
		for (final File file : allTestFiles) {
			suite.addTest(new TestCase("Parse " + file.getName()) {
				public void runTest() {
					try {
						test.parseResource(file, TEST_INPUT_FOLDER_NAME);
					}
					catch (Exception e) {
						this.fail(e.getClass() +  ": " + e.getMessage());
						e.printStackTrace();
					}
				}
			});
			suite.addTest(new TestCase("Parse and Reprint " + file.getName()) {
				public void runTest() {
					try {
						test.parseAndReprint(file.getName(), TEST_INPUT_FOLDER_NAME, TEST_OUTPUT_FOLDER_NAME);
					}
					catch (Exception e) {
						this.fail(e.getClass() +  ": " + e.getMessage());
						e.printStackTrace();
					}
					
				}
			});
		}
		
		return suite;
		
	}


	@Override
	protected boolean isExcludedFromReprintTest(String filename) {
		return false;
	}
}
