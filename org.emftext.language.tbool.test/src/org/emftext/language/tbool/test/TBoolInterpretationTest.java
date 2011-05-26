/*******************************************************************************
 * Copyright (c) 2006-2011
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
package org.emftext.language.tbool.test;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.emftext.language.bool.resource.bool.mopp.BoolResourceFactory;
import org.emftext.language.tbool.resource.tbool.mopp.TboolResourceFactory;
import org.emftext.language.templateconcepts.interpreter.test.AbstractInterpreterTest;

public class TBoolInterpretationTest extends AbstractInterpreterTest {

	public void testInterpretation() {
		testInterpretation("test1.tbool", "test1a.ecore", "public class MyClass { private MyClass staticAttribute ; }");
		testInterpretation("test1.tbool", "test1b.ecore", "public class MyClass { private MyClass staticAttribute ; private MyClass generatedAttribute ; }");
	}

	protected void registerResourceFactories() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"bool",
				new BoolResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"tbool",
				new TboolResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore",
				new EcoreResourceFactoryImpl());
	}

	@Override
	protected String getInputFolder() {
		return "input";
	}

	@Override
	protected String getOutputFileExtension() {
		return "bool";
	}
}
