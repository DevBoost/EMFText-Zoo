/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0.mopp;

public class Pl0Problem implements org.emftext.language.pl0.resource.pl0.IPl0Problem {
	
	private java.lang.String message;
	private org.emftext.language.pl0.resource.pl0.Pl0EProblemType type;
	
	public Pl0Problem(java.lang.String message, org.emftext.language.pl0.resource.pl0.Pl0EProblemType type) {
		super();
		this.message = message;
		this.type = type;
	}
	
	public org.emftext.language.pl0.resource.pl0.Pl0EProblemType getType() {
		return type;
	}
	
	public java.lang.String getMessage() {
		return message;
	}
	
}
