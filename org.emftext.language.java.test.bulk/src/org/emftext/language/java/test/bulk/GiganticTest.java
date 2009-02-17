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
		TestSuite suite = new ThreadedTestSuite("Suite testing all files.", 5 * 60 * 1000, 8);
		
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
		File[] folders = dir.listFiles();
		for (File folder : folders) {
			if(folder.isDirectory()) {
				for(File srcZipFile: folder.listFiles()) {
					if (srcZipFile.getName().equals("src.zip") && folder.getName().endsWith("")) {
						System.out.println("TheTest.getInputZips() " + folder);
						result.add(BULK_INPUT_DIR + folder.getName() + 
								File.separator + 
								srcZipFile.getName());
					}
				}
			}
		}
		return result;
	}

	public static List<String> getIgnoreList() {
		List<String> ignoreList = new ArrayList<String>();
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
