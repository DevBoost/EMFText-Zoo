package org.emftext.language.eag.interpreter.test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.eag.AttributeGrammar;
import org.emftext.language.simplemath.resource.sm.mopp.SmMetaInformation;
import org.emftext.language.simplemath.resource.sm.mopp.SmResourceFactory;
import org.junit.Before;

public class SimpleMathTest extends AbstractInterpreterTest {

	private static final String SM_FILE_EXTENSION = new SmMetaInformation().getSyntaxName();

	@Before
	public void setUp() throws Exception {
		super.setUp();
		// register resource factories
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				SM_FILE_EXTENSION,
				new SmResourceFactory());
	}

	public void testSimpleMathAG() {
		testInterpretation("1+1", 2);
		testInterpretation("2*3", 6);
		testInterpretation("1+2*5", 11);
	}

	private void testInterpretation(String text, Object expected) {
		EObject root = loadModel(text);
		//EObject root = loadModel("1*5");
		AttributeGrammar grammar = loadGrammar("input" + File.separator + "simplemath.eag");
		String attribute = "Value";
		assertInterpretation(expected, root, grammar, attribute);
	}

	private EObject loadModel(String text) {
		Resource resource = rs.createResource(URI.createURI("test." + SM_FILE_EXTENSION));
		try {
			resource.load(new ByteArrayInputStream(text.getBytes()), null);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		return getRootObject(resource);
	}
}
