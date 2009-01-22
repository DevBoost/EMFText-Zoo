package org.emftext.language.java.test.bulk;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;

import junit.framework.TestCase;
import junit.framework.TestResult;

public class Eclipse341SerializedTest extends AbstractZipFileInputTest {

	
	public void testSerialized() throws CoreException {
		try {
			Collection<TestCase> tests = getTestsForZipFileEntries(Eclipse341Test.INPUT_FILE, true);
			int count = 1;
			int failed = 0;
			for (TestCase test : tests) {
				System.out.print(count + " testSerialized() " + test.getName());
				TestResult result = test.run();
				int failures = result.failureCount() + result.errorCount();
				if (failures == 0) {
					System.out.println(" passed.");
				} else {
					System.err.println(" failed.");
					failed++;
				}
				count++;
				//assertTrue("Parsing test should not fail.", result.wasSuccessful());
			}
			System.out.println("Eclipse341SerializedTest.testSerialized() Failed total: " + failed);
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
