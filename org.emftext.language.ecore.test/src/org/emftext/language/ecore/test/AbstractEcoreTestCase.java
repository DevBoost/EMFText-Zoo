package org.emftext.language.ecore.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ecore.EcoreResource;

public class AbstractEcoreTestCase extends TestCase {
		
	protected EPackage loadResource(InputStream inputStream,
			String fileIdentifier) throws IOException {
		
		EcoreResource resource = tryToLoadResource(inputStream, fileIdentifier);
		assertEquals("The resource should have one content element.", 1,
				resource.getContents().size());
		EObject content = resource.getContents().get(0);
		assertTrue("File '" + fileIdentifier
				+ "' was parsed to EPackage.",
				content instanceof EPackage);
		EPackage ePackage = (EPackage) content;
		assertNotNull(ePackage);
		assertSuccessfulParsing(ePackage.eResource());
		return ePackage;
	}

	protected EcoreResource tryToLoadResource(InputStream inputStream,
			String fileIdentifier) throws IOException {
		
		EcoreResourceTestWrapper resource = new EcoreResourceTestWrapper();
		resource.load(inputStream, Collections.EMPTY_MAP);
		return resource;
	}

	private void assertSuccessfulParsing(Resource resource) {
		print(resource.getErrors());
		print(resource.getWarnings());
		assertEquals(0, resource.getErrors().size());
		assertEquals(0, resource.getWarnings().size());
	}

	private void print(EList<Diagnostic> diagnostics) {
		for (Diagnostic diagnostic : diagnostics) {
			System.out.println(diagnostic.getMessage());
		}
	}
}
