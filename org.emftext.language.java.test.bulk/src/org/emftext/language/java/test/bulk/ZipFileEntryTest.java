package org.emftext.language.java.test.bulk;

import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.test.AbstractJavaParserTest;

public class ZipFileEntryTest extends AbstractJavaParserTest {

	private final ZipFile zipFile;
	private final ZipEntry entry;
	private final boolean excludeFromReprint;
	private ResourceSet resourceSet;

	public ZipFileEntryTest(ZipFile zipFile, ZipEntry entry, boolean excludeFromReprint) {
		this(zipFile, entry, excludeFromReprint, null);
	}
	
	/**
	 * Creates a new test for the given entry in a ZIP file. If a resource set is given
	 * it will be used. Otherwise a new one will be created.
	 * 
	 * @param zipFile
	 * @param entry
	 * @param excludeFromReprint
	 * @param resourceSet
	 */
	public ZipFileEntryTest(ZipFile zipFile, ZipEntry entry, boolean excludeFromReprint, ResourceSet resourceSet) {
		super("Parse " + (excludeFromReprint ? "" : "and reprint: ") + entry.getName());
		this.zipFile = zipFile;
		this.entry = entry;
		this.excludeFromReprint = excludeFromReprint;
		this.resourceSet = resourceSet;
	}
	
	public void runTest() {
		try {
			if(isExcludedFromReprintTest(zipFile.getName())) {
				parseResource(zipFile, entry);
			}
			else {
				String plainZipFileName = zipFile.getName().substring(AbstractZipFileInputTest.BULK_INPUT_DIR.length());
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
		if (resourceSet == null) {
			return new ResourceSetImpl();
		} else {
			ResourceSet result = resourceSet;
			resourceSet = null;
			return result;
		}
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