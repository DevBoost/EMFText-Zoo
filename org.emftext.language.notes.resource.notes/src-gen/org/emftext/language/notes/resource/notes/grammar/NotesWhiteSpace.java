/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.grammar;

public class NotesWhiteSpace extends org.emftext.language.notes.resource.notes.grammar.NotesFormattingElement {
	
	private final int amount;
	
	public NotesWhiteSpace(int amount, org.emftext.language.notes.resource.notes.grammar.NotesCardinality cardinality) {
		super(cardinality);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String toString() {
		return "#" + getAmount();
	}
	
}
