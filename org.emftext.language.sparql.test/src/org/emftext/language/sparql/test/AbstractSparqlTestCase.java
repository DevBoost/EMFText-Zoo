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
package org.emftext.language.sparql.test;

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
import org.emftext.language.sparql.SparqlQueries;
import org.emftext.language.sparql.resource.sparql.mopp.RqResource;;

public abstract class AbstractSparqlTestCase extends TestCase {
	
	private static final String SPARQL_FILE_EXTENSION = ".sparql";

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
	
	protected String getFileExtension() {
		return SPARQL_FILE_EXTENSION;
	}
		
	protected abstract String getTestInputFolder();
	
	
	protected ResourceSet getResourceSet() {
		return new ResourceSetImpl();
	}
	
	protected SparqlQueries loadResource(URI uri) throws IOException {
			
		RqResource resource = tryToLoadResource(uri);
		
		assertEquals("The resource should have one content element.", 1,
				resource.getContents().size());
		EObject content = resource.getContents().get(0);
		assertTrue("File '" + uri.toFileString()
				+ "' was parsed to SparqlQueries.",
				content instanceof SparqlQueries);
		SparqlQueries cUnit = (SparqlQueries) content;
		assertNotNull(cUnit);
		assertSuccessfulParsing(cUnit.eResource());
		return cUnit;
	}
	protected RqResource loadResourceWithoutAssert(URI uri) throws IOException {
		
		RqResource resource = tryToLoadResource(uri);
		
		if (resource.getContents().size() == 0) {
			//System.out.println("tryToLoadResource(" + uri.lastSegment() + ") Can't get any content");
			return null;
		}
		/*EObject content = resource.getContents().get(0);
		SparqlQueries cUnit = (SparqlQueries) content;
		if (cUnit == null) System.out.println("content is null");
		*/
		//print(resource.getErrors());
		//print(resource.getWarnings());
		
		return resource;
	}

	protected RqResource tryToLoadResource(URI uri) throws IOException {
		
		RqResource resource = new RqResource(uri);
		resource.load(Collections.EMPTY_MAP);
		for (Diagnostic diagnostic : resource.getErrors()) {
			System.out.println("tryToLoadResource(" + uri.lastSegment() + ") found error in resource " + diagnostic.getMessage() + "(" + diagnostic.getLine() + "," + diagnostic.getColumn() + ")");
		}
		return resource;
	}
	
	private SparqlQueries loadResource(
			String filePath) throws IOException {
		return loadResource(URI.createFileURI(filePath));
	}
	
	
	protected SparqlQueries parseResource(String filename,
			String inputFolderName) throws Exception {
		return parseResource(new File(filename), inputFolderName);
	}

	protected SparqlQueries parseResource(File inputFile,
			String inputFolder) throws IOException {
		File file = new File(inputFolder, inputFile.getPath());
		assertTrue("File " + file + " should exist.", file.exists());

		return loadResource(file.getCanonicalPath());
	}
	
	public RqResource load(File cFile) throws IOException {
		return load(new FileInputStream(cFile));
	}
	
	public RqResource load(InputStream inputStream) throws IOException {
		Map<?, ?> options = Collections.EMPTY_MAP;
		RqResource resource = new RqResource();
		resource.load(inputStream, options);
		inputStream.close();
		return resource;
	}
	
	protected void assertType(EObject object, java.lang.Class<?> expectedType) {
		assertTrue("The object should be not empty", object!=null);
		assertTrue("The object should have type '"
				+ expectedType.getSimpleName() + "', but was "
				+ object.getClass().getSimpleName(), expectedType
				.isInstance(object));
	}
	
	protected SparqlQueries assertParsesToSparqlQueries(
			String typename)throws Exception {
		return parsesToSparqlQueries(typename+getFileExtension(), getTestInputFolder());
	}
	protected SparqlQueries parsesToSparqlQueries(
			String filename, String inputFolder)throws Exception {
		EObject model = parseResource(filename, inputFolder);
		
		assertType(model, SparqlQueries.class);
		if (model instanceof SparqlQueries) {
			return (SparqlQueries)model;
		}
		else {
			return null;
		}
		
	}
	/*
	//parses the CompilationUnit with one Namespace to one Class
	protected org.emftext.language.c_sharp.classes.Class assertParseToClass(
			String typename,
			String expectedClassName) throws Exception {
		SparqlQueries cUnit = assertParsesToCompilationUnit(typename);
		List<NamespaceMemberDeclaration> nmd = cUnit.getNamespaceMemberDeclaration();
		assertMemberCount(nmd.get(0), 1);
		return (Class)((Namespace)nmd.get(0)).getNamespaceBody().getNamespaceMemberDeclaration().get(0);
	}
	
	//iterate through the Object-Tree until the first hit(type) is found
	protected EObject isSpecialTypeOrIterate(java.lang.Class<?> type, EObject eObj){
		if(type.isInstance(eObj)) return eObj;
		
		for(EObject eObjLeaf: eObj.eContents()){
			EObject result = isSpecialTypeOrIterate(type, eObjLeaf);
			if(type.isInstance(result)) return result;
		}
		return null;
	}
	*/
	
	/*
	//Funktion die, je nach Klassenart, die beinhaltenden Member zählen soll
	protected void assertMemberCount(
			EObject classtyp,
			int expectedCount) {
		String name = classtyp.toString();
		if (classtyp instanceof NamedElement) {
			name = ((NamedElement) classtyp).getName();
		}
		int count = -1;
		
		if (classtyp instanceof CompilationUnit) {
			count = 0;
			count += ((CompilationUnit)classtyp).getUsingDirectives().size();
			count += ((CompilationUnit)classtyp).getNamespaceMemberDeclaration().size();			
		}
		if (classtyp instanceof Namespace) {
			name = namespaceOrTypeNameToString(((Namespace) classtyp).getNamespaceName());
			count = 0;
			count += ((Namespace)classtyp).getNamespaceBody().getNamespaceMemberDeclaration().size();
			count += ((Namespace)classtyp).getNamespaceBody().getUsingDirectives().size();
		}
		if (classtyp instanceof Class) {
			count = 0;
			count += ((Class)classtyp).getClassMemberDeclarations().size();			
		}
		
		assertEquals(name + " should have " + expectedCount
				+ " member(s).", expectedCount, count);
	}
	
	//setzt die Teile der Identifier zu einem vollständigen String zusammen
	protected String namespaceOrTypeNameToString(
			NamespaceOrTypeName identifier){
		String puffer = "";
		for(Identifier part: identifier.getParts()){
			puffer += part.getName().toString() +".";
		}
		return puffer.substring( 0, puffer.length()-1);
	}
	
	protected void assertIdentifierName(
			NamespaceOrTypeName identifier,
			String expectedName) {
		assertEquals(expectedName, namespaceOrTypeNameToString(identifier));	
	}
	*/
}
