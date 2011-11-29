/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes;

public interface INotesProblem {
	public String getMessage();
	public org.emftext.language.notes.resource.notes.NotesEProblemSeverity getSeverity();
	public org.emftext.language.notes.resource.notes.NotesEProblemType getType();
	public java.util.Collection<org.emftext.language.notes.resource.notes.INotesQuickFix> getQuickFixes();
}
