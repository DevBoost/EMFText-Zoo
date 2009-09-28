package org.emftext.language.owl.test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.owl.resource.owl.mopp.OwlTextResourcePluginMetaInformation;

public class ParseOWLTest extends TestCase {

	public void setUp() {
		registerResourceFactories();
	}
	
	public void testRegularExpressions() {
		// TODO enable this test
		//Matcher matcher = OwlScannerlessParser.TOKEN_IRI.matcher("Class:");
		//assertFalse(matcher.matches());
	}
	
	public void testSimpleOntologyParsing() {
		//parseString("Ontology:");
		//parseString("Ontology: Class: A");
		parseString("Ontology: Class: A SubClassOf: id min 1 and id max 1");
		//parseString("Ontology: Class: A SubClassOf: id min 1 and id max 1 Class: B");
	}

	public void temtExampleOntologies() {
		File modelDir = new File(".." + File.separator + "org.emftext.language.owl" + File.separator + "models");
		assertTrue(modelDir.exists());
		File[] exampleFiles = modelDir.listFiles(new FileFilter() {
			public boolean accept(File file) {
				String filename = file.getName();
				boolean isOwlFile = filename.endsWith("." + new OwlTextResourcePluginMetaInformation().getSyntaxName());
				return isOwlFile && 
					!"ill.owl".equals(filename) &&
					!"large_galen.owl".equals(filename);
			}
		});
		for (File exampleFile : exampleFiles) {
			System.out.println("Parsing " + exampleFile.getName());
			try {
				parse(new FileInputStream(exampleFile));
			} catch (FileNotFoundException e) {
				fail(e.getMessage());
			}
		}
	}

	private void parseString(String document) {
		System.out.println("Parsing \"" + document + "\"");
		InputStream inputStream = new ByteArrayInputStream(document.getBytes());
		parse(inputStream);
	}

	private void parse(InputStream inputString) {
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createURI("temp.owl"));
		assertNotNull(r);
		try {
			r.load(inputString, null);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		List<Diagnostic> errors = r.getErrors();
		for (Diagnostic error : errors) {
			System.out.println("Error " + error.getMessage() + " at " + error.getLine() + "," + error.getColumn());
		}
		List<EObject> contents = r.getContents();
		assertTrue(contents.size() > 0);
	}

	private void registerResourceFactories() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"owl",
				new org.emftext.language.owl.resource.owl.mopp.OwlResourceFactory());
	}
}
