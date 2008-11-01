package org.reuseware.emftextedit.language.java.test.bulk;

import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.core.runtime.CoreException;
import org.reuseware.emftextedit.language.java.test.ThreadedTestSuite;


public class JacksTest extends AbstractZipFileInputTest {
	
	private static final String JACKS_INPUT_FILE = BULK_INPUT_DIR + "jacks/jacks_javac_1.6.0_07_passed.zip";
	
	public static Test suite() throws CoreException, IOException {
		TestSuite suite = new ThreadedTestSuite("Suite testing all files in the jacks_input zip file automatically", 1000);
		addZipFileEntriesToTestSuite(suite, "./" + JACKS_INPUT_FILE);
		return suite;
	}

	@Override
	protected boolean isExcludedFromReprintTest(String filename) {
		return true;
	}
}
