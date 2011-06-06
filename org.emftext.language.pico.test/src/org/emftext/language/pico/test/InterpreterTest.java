package org.emftext.language.pico.test;

import org.eclipse.emf.common.util.URI;
import org.emftext.language.pico.Program;
import org.emftext.language.pico.resource.pico.interpreter.PicoInterpretationContext;
import org.emftext.language.pico.resource.pico.interpreter.PicoInterpreter;
import org.emftext.language.pico.resource.pico.util.PicoResourceUtil;

import junit.framework.TestCase;

public class InterpreterTest extends TestCase {

	public void testInterpretationOfTest1() {
		PicoInterpretationContext context = interpret("test1.pico");
		assertEquals(5, context.getValue("var1"));
		assertEquals("abc", context.getValue("var2"));
	}

	public void testInterpretationOfTest2() {
		PicoInterpretationContext context = interpret("test2.pico");
		assertEquals(1, context.getValue("var1"));
	}

	public void testInterpretationOfTest3() {
		PicoInterpretationContext context = interpret("test3.pico");
		assertEquals(2, context.getValue("var1"));
	}

	public void testInterpretationOfTest4() {
		PicoInterpretationContext context = interpret("test4.pico");
		assertEquals(11, context.getValue("var1"));
	}

	public void testInterpretationOfTest5() {
		PicoInterpretationContext context = interpret("test5.pico");
		assertEquals(160, context.getValue("var1"));
	}

	private PicoInterpretationContext interpret(String fileName) {
		URI uri = URI.createFileURI("input/" + fileName);
		Program program = PicoResourceUtil.getResourceContent(uri);
		PicoInterpretationContext context = new PicoInterpretationContext();
		PicoInterpreter interpreter = new PicoInterpreter();
		interpreter.addObjectToInterprete(program);
		interpreter.interprete(context);
		return context;
	}
}
