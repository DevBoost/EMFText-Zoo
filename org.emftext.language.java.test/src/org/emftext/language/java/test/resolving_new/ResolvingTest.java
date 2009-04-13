package org.emftext.language.java.test.resolving_new;

import java.io.File;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.java.test.AbstractJavaParserTestCase;

public class ResolvingTest extends AbstractJavaParserTestCase {
	
	public void testResolving() {
		// iterate over all folders in the input folder
		File inputFolder = new File(getTestInputFolder());
		File[] testDirectories = inputFolder.listFiles();
		for (File testDirectory : testDirectories) {
			// collect all java files and parse them into one
			// resource set
			ResourceSet set = new ResourceSetImpl();
			parseAll(testDirectory, set);
			// resolve all references
			// check whether the expected number of targets is present
			// check whether the targets match the expected targets
		}
	}

	private void parseAll(File testDirectory, ResourceSet set) {
		File[] files = testDirectory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				parseAll(file, set);
			} else if (file.getName().endsWith(".java")) {
				// TODO parse file into resource set
			} else {
				fail("Found unexpected unknown file " + file.getAbsolutePath());
			}
		}
	}

	@Override
	protected String getTestInputFolder() {
		return "input" + File.separator + "resolving_new";
	}

	@Override
	protected boolean isExcludedFromReprintTest(String filename) {
		return true;
	}
}
