package org.emftext.language.template_concepts.interpreter;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.emftext.language.template_concepts.Template;

public interface ITemplateInterpreter {

	public EObject interprete(Template template, EObject paramModel, Collection<Diagnostic> problems);
}
