package org.emftext.language.uml_class.resource.uml_class.mopp;

public class Uml_classParseResult implements org.emftext.language.uml_class.resource.uml_class.IUml_classParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<org.emftext.language.uml_class.resource.uml_class.IUml_classCommand<org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource>> commands = new java.util.ArrayList<org.emftext.language.uml_class.resource.uml_class.IUml_classCommand<org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource>>();
	
	public Uml_classParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<org.emftext.language.uml_class.resource.uml_class.IUml_classCommand<org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
