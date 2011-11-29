/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class NotesKeyword extends org.emftext.language.notes.resource.notes.grammar.NotesSyntaxElement {
	
	private final String value;
	
	public NotesKeyword(String value, org.emftext.language.notes.resource.notes.grammar.NotesCardinality cardinality) {
		super(cardinality, null);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
}
