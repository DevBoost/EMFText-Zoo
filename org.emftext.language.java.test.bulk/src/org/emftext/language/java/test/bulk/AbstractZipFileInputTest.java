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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.containers.JavaRoot;
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
				JavaRoot unit = parseResource(zipFile, entry);
				
				assertNotNull(unit);
				
				parseAndReprint(zipFile, entry, "output/" + zipFile.getName());
				
				//TODO put somewhere suitable 
				//for JacksTest: remove java.java from classpath!
				if (entry.getName().equals("java.java")) {
					JavaClasspath.INSTANCE.unRegisterClassifier("", "java");
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
			return false;
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

	protected static Collection<TestCase> getTestsForZipFileEntries(String zipFilePath, boolean excludeFromReprint) throws IOException {
		Collection<TestCase> tests = new ArrayList<TestCase>();
		final ZipFile zipFile = new ZipFile(zipFilePath);
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		while (entries.hasMoreElements()) {
			ZipEntry entry = entries.nextElement();
			if (entry.getName().endsWith(".java")) {
				tests.add(new ParseZipFileEntryTest(zipFile, entry, excludeFromReprint));
				
				String fullName = entry.getName();
				fullName = shortenPathUntil(fullName, "org/");
				fullName = shortenPathUntil(fullName, "com/");
				
				fullName = fullName.replaceAll("/", "."); 
				
				String packageName = "";
				String className   = "";
				
				int idx = fullName.lastIndexOf(".");
				idx = fullName.substring(0, idx).lastIndexOf(".");
				if (idx >= 0) {
					packageName = fullName.substring(0, idx);
					className   = fullName.substring(idx + 1, fullName.lastIndexOf("."));
				}	
				
				URI uri = URI.createURI("archive:file:///" + new File(".").getAbsoluteFile().toURI().getRawPath() + zipFilePath + "!/" + entry.getName());
				
				JavaClasspath.INSTANCE.registerClassifier(packageName, className, uri);
			}
		}
		
		return tests;
	}

	private static String shortenPathUntil(String path, String root) {
		int idx = path.indexOf(root);
		if (idx != -1) {
			return path.substring(idx);
		}
		return path;
	}
	
	
	protected static void addToTestSuite(TestSuite suite,
			Collection<TestCase> tests) throws IOException {
		for (TestCase test : tests) {
			suite.addTest(test);
		}
	}
}
