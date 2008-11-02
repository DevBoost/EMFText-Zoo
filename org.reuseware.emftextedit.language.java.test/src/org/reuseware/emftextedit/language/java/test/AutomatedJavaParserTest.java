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
		"Suite testing all files in the input directory automatically", 1000, 100);
		File inputFolder = new File("./" + TEST_INPUT_FOLDER_NAME);
		List<File> allTestFiles = collectAllFilesRecursive(inputFolder);
		for (final File file : allTestFiles) {
			addParseTest(test, suite, file);
			addParseAndReprintTest(test, suite, file);
		}
		
		return suite;
	}

	private static void addParseTest(final AutomatedJavaParserTest test,
			TestSuite suite, final File file) {
		suite.addTest(new TestCase("Parse " + file.getName()) {
			public void runTest() {
				try {
					test.parseResource(file, "./");
				}
				catch (Exception e) {
					fail(e.getClass() +  ": " + e.getMessage());
					e.printStackTrace();
				}
			}
		});
	}

	private static void addParseAndReprintTest(
			final AutomatedJavaParserTest test, TestSuite suite, final File file) {
		suite.addTest(new TestCase("Parse and Reprint " + file.getName()) {
			public void runTest() {
				try {
					test.parseAndReprint(file.getName(), TEST_INPUT_FOLDER_NAME, TEST_OUTPUT_FOLDER_NAME);
				}
				catch (Exception e) {
					fail(e.getClass() +  ": " + e.getMessage());
					e.printStackTrace();
				}
				
			}
		});
	}

	@Override
	protected boolean isExcludedFromReprintTest(String filename) {
		return false;
	}
}
