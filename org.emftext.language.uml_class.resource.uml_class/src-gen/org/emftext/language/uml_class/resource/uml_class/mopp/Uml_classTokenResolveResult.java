package org.emftext.language.uml_class.resource.uml_class.mopp;

// A basic implementation of the ITokenResolveResult interface.
//
public class Uml_classTokenResolveResult implements org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolveResult {
	
	private String errorMessage;
	private Object resolvedToken;
	
	public Uml_classTokenResolveResult() {
		super();
		clear();
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public Object getResolvedToken() {
		return resolvedToken;
	}
	
	public void setErrorMessage(String message) {
		errorMessage = message;
	}
	
	public void setResolvedToken(Object resolvedToken) {
		this.resolvedToken = resolvedToken;
	}
	
	public void clear() {
		errorMessage = "Can't resolve token.";
		resolvedToken = null;
	}
}
