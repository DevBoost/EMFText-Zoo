package org.emftext.language.uml_class.resource.uml_class;

// An interface used to access the result of parsing a
// document.
public interface IUml_classParseResult {
	
	public org.eclipse.emf.ecore.EObject getRoot();
	
	public java.util.Collection<org.emftext.language.uml_class.resource.uml_class.IUml_classCommand<org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource>> getPostParseCommands();
}
