/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes;

/**
 * An interface used to access the result of parsing a document.
 */
public interface INotesParseResult {
	
	/**
	 * Returns the root object of the document.
	 */
	public org.eclipse.emf.ecore.EObject getRoot();
	
	/**
	 * Returns a list of commands that must be executed after parsing the document.
	 */
	public java.util.Collection<org.emftext.language.notes.resource.notes.INotesCommand<org.emftext.language.notes.resource.notes.INotesTextResource>> getPostParseCommands();
	
}
