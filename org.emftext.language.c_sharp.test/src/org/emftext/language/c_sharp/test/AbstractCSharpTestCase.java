package org.emftext.language.c_sharp.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.emftext.language.c_sharp.CompilationUnit;
import org.emftext.language.c_sharp.resource.csharp.CsharpResource;
import org.emftext.language.c_sharp.test.cssyntaxcheck.CheckCSPrecondition;

public class AbstractCSharpTestCase extends TestCase {
		
	protected CompilationUnit loadResource(InputStream inputStream,
			String fileIdentifier) throws IOException {
		
		CsharpResource resource = tryToLoadResource(inputStream, fileIdentifier);
		assertEquals("The resource should have one content element.", 1,
				resource.getContents().size());
		EObject content = resource.getContents().get(0);
		assertTrue("File '" + fileIdentifier
				+ "' was parsed to CompilationUnit.",
				content instanceof CompilationUnit);
		CompilationUnit cUnit = (CompilationUnit) content;
		assertNotNull(cUnit);
		assertSuccessfulParsing(cUnit.eResource());
		return cUnit;
	}

	protected CsharpResource tryToLoadResource(InputStream inputStream,
			String fileIdentifier) throws IOException {
		
		CSharpResourceImplTestWrapper resource = new CSharpResourceImplTestWrapper();
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
	
	//checks if the running os is windows
	protected boolean checkCSharpPreconditons(){
		return CheckCSPrecondition.checkAll();
	}
}
