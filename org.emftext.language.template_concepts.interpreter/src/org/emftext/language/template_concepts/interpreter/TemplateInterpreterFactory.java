package org.emftext.language.template_concepts.interpreter;

import org.emftext.language.template_concepts.interpreter.impl.Interpreter;

public class TemplateInterpreterFactory {

	public static ITemplateInterpreter createTemplateInterpreter() {
		return new Interpreter();
	}
}
