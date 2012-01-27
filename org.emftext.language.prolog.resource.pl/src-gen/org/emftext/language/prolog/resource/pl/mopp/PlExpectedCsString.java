/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class PlExpectedCsString extends org.emftext.language.prolog.resource.pl.mopp.PlAbstractExpectedElement {
	
	private org.emftext.language.prolog.resource.pl.grammar.PlKeyword keyword;
	
	public PlExpectedCsString(org.emftext.language.prolog.resource.pl.grammar.PlKeyword keyword) {
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
		if (o instanceof PlExpectedCsString) {
			return getValue().equals(((PlExpectedCsString) o).getValue());
		}
		return false;
	}
	
}
