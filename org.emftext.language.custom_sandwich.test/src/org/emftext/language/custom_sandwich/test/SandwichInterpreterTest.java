package org.emftext.language.custom_sandwich.test;

import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.template_concepts.interpreter.test.AbstractInterpreterTest;

public class SandwichInterpreterTest extends AbstractInterpreterTest {

	public void testSandwichInterpretation() {
		// basic test (input model is not used)
		testInterpretation("template1.custom_sandwich", "customer1.customer", "RECIPE bread butter");
		// basic test for FOREACH loop and placeholder inside of the loop
		testInterpretation("template2.custom_sandwich", "customer2.customer", "RECIPE bread i1 i2 i3 TOAST bread");
		// test loop variable
		testInterpretation("template3.custom_sandwich", "customer3.customer", "RECIPE bread i1 i2 i3 TOAST bread");
	}

	protected void registerResourceFactories() {
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

	@Override
	protected String getInputFolder() {
		return "input";
	}
}
