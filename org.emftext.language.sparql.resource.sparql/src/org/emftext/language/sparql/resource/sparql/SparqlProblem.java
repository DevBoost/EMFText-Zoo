package org.emftext.language.sparql.resource.sparql;

public class SparqlProblem extends org.emftext.runtime.resource.impl.AbstractProblem {
	
	private java.lang.String message;
	private org.emftext.runtime.resource.EProblemType type;
	
	public SparqlProblem(java.lang.String message, org.emftext.runtime.resource.EProblemType type) {
		super();
		this.message = message;
		this.type = type;
	}
	
	public org.emftext.runtime.resource.EProblemType getType() {
		return type;
	}
	
	public java.lang.String getMessage() {
		return message;
	}
	
}
