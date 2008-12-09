package org.emftext.language.c.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.emftext.language.simple_c.CompilationUnit;

public class AbstractCTest extends TestCase {
	
	protected CompilationUnit loadResource(InputStream inputStream,
			String fileIdentifier) throws IOException {
		
		CompilationUnit cUnit = tryToLoadResource(inputStream, fileIdentifier);
		assertNotNull(cUnit);
		assertSuccessfulParsing(cUnit.eResource());
		return cUnit;
	}

	protected CompilationUnit tryToLoadResource(InputStream inputStream,
			String fileIdentifier) throws IOException {
		
		CResourceImplTestWrapper resource = new CResourceImplTestWrapper();
		resource.load(inputStream, Collections.EMPTY_MAP);
		assertEquals("The resource should have one content element.", 1,
				resource.getContents().size());
		EObject content = resource.getContents().get(0);
		assertTrue("File '" + fileIdentifier
				+ "' was parsed to CompilationUnit.",
				content instanceof CompilationUnit);
		CompilationUnit cUnit = (CompilationUnit) content;
		return cUnit;
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
