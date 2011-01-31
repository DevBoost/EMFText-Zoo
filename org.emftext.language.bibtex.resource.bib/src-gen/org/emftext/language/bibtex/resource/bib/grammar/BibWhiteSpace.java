/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.grammar;

public class BibWhiteSpace extends org.emftext.language.bibtex.resource.bib.grammar.BibFormattingElement {
	
	private final int amount;
	
	public BibWhiteSpace(int amount, org.emftext.language.bibtex.resource.bib.grammar.BibCardinality cardinality) {
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
