package org.emftext.language.java.test.bulk;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.emftext.language.java.test.AbstractJavaParserTest;

public abstract class AbstractZipFileInputTest extends AbstractJavaParserTest {

	protected final static String BULK_INPUT_DIR = "input/";

	protected static Collection<TestCase> getTestsForZipFileEntries(String zipFilePath, boolean excludeFromReprint) throws IOException, CoreException {
		return getTestsForZipFileEntries(zipFilePath, excludeFromReprint, null);
	}
	
	protected static Collection<TestCase> getTestsForZipFileEntries(String zipFilePath, boolean excludeFromReprint, String startEntry) throws IOException, CoreException {
		Collection<TestCase> tests = new ArrayList<TestCase>();
		final ZipFile zipFile = new ZipFile(zipFilePath);
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		
		Map<String, ZipFileEntryTest> foldersToTests = new HashMap<String, ZipFileEntryTest>();
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
				ZipFileEntryTest newTest = new ZipFileEntryTest(zipFile, entry, excludeFromReprint);
				// TODO put this somewhere else
				if (zipFilePath.endsWith("jdt_test_files-src.zip")) {
					int pos = entryName.indexOf("/");
					pos = entryName.indexOf("/", pos + 1);
					String folderName = entryName.substring(0, pos);
					if (!foldersToTests.containsKey(folderName)) {
						System.out.println("adding test for folder " + folderName);
						foldersToTests.put(folderName, newTest);
						tests.add(newTest);
					} else {
						System.out.println("adding additional entry to test in " + folderName);
						foldersToTests.get(folderName).addZipEntry(entry);
					}
				} else {
					tests.add(newTest);
				}
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
