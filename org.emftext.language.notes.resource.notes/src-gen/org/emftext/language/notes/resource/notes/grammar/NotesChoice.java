/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.grammar;

public class NotesChoice extends org.emftext.language.notes.resource.notes.grammar.NotesSyntaxElement {
	
	public NotesChoice(org.emftext.language.notes.resource.notes.grammar.NotesCardinality cardinality, org.emftext.language.notes.resource.notes.grammar.NotesSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return org.emftext.language.notes.resource.notes.util.NotesStringUtil.explode(getChildren(), "|");
	}
	
}
