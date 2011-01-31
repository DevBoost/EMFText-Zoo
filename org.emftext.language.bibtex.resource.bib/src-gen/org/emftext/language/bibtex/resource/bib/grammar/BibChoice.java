/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.grammar;

public class BibChoice extends org.emftext.language.bibtex.resource.bib.grammar.BibSyntaxElement {
	
	public BibChoice(org.emftext.language.bibtex.resource.bib.grammar.BibCardinality cardinality, org.emftext.language.bibtex.resource.bib.grammar.BibSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return org.emftext.language.bibtex.resource.bib.util.BibStringUtil.explode(getChildren(), "|");
	}
	
}
