package org.emftext.language.java.test.bulk;

import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.emftext.language.java.CompilationUnit;
import org.emftext.language.java.test.AbstractJavaParserTest;

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
				org.junit.Assert.fail(e.getClass() + ": " + e.getMessage());
				e.printStackTrace();
			}
		}

		@Override
		protected boolean isExcludedFromReprintTest(String filename) {
			return true;
		}
	}

	protected static void addZipFileEntriesToTestSuite(TestSuite suite,
			String zipFilePath) throws IOException {
		final ZipFile zipFile = new ZipFile(zipFilePath);
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		while (entries.hasMoreElements()) {
			ZipEntry entry = entries.nextElement();
			if (entry.getName().endsWith(".java")) {
				suite.addTest(new ParseZipFileEntryTest(zipFile, entry));
			}
		}
	}
}
