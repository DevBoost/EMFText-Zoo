package org.emftext.language.tbool.test;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.emftext.language.template_concepts.interpreter.test.AbstractInterpreterTest;

public class TBoolInterpretationTest extends AbstractInterpreterTest {

	public void testInterpretation() {
		testInterpretation("test1.tbool", "test1a.ecore", "public class MyClass { private MyClass attribute ; }");
		testInterpretation("test1.tbool", "test1b.ecore", "public class MyClass { private MyClass attribute ; }");
	}

	protected void registerResourceFactories() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"bool",
				new org.emftext.language.bool.resource.bool.BoolResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"tbool",
				new org.emftext.language.tbool.resource.tbool.TboolResourceFactory());
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
