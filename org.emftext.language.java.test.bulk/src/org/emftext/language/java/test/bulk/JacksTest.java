package org.emftext.language.java.test.bulk;

import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.core.runtime.CoreException;
import org.emftext.language.java.test.util.ThreadedTestSuite;


public class JacksTest extends AbstractZipFileInputTest {
	
	private static final String INPUT_FILE = BULK_INPUT_DIR + "jacks_javac_1.6.0_07_passed.zip";
	
	public static Test suite() throws CoreException, IOException {
		TestSuite suite = new ThreadedTestSuite("Suite testing all files in the jacks_input zip file automatically", 5 * 60 * 1000, 8);
		addToTestSuite(suite, getTestsForZipFileEntries(INPUT_FILE, true));
		return suite;
	}

	@Override
	protected boolean isExcludedFromReprintTest(String filename) {
		return true;
	}
	
	@Override
	protected String getTestInputFolder() {
		return null;
	}
}
