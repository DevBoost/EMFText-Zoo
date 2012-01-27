/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.grammar;

public class PlLineBreak extends org.emftext.language.prolog.resource.pl.grammar.PlFormattingElement {
	
	private final int tabs;
	
	public PlLineBreak(org.emftext.language.prolog.resource.pl.grammar.PlCardinality cardinality, int tabs) {
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
