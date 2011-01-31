/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class BibKeyword extends org.emftext.language.bibtex.resource.bib.grammar.BibSyntaxElement {
	
	private final String value;
	
	public BibKeyword(String value, org.emftext.language.bibtex.resource.bib.grammar.BibCardinality cardinality) {
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
