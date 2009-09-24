/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
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
		testInterpretation("template1.custom_sandwich", "customer1.customer", "RECIPE bread butter");
		// basic test for FOREACH loop and placeholder inside of the loop
		testInterpretation("template2.custom_sandwich", "customer2.customer", "RECIPE bread i1 i2 i3 TOAST bread");
		// test loop variable
		testInterpretation("template3.custom_sandwich", "customer3.customer", "RECIPE bread i1 i2 i3 TOAST bread");
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
