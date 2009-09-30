package org.emftext.language.uml_class.resource.uml_class.mopp;

public class Uml_classProblem implements org.emftext.language.uml_class.resource.uml_class.IUml_classProblem {
	
	private java.lang.String message;
	private org.emftext.language.uml_class.resource.uml_class.Uml_classEProblemType type;
	
	public Uml_classProblem(java.lang.String message, org.emftext.language.uml_class.resource.uml_class.Uml_classEProblemType type) {
		super();
		this.message = message;
		this.type = type;
	}
	
	public org.emftext.language.uml_class.resource.uml_class.Uml_classEProblemType getType() {
		return type;
	}
	
	public java.lang.String getMessage() {
		return message;
	}
	
}
