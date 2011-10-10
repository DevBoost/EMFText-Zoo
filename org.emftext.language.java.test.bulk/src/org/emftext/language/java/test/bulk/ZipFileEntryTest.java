/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java.test.bulk;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.test.AbstractJavaParserTestCase;

/**
 * A test that can be used to parse and print entries in a 
 * ZIP file.
 */
public class ZipFileEntryTest extends AbstractJavaParserTestCase {

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
	public ZipFileEntryTest(ZipFile zipFile, ZipEntry entry, boolean excludeFromReprint,
			Map<URI, URI> uriMap, Map<String, List<String>> packageClassifierMap) {
		super("Parse " + (excludeFromReprint ? "" : "and reprint: ") + entry.getName());
		this.zipFile = zipFile;
		this.excludeFromReprint = excludeFromReprint;
		//addZipEntry(entry);
		
		this.uriMap = uriMap;
		this.packageClassifierMap = packageClassifierMap;
		
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
	
	protected Map<URI, URI> uriMap = null;
	protected Map<String, List<String>> packageClassifierMap =null; 
	
	@Override
	protected Map<Object, Object> getLoadOptions() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put(JavaClasspath.OPTION_USE_LOCAL_CLASSPATH, Boolean.TRUE);
		map.put(JavaClasspath.OPTION_REGISTER_STD_LIB, Boolean.FALSE);
		return map;
	}
	
	protected ResourceSet getResourceSet() {
		ResourceSet rs = new ResourceSetImpl();
		rs.getLoadOptions().putAll(getLoadOptions());
		JavaClasspath myClasspath = JavaClasspath.get(rs);
		for(String p : packageClassifierMap.keySet()) {
			myClasspath.getPackageClassifierMap().put(p, new ArrayList<String>(
					packageClassifierMap.get(p)));
		}
		rs.getURIConverter().getURIMap().putAll(uriMap);
		return rs;
	}
	
	private void parseAndReprintEntry(ZipEntry entry) throws Exception {
		String plainZipFileName = zipFile.getName().substring(AbstractZipFileInputTest.BULK_INPUT_DIR.length());
		plainZipFileName = plainZipFileName.substring(0, plainZipFileName.length() - File.separator.length() - "src.zip".length());
		
		parseAndReprint(zipFile, entry, "output/" + plainZipFileName, "input/" + plainZipFileName);
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
