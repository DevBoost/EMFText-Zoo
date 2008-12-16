package org.emftext.language.java.test.bulk;

import java.io.IOException;
import java.util.Collection;

import junit.framework.TestCase;
import junit.framework.TestResult;

public class Eclipse341SerializedTest extends AbstractZipFileInputTest {

	
	public void testSerialized() {
		try {
			Collection<TestCase> tests = getTestsForZipFileEntries(Eclipse341Test.INPUT_FILE);
			for (TestCase test : tests) {
				TestResult result = test.run();
				//assertTrue("Parsing test should not fail.", result.wasSuccessful());
			}
		} catch (IOException ioe) {
			fail(ioe.getMessage());
		}
	}
	
	@Override
	protected String getTestInputFolder() {
		return null;
	}

	@Override
	protected boolean isExcludedFromReprintTest(String filename) {
		return true;
	}
}
