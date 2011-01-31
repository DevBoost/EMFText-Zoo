/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.mopp;

public class BibParseResult implements org.emftext.language.bibtex.resource.bib.IBibParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<org.emftext.language.bibtex.resource.bib.IBibCommand<org.emftext.language.bibtex.resource.bib.IBibTextResource>> commands = new java.util.ArrayList<org.emftext.language.bibtex.resource.bib.IBibCommand<org.emftext.language.bibtex.resource.bib.IBibTextResource>>();
	
	public BibParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<org.emftext.language.bibtex.resource.bib.IBibCommand<org.emftext.language.bibtex.resource.bib.IBibTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
