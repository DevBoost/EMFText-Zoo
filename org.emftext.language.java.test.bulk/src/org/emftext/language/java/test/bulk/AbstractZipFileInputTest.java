package org.emftext.language.java.test.bulk;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.test.AbstractJavaParserTest;

public abstract class AbstractZipFileInputTest extends AbstractJavaParserTest {

	protected final static String BULK_INPUT_DIR = "input/";

	private static final class ParseZipFileEntryTest extends
			AbstractJavaParserTest {

		private final ZipFile zipFile;
		private final ZipEntry entry;
		private final boolean excludeFromReprint;

		private ParseZipFileEntryTest(ZipFile zipFile, ZipEntry entry, boolean excludeFromReprint) {
			super("Parse " + entry.getName());
			this.zipFile = zipFile;
			this.entry = entry;
			this.excludeFromReprint = excludeFromReprint;
		}
		
		public void runTest() {
			try {
				if(isExcludedFromReprintTest(zipFile.getName())) {
					parseResource(zipFile, entry);
				}
				else {
					String plainZipFileName = zipFile.getName().substring(BULK_INPUT_DIR.length());
					plainZipFileName = plainZipFileName.substring(0, plainZipFileName.length() - "-src.zip".length());
					
					parseAndReprint(zipFile, entry, "output/" + plainZipFileName, "lib/" + plainZipFileName);
					
					//for JacksTest: remove java.java from classpath!
					if (entry.getName().equals("java.java")) {
						JavaClasspath.INSTANCE.unRegisterClassifier("", "java");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				org.junit.Assert.fail(e.getClass() + ": " + e.getMessage());
			}
		}

		@Override
		protected ResourceSet getResourceSet() {
			return new ResourceSetImpl();
		}

		@Override
		protected boolean isExcludedFromReprintTest(String filename) {
			return excludeFromReprint;
		}
		
		@Override
		protected boolean ignoreSemanticErrors(String filename) {
			return excludeFromReprint;
		}

		@Override
		protected String getTestInputFolder() {
			return null;
		}
		
		@Override
		public void addParsedResource(File file) {
			// do nothing to avoid storing unneeded file objects in memory
		}

		@Override
		public void addReprintedResource(File file) {
			// do nothing to avoid storing unneeded file objects in memory
		}
	}
	protected static Collection<TestCase> getTestsForZipFileEntries(String zipFilePath, boolean excludeFromReprint) throws IOException, CoreException {
		return getTestsForZipFileEntries(zipFilePath, excludeFromReprint, null);
	}
	
	protected static Collection<TestCase> getTestsForZipFileEntries(String zipFilePath, boolean excludeFromReprint, String startEntry) throws IOException, CoreException {
		Collection<TestCase> tests = new ArrayList<TestCase>();
		final ZipFile zipFile = new ZipFile(zipFilePath);
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		while (entries.hasMoreElements()) {
			
			ZipEntry entry = entries.nextElement();
			if (startEntry != null && !entry.getName().endsWith(startEntry)) {
				continue;
			}
			else {
				startEntry = null;
			}
			if (entry.getName().endsWith(".java")) {
				tests.add(new ParseZipFileEntryTest(zipFile, entry, excludeFromReprint));
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
