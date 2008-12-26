package org.emftext.language.java.test.bulk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.java.core.CompilationUnit;
import org.emftext.language.java.test.AbstractJavaParserTest;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public abstract class AbstractZipFileInputTest extends AbstractJavaParserTest {

	protected final static String BULK_INPUT_DIR = "input/";

	private static final class ParseZipFileEntryTest extends
			AbstractJavaParserTest {
		private final ZipFile zipFile;
		private final ZipEntry entry;

		private ParseZipFileEntryTest(ZipFile zipFile, ZipEntry entry) {
			super("Parse " + entry.getName());
			this.zipFile = zipFile;
			this.entry = entry;
		}
		
		public void runTest() {
			try {
				CompilationUnit unit = parseResource(zipFile, entry, ignoreSemanticErrors());
				assertNotNull(unit);
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
			return true;
		}

		@Override
		protected String getTestInputFolder() {
			return null;
		}
	}

	protected static Collection<TestCase> getTestsForZipFileEntries(String zipFilePath) throws IOException {
		Collection<TestCase> tests = new ArrayList<TestCase>();
		final ZipFile zipFile = new ZipFile(zipFilePath);
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		while (entries.hasMoreElements()) {
			ZipEntry entry = entries.nextElement();
			if (entry.getName().endsWith(".java")) {
				tests.add(new ParseZipFileEntryTest(zipFile, entry));
			}
		}
		return tests;
	}

	protected static void addToTestSuite(TestSuite suite,
			Collection<TestCase> tests) throws IOException {
		for (TestCase test : tests) {
			suite.addTest(test);
		}
	}
}
