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

public class InterpreterTest extends TestCase {
	
	public final static String INPUT_FOLDER = "input";
	
	public void setUp() {
		registerResourceFactories();
	}

	public void testSandwichInterpretation() {
		testInterpretation("template1.custom_sandwich", "customer1.customer", "RECIPE bread butter");
		testInterpretation("template2.custom_sandwich", "customer2.customer", "RECIPE bread i1 i2 i3 TOAST bread");
	}

	private void testInterpretation(String templateFileName, String customerFileName, String expectedResult) {
		try {
			ResourceSetImpl resourceSet = new ResourceSetImpl();
	
			Resource customerResource = resourceSet.createResource(URI.createFileURI(INPUT_FOLDER + File.separator + customerFileName));
			customerResource.load(null);
			Customer customer = (Customer) customerResource.getContents().get(0);
			
			Resource templateResource = resourceSet.createResource(URI.createFileURI(INPUT_FOLDER + File.separator + templateFileName));
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
			Resource instance = resourceSet.createResource(URI.createURI("output.sandwich"));
			instance.getContents().add(templateInstanceAST);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			instance.save(outputStream, null);
			
			String result = new String(outputStream.toByteArray());
			result = result.replace("\n", "");
			result = result.replace("\r", "");
			result = result.replace("  ", " ");
			result = result.trim();
			assertEquals(expectedResult, result);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	private void registerResourceFactories() {
		/*
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore",
				new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi",
				new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
				*/
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"sandwich",
				new org.emftext.language.sandwich.resource.sandwich.SandwichResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"custom_sandwich",
				new org.emftext.language.custom_sandwich.resource.custom_sandwich.Custom_sandwichResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"customer",
				new org.emftext.language.customer.resource.customer.CustomerResourceFactory());
	}
}
