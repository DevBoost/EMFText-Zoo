/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java.test.bulk;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.test.AbstractJavaParserTestCase;
import org.emftext.language.java.test.util.ThreadedSuite;

/**
 * An abstract super class for test that must read input from ZIP files.
 */
public abstract class AbstractZipFileInputTestCase extends AbstractJavaParserTestCase {

	protected final static String BULK_INPUT_DIR = "input/";

	/**
	 *
	 * @param testFolderName name of folder containing the src.zip and additional jars
	 * @param startEntryName name of an entry in src.zip as start position of the test
	 * @param prefixUsedInZipFile 
	 */
	protected static Test constructSuite(String testFolderName, String startEntryName, int threadNumber) throws CoreException, IOException {
		return constructSuite(testFolderName, startEntryName, threadNumber, new String[] {}, false);
	}

	protected static Test constructSuite(String testFolderName, String startEntryName, int threadNumber, String[] excludedTests) throws CoreException, IOException {
		return constructSuite(testFolderName, startEntryName, threadNumber, excludedTests, false);
	}

	protected static Test constructSuite(String testFolderName, String startEntryName, int threadNumber, String[] excludedTests, boolean prefixUsedInZipFile) throws CoreException, IOException {
		// run with 'threadNumber' threads and wait for maximal 50 minutes
		TestSuite suite = new ThreadedSuite("Suite testing all files.", 50 * 60 * 1000, threadNumber);

		List<String> inputZips = getInputZips(testFolderName);
		for (String inputZip : inputZips) {
			addToTestSuite(suite, getTestsForZipFileEntries(
					inputZip,
					false,
					startEntryName,
					excludedTests,
					prefixUsedInZipFile));
		}
		return suite;
	}

	protected static List<String> getInputZips(String testFolderName) {
		List<String> result = new ArrayList<String>();

		File dir = new File(BULK_INPUT_DIR);
		File[] folders = dir.listFiles();
		boolean srcZipExists = false;
		for (File folder : folders) {
			if(folder.isDirectory()) {
				for(File srcZipFile: folder.listFiles()) {
					if (srcZipFile.getName().equals("src.zip") && folder.getName().endsWith(testFolderName)) {
						System.out.println("TheTest.getInputZips() " + folder);
						result.add(BULK_INPUT_DIR + folder.getName() +
								File.separator +
								srcZipFile.getName());
						srcZipExists = true;
					}
				}
			}
		}

		if (!srcZipExists) {
			System.err.println("src.zip not found in folder '" + testFolderName + "'.");
		}

		return result;
	}

	@Override
	protected boolean isExcludedFromReprintTest(String filename) {
		return true;
	}

	@Override
	protected String getTestInputFolder() {
		return null;
	}

	protected static Collection<TestCase> getTestsForZipFileEntries(String zipFilePath, boolean excludeFromReprint, boolean prefixUsedInZipFile) throws IOException, CoreException {
		return getTestsForZipFileEntries(zipFilePath, excludeFromReprint, null, new String[] {}, prefixUsedInZipFile);
	}

	protected static Collection<TestCase> getTestsForZipFileEntries(String zipFilePath, boolean excludeFromReprint, String startEntry, String[] excludedTests, boolean prefixUsedInZipFile) throws IOException, CoreException {
		Collection<TestCase> tests = new ArrayList<TestCase>();
		final ZipFile zipFile = new ZipFile(zipFilePath);
		Enumeration<? extends ZipEntry> entries = zipFile.entries();

		if (!prefixUsedInZipFile) {
			//reuse global classpath
			JavaClasspath.getInitializers().add(new JavaClasspath.Initializer() {			
				public boolean requiresStdLib() {
					return false;
				}
				
				public boolean requiresLocalClasspath() {
					return true;
				}
				
				public void initialize(Resource resource) { }
			});
			JavaClasspath globalCP = JavaClasspath.get();
			String plainZipFileName = zipFile.getName().substring(AbstractZipFileInputTestCase.BULK_INPUT_DIR.length());
			plainZipFileName = plainZipFileName.substring(0, plainZipFileName.length() - File.separator.length() - "src.zip".length());
			registerLibs("input/" + plainZipFileName, globalCP, "");
		} else {
			//for the JDT test file register only the std. lib
			JavaClasspath.getInitializers().add(new JavaClasspath.Initializer() {			
				public boolean requiresStdLib() {
					return true;
				}
				
				public boolean requiresLocalClasspath() {
					return true;
				}
				
				public void initialize(Resource resource) { }
			});
			//trigger init
			JavaClasspath.get();
		}


		mainLoop: while (entries.hasMoreElements()) {

			ZipEntry entry = entries.nextElement();
			String entryName = entry.getName();
			if (startEntry != null && !entryName.endsWith(startEntry)) {
				continue mainLoop;
			}
			else {
				startEntry = null;
			}
			for (String excludedTest : excludedTests) {
				if (entryName.endsWith(excludedTest)) {
					continue mainLoop;
				}
			}
			if (entryName.endsWith(".java")) {
				ZipFileEntryTestCase newTest = new ZipFileEntryTestCase(zipFile, entry, excludeFromReprint, prefixUsedInZipFile);
				tests.add(newTest);
			}
		}
		return tests;
	}

	protected static Collection<URI> getURIsForZipFileEntries(String zipFilePath) throws IOException, CoreException {
		Collection<URI> streams = new ArrayList<URI>();
		final ZipFile zipFile = new ZipFile(zipFilePath);
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		while (entries.hasMoreElements()) {
			ZipEntry entry = entries.nextElement();
			if (entry.getName().endsWith(".java")) {
				URI sourceURI = URI.createURI("archive:file:///" + new File(".").getAbsoluteFile().toURI().getRawPath() + zipFile.getName().replaceAll("\\\\", "/") + "!/" + entry.getName());
				streams.add(sourceURI);
			}
		}
		return streams;
	}

	protected static void addToTestSuite(TestSuite suite,
			Collection<TestCase> tests) throws IOException {
		for (TestCase test : tests) {
			suite.addTest(test);
		}
	}
}
