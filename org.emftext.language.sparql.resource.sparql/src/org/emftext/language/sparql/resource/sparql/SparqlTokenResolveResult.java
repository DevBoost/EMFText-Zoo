package org.emftext.language.sparql.resource.sparql;

// A basic implementation of the ITokenResolveResult interface.
//
public class SparqlTokenResolveResult implements org.emftext.runtime.resource.ITokenResolveResult {
	
	private String errorMessage;
	private Object resolvedToken;
	
	public SparqlTokenResolveResult() {
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
