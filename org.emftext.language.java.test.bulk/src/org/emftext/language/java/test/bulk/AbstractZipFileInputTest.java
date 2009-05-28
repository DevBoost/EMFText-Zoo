/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java.test.bulk;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.test.AbstractJavaParserTestCase;
import org.emftext.language.java.test.util.ThreadedTestSuite;

/**
 * An abstract super class for test that must read input from ZIP files.
 */
public abstract class AbstractZipFileInputTest extends AbstractJavaParserTestCase {

	protected final static String BULK_INPUT_DIR = "input/";
	
	/**
	 * 
	 * @param testFolderName name of folder containing the src.zip and additional jars
	 * @param startEntryName name of an entry in src.zip as start position of the test
	 */
	protected static Test constructSuite(String testFolderName, String startEntryName, int threadNumber) throws CoreException, IOException {
		// run with 8 threads and wait for maximal 5 minutes
		TestSuite suite = new ThreadedTestSuite("Suite testing all files.", 5 * 60 * 1000, threadNumber);
		
		List<String> inputZips = getInputZips(testFolderName);
		for (String inputZip : inputZips) {
			addToTestSuite(suite, getTestsForZipFileEntries(
					inputZip, 
					false, 
					startEntryName));
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
	
	protected static Collection<TestCase> getTestsForZipFileEntries(String zipFilePath, boolean excludeFromReprint) throws IOException, CoreException {
		return getTestsForZipFileEntries(zipFilePath, excludeFromReprint, null);
	}
	
	protected static Collection<TestCase> getTestsForZipFileEntries(String zipFilePath, boolean excludeFromReprint, String startEntry) throws IOException, CoreException {
		Collection<TestCase> tests = new ArrayList<TestCase>();
		final ZipFile zipFile = new ZipFile(zipFilePath);
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		
		Map<URI, URI> uriMap = null; 
		Map<String, List<String>> packageClassifierMap = null;
		
		if (!zipFilePath.endsWith("jdt_test_files" + File.separator + "src.zip")) {
			ResourceSet dummyRS = new ResourceSetImpl();
			dummyRS.getLoadOptions().put(JavaClasspath.OPTION_USE_LOCAL_CLASSPATH, Boolean.TRUE);
			dummyRS.getLoadOptions().put(JavaClasspath.OPTION_REGISTER_STD_LIB, Boolean.FALSE);
			String plainZipFileName = zipFile.getName().substring(AbstractZipFileInputTest.BULK_INPUT_DIR.length());
			plainZipFileName = plainZipFileName.substring(0, plainZipFileName.length() - File.separator.length() - "src.zip".length());
			registerLibs("input/" + plainZipFileName, dummyRS, "");
			uriMap = dummyRS.getURIConverter().getURIMap();
			packageClassifierMap = JavaClasspath.get(dummyRS).getPackageClassifierMap();
		}
		else {
			//for the JDT test file register only the std. lib
			ResourceSet dummyRS = new ResourceSetImpl();
			dummyRS.getLoadOptions().put(JavaClasspath.OPTION_USE_LOCAL_CLASSPATH, Boolean.TRUE);
			dummyRS.getLoadOptions().put(JavaClasspath.OPTION_REGISTER_STD_LIB, Boolean.TRUE);
			uriMap = dummyRS.getURIConverter().getURIMap();
			packageClassifierMap = JavaClasspath.get(dummyRS).getPackageClassifierMap();
		}
		
		
		while (entries.hasMoreElements()) {
			
			ZipEntry entry = entries.nextElement();
			String entryName = entry.getName();
			if (startEntry != null && !entryName.endsWith(startEntry)) {
				continue;
			}
			else {
				startEntry = null;
			}
			if (entryName.endsWith(".java")) {
				ZipFileEntryTest newTest = new ZipFileEntryTest(zipFile, entry, excludeFromReprint, uriMap, packageClassifierMap);
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
