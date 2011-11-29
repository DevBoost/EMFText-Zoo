/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.grammar;

public class NotesLineBreak extends org.emftext.language.notes.resource.notes.grammar.NotesFormattingElement {
	
	private final int tabs;
	
	public NotesLineBreak(org.emftext.language.notes.resource.notes.grammar.NotesCardinality cardinality, int tabs) {
		super(cardinality);
		this.tabs = tabs;
	}
	
	public int getTabs() {
		return tabs;
	}
	
	public String toString() {
		return "!" + getTabs();
	}
	
}
