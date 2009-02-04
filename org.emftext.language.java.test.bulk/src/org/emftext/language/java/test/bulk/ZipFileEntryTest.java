package org.emftext.language.java.test.bulk;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.test.AbstractJavaParserTest;

public class ZipFileEntryTest extends AbstractJavaParserTest {

	private final ZipFile zipFile;
	private final List<ZipEntry> entries = new ArrayList<ZipEntry>();
	private final boolean excludeFromReprint;

	/**
	 * Creates a new test for the given entry in a ZIP file. If a resource set is given
	 * it will be used. Otherwise a new one will be created.
	 * 
	 * @param zipFile
	 * @param entry
	 * @param excludeFromReprint
	 * @param resourceSet
	 */
	public ZipFileEntryTest(ZipFile zipFile, ZipEntry entry, boolean excludeFromReprint) {
		super("Parse " + (excludeFromReprint ? "" : "and reprint: ") + entry.getName());
		this.zipFile = zipFile;
		this.excludeFromReprint = excludeFromReprint;
		//addZipEntry(entry);
		entries.add(entry);
	}
	
	public void addZipEntry(ZipEntry entry) {
		System.out.println(hashCode() + " addZipEntry() " + entry.getName());
		entries.add(entry);
	}
	
	public void runTest() {
		try {
			if(isExcludedFromReprintTest(zipFile.getName())) {
				parseAllEntries();
			}
			else {
				// if there is more entries that must be printed
				// together we have to parse them before
				if (entries.size() > 1) {
					parseAllEntries();
				}
				parseAndReprintAllEntries();
			}
		} catch (Exception e) {
			e.printStackTrace();
			org.junit.Assert.fail(e.getClass() + ": " + e.getMessage());
		}
	}

	private void parseAndReprintEntry(ZipEntry entry) throws Exception {
		String plainZipFileName = zipFile.getName().substring(AbstractZipFileInputTest.BULK_INPUT_DIR.length());
		plainZipFileName = plainZipFileName.substring(0, plainZipFileName.length() - "-src.zip".length());
		
		parseAndReprint(zipFile, entry, "output/" + plainZipFileName, "lib/" + plainZipFileName);
		
		//for JacksTest: remove java.java from classpath!
		if (entry.getName().equals("java.java")) {
			JavaClasspath.INSTANCE.unRegisterClassifier("", "java");
		}
	}

	private void parseAllEntries() throws IOException {
		for (ZipEntry entry : entries) {
			parseResource(zipFile, entry);
		}
	}

	private void parseAndReprintAllEntries() throws Exception {
		for (ZipEntry entry : entries) {
			parseAndReprintEntry(entry);
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