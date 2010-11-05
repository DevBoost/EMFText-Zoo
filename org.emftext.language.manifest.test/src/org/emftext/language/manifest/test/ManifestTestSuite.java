package org.emftext.language.manifest.test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.manifest.Manifest;
import org.emftext.language.manifest.ManifestPackage;
import org.emftext.language.manifest.resource.manifest.mopp.MFResourceFactory;
import org.junit.Test;


/**
 * Test suite for parsing several MANIFEST.MF files.
 * Copy MANIFEST.MF files generated from PDE into the input folder and then run the suite.
 * The suite loads all files as Manifest models and saves (prints) them. After that the content
 * as String will be compared. 
 * 
 * @author jreimann
 *
 */
public class ManifestTestSuite {

	private static final String INPUT_FOLDER = "input";

	private File inputFolder;

	public ManifestTestSuite(){
		initInputFolder();
		registerPackages();
	}

	private static void registerPackages() {
		EPackage.Registry.INSTANCE.put(ManifestPackage.eNS_URI, ManifestPackage.eINSTANCE);
		Map<String, Object> extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		extensionToFactoryMap.put("MF", new MFResourceFactory());
	}

	private void initInputFolder() {
		inputFolder = new File(INPUT_FOLDER);
		assertEquals("Input folder doesn't exist", true, inputFolder.exists());
	}

	@Test
	public void testManifestFileParsing(){
		File[] manifestFiles = inputFolder.listFiles(new FilenameFilter() {

			public boolean accept(File dir, String name) {
				return name.endsWith(".MF");
			}
		});
		ResourceSet rs = new ResourceSetImpl();
		for (File file : manifestFiles) {
			System.out.println("Trying to print: " + file.getName());
			URI uri = URI.createFileURI(file.getAbsolutePath());
			Resource resource = rs.getResource(uri, true);
			assertNotNull("Resource could not be loaded", resource);
			Manifest manifest = (Manifest) resource.getContents().get(0);
			assertNotNull("Resource must contain a Manifest model", manifest);
			OutputStream os = new ByteArrayOutputStream();
			try {
				resource.save(os, null);
				os.flush();
			} catch (IOException e) {
				fail("Error while saving model");
			}
			try {
				FileInputStream fileInputStream = new FileInputStream(file);
				byte[] data = new byte[(int) file.length()];
				fileInputStream.read(data);
				fileInputStream.close();
				ByteArrayInputStream is = new ByteArrayInputStream(data);
				byte[] buffer = new byte[is.available()];
				ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
				int bytesRead = is.read(buffer);
				while (bytesRead >= 0) {
					byteOut.write(buffer, 0, bytesRead);
					bytesRead = is.read(buffer);
				}
				StringBuffer original = new StringBuffer(new String(byteOut.toByteArray()));
				StringBuffer copy = new StringBuffer(os.toString());
				assertTrue("Files are not equal", original.equals(copy));
			} catch (FileNotFoundException e) {
				fail("File not found");
			} catch (IOException e) {
				fail("Error while reading file");
			}
		}
	}
}
