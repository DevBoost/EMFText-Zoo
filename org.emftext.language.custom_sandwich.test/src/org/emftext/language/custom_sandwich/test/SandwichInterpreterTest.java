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
package org.emftext.language.custom_sandwich.test;

import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.custom_sandwich.resource.custom_sandwich.mopp.Custom_sandwichResourceFactory;
import org.emftext.language.customer.resource.customer.mopp.CustomerResourceFactory;
import org.emftext.language.sandwich.resource.sandwich.mopp.SandwichResourceFactory;
import org.emftext.language.template_concepts.interpreter.test.AbstractInterpreterTest;

public class SandwichInterpreterTest extends AbstractInterpreterTest {

	public void testSandwichInterpretation() {
		// basic test (input model is not used)
		testInterpretation("template1.custom_sandwich", "customer1.customer", "RECIPE myRecipe bread butter");
		// basic test for FOREACH loop and placeholder inside of the loop
		testInterpretation("template2.custom_sandwich", "customer2.customer", "RECIPE myRecipe bread i1 i2 i3 TOAST bread");
		// test loop variable
		testInterpretation("template3.custom_sandwich", "customer3.customer", "RECIPE myRecipe bread i1 i2 i3 TOAST bread");
	}

	protected void registerResourceFactories() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"sandwich",
				new SandwichResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"custom_sandwich",
				new Custom_sandwichResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"customer",
				new CustomerResourceFactory());
	}

	@Override
	protected String getInputFolder() {
		return "input";
	}

	@Override
	protected String getOutputFileExtension() {
		return "sandwich";
	}
}
