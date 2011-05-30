package org.emftext.language.pico.test;

import org.eclipse.emf.common.util.URI;
import org.emftext.language.pico.Program;
import org.emftext.language.pico.resource.pico.interpreter.PicoInterpretationContext;
import org.emftext.language.pico.resource.pico.interpreter.PicoInterpreter;
import org.emftext.language.pico.resource.pico.util.PicoResourceUtil;

import junit.framework.TestCase;

public class InterpreterTest extends TestCase {

	public void testInterpretationOfTest1() {
		String fileName = "input/test1.pico";
		PicoInterpretationContext context = interpret(fileName);
		assertEquals(5, context.getValue("var1"));
		assertEquals("abc", context.getValue("var2"));
	}

	public void testInterpretationOfTest2() {
		String fileName = "input/test2.pico";
		PicoInterpretationContext context = interpret(fileName);
		assertEquals(1, context.getValue("var1"));
	}

	private PicoInterpretationContext interpret(String fileName) {
		URI uri = URI.createFileURI(fileName);
		Program program = PicoResourceUtil.getResourceContent(uri);
		PicoInterpretationContext context = new PicoInterpretationContext();
		PicoInterpreter interpreter = new PicoInterpreter();
		interpreter.addObjectToInterprete(program);
		interpreter.interprete(context);
		return context;
	}
}
