/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.mopp;

public class NotesParseResult implements org.emftext.language.notes.resource.notes.INotesParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<org.emftext.language.notes.resource.notes.INotesCommand<org.emftext.language.notes.resource.notes.INotesTextResource>> commands = new java.util.ArrayList<org.emftext.language.notes.resource.notes.INotesCommand<org.emftext.language.notes.resource.notes.INotesTextResource>>();
	
	public NotesParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<org.emftext.language.notes.resource.notes.INotesCommand<org.emftext.language.notes.resource.notes.INotesTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
