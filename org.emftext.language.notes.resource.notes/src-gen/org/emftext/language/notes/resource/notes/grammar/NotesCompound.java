/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.grammar;

public class NotesCompound extends org.emftext.language.notes.resource.notes.grammar.NotesSyntaxElement {
	
	public NotesCompound(org.emftext.language.notes.resource.notes.grammar.NotesChoice choice, org.emftext.language.notes.resource.notes.grammar.NotesCardinality cardinality) {
		super(cardinality, new org.emftext.language.notes.resource.notes.grammar.NotesSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
