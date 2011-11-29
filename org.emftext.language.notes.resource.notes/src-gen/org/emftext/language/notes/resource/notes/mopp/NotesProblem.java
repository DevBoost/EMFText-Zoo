/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.mopp;

public class NotesProblem implements org.emftext.language.notes.resource.notes.INotesProblem {
	
	private String message;
	private org.emftext.language.notes.resource.notes.NotesEProblemType type;
	private org.emftext.language.notes.resource.notes.NotesEProblemSeverity severity;
	private java.util.Collection<org.emftext.language.notes.resource.notes.INotesQuickFix> quickFixes;
	
	public NotesProblem(String message, org.emftext.language.notes.resource.notes.NotesEProblemType type, org.emftext.language.notes.resource.notes.NotesEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<org.emftext.language.notes.resource.notes.INotesQuickFix>emptySet());
	}
	
	public NotesProblem(String message, org.emftext.language.notes.resource.notes.NotesEProblemType type, org.emftext.language.notes.resource.notes.NotesEProblemSeverity severity, org.emftext.language.notes.resource.notes.INotesQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public NotesProblem(String message, org.emftext.language.notes.resource.notes.NotesEProblemType type, org.emftext.language.notes.resource.notes.NotesEProblemSeverity severity, java.util.Collection<org.emftext.language.notes.resource.notes.INotesQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<org.emftext.language.notes.resource.notes.INotesQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public org.emftext.language.notes.resource.notes.NotesEProblemType getType() {
		return type;
	}
	
	public org.emftext.language.notes.resource.notes.NotesEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<org.emftext.language.notes.resource.notes.INotesQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
