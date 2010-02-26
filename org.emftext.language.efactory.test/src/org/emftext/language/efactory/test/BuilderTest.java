package org.emftext.language.efactory.test;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.efactory.Factory;
import org.emftext.language.efactory.builder.Builder;
import org.emftext.language.efactory.resource.efactory.mopp.EfactoryMetaInformation;

import junit.framework.TestCase;

/**
 * A test that check whether the EFactory build does create
 * correct models from .efactory files.
 */
public class BuilderTest extends TestCase {

	private final static String EFACTORY_FILE_EXTENSION = "." + new EfactoryMetaInformation().getSyntaxName();

	public void setUp() {
		// register XMI and EFactory resource factory
		// register test meta models
	}
	
	public void testBuilding() {
		File inputFolder = new File("." + File.separator + "input");
		File[] inputFiles = inputFolder.listFiles(new FilenameFilter() {
			
			public boolean accept(File dir, String name) {
				return name.endsWith(EFACTORY_FILE_EXTENSION);
			}
		});
		for (File inputFile : inputFiles) {
			testBuilding(inputFile);
		}
	}

	private void testBuilding(File inputFile) {
		// load .efactory file
		ResourceSetImpl rs = new ResourceSetImpl();
		String absolutePath = inputFile.getAbsolutePath();
		Resource resource = rs.getResource(URI.createFileURI(absolutePath), true);
		assertNotNull(resource);
		List<EObject> contents = resource.getContents();
		assertEquals(1, contents.size());
		EObject root = contents.get(0);
		assertTrue(root instanceof Factory);
		Factory factory = (Factory) root;
		// build model
		Builder builder = new Builder();
		EObject builtModel = builder.build(factory);
		// load expected model
		String pathToExpectedModel = absolutePath.substring(0, absolutePath.length() - EFACTORY_FILE_EXTENSION.length()) + ".xmi";
		Resource expectedResource = rs.getResource(URI.createFileURI(pathToExpectedModel), true);
		List<EObject> expectedContents = expectedResource.getContents();
		assertEquals(1, expectedContents.size());
		EObject expectedRoot = expectedContents.get(0);
		// compare built model and expected one
	}
}
