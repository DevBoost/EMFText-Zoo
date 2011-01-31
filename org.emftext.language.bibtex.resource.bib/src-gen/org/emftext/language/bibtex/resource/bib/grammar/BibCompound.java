/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.grammar;

public class BibCompound extends org.emftext.language.bibtex.resource.bib.grammar.BibSyntaxElement {
	
	public BibCompound(org.emftext.language.bibtex.resource.bib.grammar.BibChoice choice, org.emftext.language.bibtex.resource.bib.grammar.BibCardinality cardinality) {
		super(cardinality, new org.emftext.language.bibtex.resource.bib.grammar.BibSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
