/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class BibExpectedCsString extends org.emftext.language.bibtex.resource.bib.mopp.BibAbstractExpectedElement {
	
	private org.emftext.language.bibtex.resource.bib.grammar.BibKeyword keyword;
	
	public BibExpectedCsString(org.emftext.language.bibtex.resource.bib.grammar.BibKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof BibExpectedCsString) {
			return getValue().equals(((BibExpectedCsString) o).getValue());
		}
		return false;
	}
	
}
