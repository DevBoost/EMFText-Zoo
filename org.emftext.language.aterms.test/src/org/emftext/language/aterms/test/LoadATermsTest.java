package org.emftext.language.aterms.test;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.aterms.resource.aterms.mopp.AtermsMetaInformation;
import org.emftext.language.aterms.resource.aterms.mopp.AtermsResourceFactory;

import junit.framework.TestCase;

public class LoadATermsTest extends TestCase {
	
	public void setUp() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				new AtermsMetaInformation().getSyntaxName(),
				new AtermsResourceFactory());
	}

	public void testLoading() {
		String path = "path/to/test_file.aterms";
		Resource r = new ResourceSetImpl().createResource(URI.createFileURI(path));
		try {
			r.load(null);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		List<EObject> contents = r.getContents();
		// TODO sheyden: do something with 'contents'
	}
}
