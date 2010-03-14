/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.language.java.templates.test;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.java_templates.resource.java_template.mopp.Java_templateResourceFactory;
import org.emftext.language.templateconcepts.interpreter.test.AbstractInterpreterTest;

public class JavaTemplateInterpreterTest extends AbstractInterpreterTest {

	public void testSandwichInterpretation() {
		// basic test (input model is not used)
		testInterpretation("test1.java_template", "test1.customer", "public class T1 { }");
		testInterpretation("test2.java_template", "test2.customer", "public class T1 { public int cheese ; public int cucumbers ; }");
	}

	protected void registerResourceFactories() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"java",
				new org.emftext.language.java.resource.JavaSourceOrClassFileResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"java_template",
				new Java_templateResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"customer",
				new org.emftext.language.customer.resource.customer.mopp.CustomerResourceFactory());
	}

	@Override
	protected String getInputFolder() {
		return "input";
	}

	@Override
	protected String getOutputFileExtension() {
		return "java";
	}
}
