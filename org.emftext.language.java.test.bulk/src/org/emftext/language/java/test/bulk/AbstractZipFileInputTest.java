package org.emftext.language.java.test.bulk;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.JavaUniquePathConstructor;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.containers.JavaRoot;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.MemberContainer;
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
				
				Map<URI,URI> urisToRestore = new HashMap<URI, URI>();
				
				if (unit instanceof CompilationUnit) {
					CompilationUnit cu = (CompilationUnit) unit;
					remeberClassifierURIs(cu, urisToRestore);
				}

				parseAndReprint(zipFile, entry, "output/" + zipFile.getName());
				
				//reset to class files
				JavaClasspath.INSTANCE.URI_MAP.putAll(urisToRestore);
	
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
		
		protected void remeberClassifierURIs(CompilationUnit cu, Map<URI,URI> urisToRestore) {
			String packageName = JavaUniquePathConstructor.packageName(cu);
			
			for(Classifier classifier : cu.getClassifiers()) {
				URI javaURI  = JavaUniquePathConstructor.getJavaFileResourceURI(packageName + "." + classifier.getName());
				URI classURI = JavaClasspath.INSTANCE.URI_MAP.get(javaURI);
				
				urisToRestore.put(javaURI, classURI);
				
				remeberInnerClassifierURIs(
						classifier, packageName, classifier.getName(), urisToRestore);
			}
		}
		
		protected void remeberInnerClassifierURIs(Classifier classifier, String packageName, String className,  Map<URI,URI> urisToRestore) {
			for(Member innerCand : ((MemberContainer)classifier).getMembers()) {
				if (innerCand instanceof Classifier) {
					URI javaURI  = JavaUniquePathConstructor.getJavaFileResourceURI(packageName + "." + className + "$" + innerCand.getName());
					URI classURI = JavaClasspath.INSTANCE.URI_MAP.get(javaURI);
					
					urisToRestore.put(javaURI, classURI);
				}
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
		Collection<TestCase> tests = new ArrayList<TestCase>();
		final ZipFile zipFile = new ZipFile(zipFilePath);
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		while (entries.hasMoreElements()) {
			ZipEntry entry = entries.nextElement();
			if (entry.getName().endsWith(".java")) {
				tests.add(new ParseZipFileEntryTest(zipFile, entry, excludeFromReprint));
			}
		}
		return tests;
	}
	
	protected static void registerLibs(String libdir) throws IOException, CoreException  {
		File libFolder = new File("." + File.separator
				+ libdir);
		List<File> allLibFiles = collectAllFilesRecursive(libFolder);
		
		for(File lib : allLibFiles) {
			JavaClasspath.INSTANCE.registerClassifierJar(URI.createFileURI(lib.getAbsolutePath()));
		}
	}
	
	protected static void addToTestSuite(TestSuite suite,
			Collection<TestCase> tests) throws IOException {
		for (TestCase test : tests) {
			suite.addTest(test);
		}
	}
}
