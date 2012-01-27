/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.mopp;

public class PlParseResult implements org.emftext.language.prolog.resource.pl.IPlParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<org.emftext.language.prolog.resource.pl.IPlCommand<org.emftext.language.prolog.resource.pl.IPlTextResource>> commands = new java.util.ArrayList<org.emftext.language.prolog.resource.pl.IPlCommand<org.emftext.language.prolog.resource.pl.IPlTextResource>>();
	
	public PlParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<org.emftext.language.prolog.resource.pl.IPlCommand<org.emftext.language.prolog.resource.pl.IPlTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
