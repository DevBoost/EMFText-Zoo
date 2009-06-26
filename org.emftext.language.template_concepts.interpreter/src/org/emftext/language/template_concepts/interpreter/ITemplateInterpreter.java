package org.emftext.language.template_concepts.interpreter;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.template_concepts.Template;
import org.emftext.runtime.resource.IProblem;

public interface ITemplateInterpreter {

	public EObject interprete(Template template, EObject paramModel, Collection<IProblem> problems);
}
