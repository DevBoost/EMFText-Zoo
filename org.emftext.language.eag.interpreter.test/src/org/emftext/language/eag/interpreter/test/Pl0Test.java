package org.emftext.language.eag.interpreter.test;

import java.io.File;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.eag.AttributeGrammar;
import org.emftext.language.pl0.Program;
import org.emftext.language.pl0.attributes.AttributesFactory;
import org.emftext.language.pl0.attributes.StringSet;
import org.emftext.language.pl0.resource.pl0.mopp.Pl0MetaInformation;
import org.emftext.language.pl0.resource.pl0.mopp.Pl0ResourceFactory;
import org.junit.Before;

public class Pl0Test extends AbstractInterpreterTest {

	private static final String PL0_FILE_EXTENSION = new Pl0MetaInformation().getSyntaxName();

	@Before
	public void setUp() throws Exception {
		super.setUp();
		// register resource factories
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				PL0_FILE_EXTENSION,
				new Pl0ResourceFactory());
	}

	public void testPl0() {
		testInterpretation("x", "squ");
	}
	
	private void testInterpretation(String... expected) {
		EObject root = loadProgram("input" + File.separator + "pl0" + File.separator + "program1.pl0");
		AttributeGrammar grammar = loadGrammar("input" + File.separator + "pl0.eag");
		String attribute = "DeclaredVariables";
		Object result = interpret(root, grammar, attribute);
		assertTrue(result instanceof StringSet);
		StringSet set = (StringSet) result;
		EList<String> contents = set.getContents();
		assertEquals(expected.length, contents.size());
		for (String next : expected) {
			assertTrue(contents.contains(next));
		}
	}

	public Program loadProgram(String filename) {
		EObject rootObject = load(filename);
		assertTrue(rootObject instanceof Program);
		return (Program) rootObject;
	}
}
