package org.emftext.language.java.test.bulk;

import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.core.runtime.CoreException;
import org.emftext.language.java.test.util.ThreadedTestSuite;

public class Tomcat6Test extends AbstractZipFileInputTest {
	
	private static final String INPUT_FILE = BULK_INPUT_DIR + "apache-tomcat-6.0.18-src.zip";
	
	public static Test suite() throws CoreException, IOException {
		registerLibs("lib/tomcat");
		TestSuite suite = new ThreadedTestSuite("Suite testing all files in the tomcat 6 zip file", 10 * 60 * 1000, 8);
		addToTestSuite(suite, getTestsForZipFileEntries(INPUT_FILE, false));
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
