/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.grammar;

public class NotesSequence extends org.emftext.language.notes.resource.notes.grammar.NotesSyntaxElement {
	
	public NotesSequence(org.emftext.language.notes.resource.notes.grammar.NotesCardinality cardinality, org.emftext.language.notes.resource.notes.grammar.NotesSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return org.emftext.language.notes.resource.notes.util.NotesStringUtil.explode(getChildren(), " ");
	}
	
}
