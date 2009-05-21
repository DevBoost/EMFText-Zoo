package org.emftext.language.template_concepts.interpreter.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.customer.Customer;
import org.emftext.language.template_concepts.Template;
import org.emftext.language.template_concepts.interpreter.InterpreterWithState;
import org.emftext.language.template_concepts.interpreter.exceptions.InterpreterException;

import junit.framework.TestCase;

public abstract class AbstractInterpreterTest extends TestCase {
	
	public void setUp() {
		registerResourceFactories();
	}

	protected void testInterpretation(String templateFileName, String customerFileName, String expectedResult) {
		try {
			ResourceSetImpl resourceSet = new ResourceSetImpl();
	
			Resource customerResource = resourceSet.createResource(URI.createFileURI(getInputFolder() + File.separator + customerFileName));
			customerResource.load(null);
			Customer customer = (Customer) customerResource.getContents().get(0);
			
			Resource templateResource = resourceSet.createResource(URI.createFileURI(getInputFolder() + File.separator + templateFileName));
			templateResource.load(null);
			Template template = (Template) templateResource.getContents().get(0);
			
			InterpreterWithState interpreterWithState;
			try {
				interpreterWithState = new InterpreterWithState(template, customer);
			} catch (InterpreterException e1) {
				fail(e1.getMessage());
				return;
			}
			EObject templateInstanceAST = interpreterWithState.getTemplateInstanceRoot();
			
			// pretty print templateInstanceAST
			Resource instance = resourceSet.createResource(URI.createURI("output." + getOutputFileExtension()));
			instance.getContents().add(templateInstanceAST);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			instance.save(outputStream, null);
			
			// normalize output
			String result = new String(outputStream.toByteArray());
			result = result.replace("\n", "");
			result = result.replace("\r", "");
			result = result.replace("\t", "");
			result = result.replace("  ", " ");
			result = result.trim();
			
			// compare output with expected result
			assertEquals(expectedResult, result);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	protected abstract String getOutputFileExtension();
	protected abstract String getInputFolder();
	protected abstract void registerResourceFactories();
}
