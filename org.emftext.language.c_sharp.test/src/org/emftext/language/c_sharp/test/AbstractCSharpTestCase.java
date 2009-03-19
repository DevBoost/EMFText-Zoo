package org.emftext.language.c_sharp.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.c_sharp.namespaces.CompilationUnit;
import org.emftext.language.c_sharp.resource.csharp.CsharpResource;
import org.emftext.language.c_sharp.test.cssyntaxcheck.CheckCSPrecondition;

public abstract class AbstractCSharpTestCase extends TestCase {
	
	private static final String CSHARP_FILE_EXTENSION = ".csharp";

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
	
	protected String getFileExtension() {
		return CSHARP_FILE_EXTENSION;
	}
		
	protected abstract String getTestInputFolder();
	
	
	protected ResourceSet getResourceSet() {
		return new ResourceSetImpl();
	}
	
	protected CompilationUnit loadResource(URI uri) throws IOException {
		
		CsharpResource resource = tryToLoadResource(uri);
		
		assertEquals("The resource should have one content element.", 1,
				resource.getContents().size());
		EObject content = resource.getContents().get(0);
		assertTrue("File '" + uri.toFileString()
				+ "' was parsed to CompilationUnit.",
				content instanceof CompilationUnit);
		CompilationUnit cUnit = (CompilationUnit) content;
		assertNotNull(cUnit);
		assertSuccessfulParsing(cUnit.eResource());
		return cUnit;
	}
	/*
	private JavaRoot loadResource(
			URI uri) throws IOException {
		ITextResource resource = (ITextResource) getResourceSet().createResource(uri);
		resource.load(getLoadOptions());
		assertNoErrors(uri.toString(), resource);
		assertNoWarnings(uri.toString(), resource);
		assertEquals("The resource should have one content element.", 1,
				resource.getContents().size());
		EObject content = resource.getContents().get(0);
		assertTrue("File '" + uri.toString()
				+ "' was parsed to CompilationUnit.",
				content instanceof JavaRoot);
		JavaRoot root = (JavaRoot) content;
		return root;
	}*/

	protected CsharpResource tryToLoadResource(URI uri) throws IOException {
		
		CsharpResource resource = new CsharpResource(uri);
		resource.load(Collections.EMPTY_MAP);
		for (Diagnostic diagnostic : resource.getErrors()) {
			System.out.println("tryToLoadResource(" + uri + ") found error in resource " + diagnostic.getMessage() + "(" + diagnostic.getLine() + "," + diagnostic.getColumn() + ")");
		}
		System.out.println(resource.getContents());
		return resource;
	}
	
	private CompilationUnit loadResource(
			String filePath) throws IOException {
		return loadResource(URI.createFileURI(filePath));
	}
	
	
	protected CompilationUnit parseResource(String filename,
			String inputFolderName) throws Exception {
		return parseResource(new File(filename), inputFolderName);
	}

	protected CompilationUnit parseResource(File inputFile,
			String inputFolderName) throws IOException {
		File inputFolder = new File("./" + inputFolderName);
		File file = new File(inputFolder, inputFile.getPath());
		assertTrue("File " + file + " should exist.", file.exists());
		//addParsedResource(file);
		return loadResource(file.getCanonicalPath());
	}

	protected CompilationUnit assertParsesToCompilationUnit(
			String typename) throws Exception {
		String filename = typename + getFileExtension();
		EObject model = parseResource(filename, getTestInputFolder());
		
		assertType(model, CompilationUnit.class);
		if (model instanceof CompilationUnit) {
			return (CompilationUnit)model;
		}
		else {
			return null;
		}
		
	}
	
	protected void assertType(EObject object, Class<?> expectedType) {
		assertTrue("The object should have type '"
				+ expectedType.getSimpleName() + "', but was "
				+ object.getClass().getSimpleName(), expectedType
				.isInstance(object));
	}

	public CsharpResource load(File cFile) throws IOException {
		return load(new FileInputStream(cFile));
	}
	
	public CsharpResource load(InputStream inputStream) throws IOException {
		Map<?, ?> options = Collections.EMPTY_MAP;
		CsharpResource resource = new CsharpResource();
		resource.load(inputStream, options);
		inputStream.close();
		return resource;
	}
}
