package org.reuseware.emftextedit.language.java.test.bulk;

import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.core.runtime.CoreException;
import org.reuseware.emftextedit.language.java.test.ThreadedTestSuite;

public class Eclipse341Test extends AbstractZipFileInputTest {
	
	private static final String INPUT_FILE = BULK_INPUT_DIR + "eclipse-3.4.1-platform-src-java-files.zip";

	public static Test suite() throws CoreException, IOException {
		TestSuite suite = new ThreadedTestSuite("Suite testing all files in the eclipse 3.4.1 zip file", 1000, 100);
		addZipFileEntriesToTestSuite(suite, "./" + INPUT_FILE);
		return suite;
	}

	@Override
	protected boolean isExcludedFromReprintTest(String filename) {
		return true;
	}
}
