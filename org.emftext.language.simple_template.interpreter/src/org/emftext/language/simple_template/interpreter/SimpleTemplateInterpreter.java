package org.emftext.language.simple_template.interpreter;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.simple_template.Template;

public interface SimpleTemplateInterpreter {
	public EObject interprete(Template template, EObject inputModel);
}
