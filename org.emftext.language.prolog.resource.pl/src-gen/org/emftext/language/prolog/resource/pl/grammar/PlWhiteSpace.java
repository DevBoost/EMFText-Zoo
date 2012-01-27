/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.grammar;

public class PlWhiteSpace extends org.emftext.language.prolog.resource.pl.grammar.PlFormattingElement {
	
	private final int amount;
	
	public PlWhiteSpace(int amount, org.emftext.language.prolog.resource.pl.grammar.PlCardinality cardinality) {
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
