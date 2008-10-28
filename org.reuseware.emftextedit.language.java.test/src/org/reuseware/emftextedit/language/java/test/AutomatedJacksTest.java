package org.reuseware.emftextedit.language.java.test;

import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.core.runtime.CoreException;


public class AutomatedJacksTest extends AbstractJavaParserTest {
	
	private static final String JACKS_INPUT_FILE = "input_jacks/jacks_javac_1.6.0_07_passed.zip";
	protected static final String TEST_OUTPUT_FOLDER_NAME = "output_jacks/";

	public static Test suite() throws CoreException, IOException {
		TestSuite suite = new ThreadedTestSuite("Suite testing all files in the jacks_input zip file automatically", 1000);
		final ZipFile zipFile = new ZipFile("./" + JACKS_INPUT_FILE);
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		while (entries.hasMoreElements()) {
			final ZipEntry entry = entries.nextElement();
			suite.addTest(new AbstractJavaParserTest("Parse and Reprint " + entry.getName()) {
				public void runTest() {
					try {
						parseAndReprint(zipFile, entry, TEST_OUTPUT_FOLDER);
					}
					catch (Exception e) {
						org.junit.Assert.fail(e.getClass() +  ": " + e.getMessage());
						e.printStackTrace();
					}
				}

				@Override
				protected boolean isExcludedFromReprintTest(String filename) {
					return true;
				}
			});
		}
		
		return suite;
		
	}

	@Override
	protected boolean isExcludedFromReprintTest(String filename) {
		return true;
	}
}
