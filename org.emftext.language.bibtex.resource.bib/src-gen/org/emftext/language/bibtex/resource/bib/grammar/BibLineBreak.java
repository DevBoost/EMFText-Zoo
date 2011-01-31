/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.grammar;

public class BibLineBreak extends org.emftext.language.bibtex.resource.bib.grammar.BibFormattingElement {
	
	private final int tabs;
	
	public BibLineBreak(org.emftext.language.bibtex.resource.bib.grammar.BibCardinality cardinality, int tabs) {
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
