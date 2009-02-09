package org.emftext.language.java.test.bulk;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.core.runtime.CoreException;
import org.emftext.language.java.test.util.ThreadedTestSuite;

public class GiganticTest extends AbstractZipFileInputTest {

	public static Test suite() throws CoreException, IOException {
		// run with 8 threads and wait for maximal 5 minutes
		TestSuite suite = new ThreadedTestSuite("Suite testing all files.", 5 * 60 * 1000, 1);
		
		List<String> inputZips = getInputZips();
		for (String inputZip : inputZips) {
			addToTestSuite(suite, getTestsForZipFileEntries(
					inputZip, 
					false, 
					"",
					getIgnoreList()));
		}
		return suite;
	}

	protected static List<String> getInputZips() {
		List<String> result = new ArrayList<String>();
		
		File dir = new File(BULK_INPUT_DIR);
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.getName().endsWith("3.0.0.M1-src.zip")) {
				System.out.println("TheTest.getInputZips() " + file);
				result.add(BULK_INPUT_DIR + file.getName());
			}
		}
		return result;
	}

	public static List<String> getIgnoreList() {
		List<String> ignoreList = new ArrayList<String>();
		
		//missing dependency to oracle top link
		ignoreList.add("spring-framework-3.0.0.M1/projects/org.springframework.orm/src/main/java/org/springframework/orm/jpa/vendor/TopLinkJpaVendorAdapter.java");		
		ignoreList.add("spring-framework-3.0.0.M1/projects/org.springframework.orm/src/main/java/org/springframework/orm/jpa/vendor/TopLinkJpaDialect.java");
		ignoreList.add("spring-framework-3.0.0.M1/projects/org.springframework.samples.petclinic/src/main/java/org/springframework/samples/petclinic/toplink/EssentialsHSQLPlatformWithNativeSequence.java");


		return ignoreList;
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
