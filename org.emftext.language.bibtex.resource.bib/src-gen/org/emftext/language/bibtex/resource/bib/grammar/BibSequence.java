/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.grammar;

public class BibSequence extends org.emftext.language.bibtex.resource.bib.grammar.BibSyntaxElement {
	
	public BibSequence(org.emftext.language.bibtex.resource.bib.grammar.BibCardinality cardinality, org.emftext.language.bibtex.resource.bib.grammar.BibSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return org.emftext.language.bibtex.resource.bib.util.BibStringUtil.explode(getChildren(), " ");
	}
	
}
