package org.emftext.language.theater.test;

import java.io.IOException;
import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.theater.resource.theater.mopp.TheaterResourceFactory;

public abstract class ParsingTestCase extends TestCase {

	public ParsingTestCase() {
		super();
	}

	protected Resource parserInputFile(String pathName) throws IOException {
		TheaterResourceFactory factory = new TheaterResourceFactory();
	
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				"theater", factory);
	
		Resource resource = rs.createResource(URI
		 		.createFileURI(pathName));
		resource.load(Collections.EMPTY_MAP);
		EcoreUtil.resolveAll(resource);
		return resource;
	}

}