package org.emftext.language.java_templates.test;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.template_concepts.interpreter.test.AbstractInterpreterTest;

public class JavaTemplateInterpreterTest extends AbstractInterpreterTest {

	public void testSandwichInterpretation() {
		// basic test (input model is not used)
		testInterpretation("test1.java_template", "test1.customer", "public class T1 { }");
	}

	protected void registerResourceFactories() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"java",
				new org.emftext.language.java.resource.JavaSourceOrClassFileResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"java_template",
				new org.emftext.language.java_templates.resource.java_template.Java_templateResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"customer",
				new org.emftext.language.customer.resource.customer.CustomerResourceFactory());
	}

	@Override
	protected String getInputFolder() {
		return "input";
	}
}
