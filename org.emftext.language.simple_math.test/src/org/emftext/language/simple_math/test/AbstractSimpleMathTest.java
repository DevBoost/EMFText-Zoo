package org.emftext.language.simple_math.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.simple_math.Root;
import org.emftext.language.simple_math.resource.sm.mopp.SmMetaInformation;
import org.emftext.language.simple_math.resource.sm.mopp.SmResourceFactory;

public abstract class AbstractSimpleMathTest extends TestCase {
	
	public void setUp() throws Exception {
		super.setUp();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				new SmMetaInformation().getSyntaxName(),
				new SmResourceFactory());
	}

	public Root loadResource(InputStream inputStream,
			String fileIdentifier) throws IOException {

		Resource resource = load(inputStream, fileIdentifier);
		assertEquals("The resource should have one content element.", 1,
				resource.getContents().size());
		EObject content = resource.getContents().get(0);
		assertTrue("File '" + fileIdentifier + "' was parsed to type Root.",
				content instanceof Root);
		assertEquals(0, resource.getErrors().size());
		assertEquals(0, resource.getWarnings().size());
		Root root = (Root) content;
		return root;
	}

	public Resource load(File file) throws IOException {
		InputStream inputStream = new FileInputStream(file);
		return load(inputStream, file.getAbsolutePath());
	}

	private Resource load(InputStream inputStream, String uri)
			throws IOException {
		Map<?, ?> options = getLoadOptions();
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(URI.createURI("temp." + new SmMetaInformation().getSyntaxName()));
		resource.load(inputStream, options);
		inputStream.close();
		return resource;
	}

	public abstract Map<?, ?> getLoadOptions();
}
