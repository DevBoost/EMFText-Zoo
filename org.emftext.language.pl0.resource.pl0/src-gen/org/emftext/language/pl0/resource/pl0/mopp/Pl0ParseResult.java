/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0.mopp;

public class Pl0ParseResult implements org.emftext.language.pl0.resource.pl0.IPl0ParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<org.emftext.language.pl0.resource.pl0.IPl0Command<org.emftext.language.pl0.resource.pl0.IPl0TextResource>> commands = new java.util.ArrayList<org.emftext.language.pl0.resource.pl0.IPl0Command<org.emftext.language.pl0.resource.pl0.IPl0TextResource>>();
	
	public Pl0ParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<org.emftext.language.pl0.resource.pl0.IPl0Command<org.emftext.language.pl0.resource.pl0.IPl0TextResource>> getPostParseCommands() {
		return commands;
	}
	
}
