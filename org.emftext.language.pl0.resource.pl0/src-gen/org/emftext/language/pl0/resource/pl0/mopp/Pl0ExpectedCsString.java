/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0.mopp;

// A representation for a range in a document where a keyword (i.e.,
// a static string) is expected.
public class Pl0ExpectedCsString extends org.emftext.language.pl0.resource.pl0.mopp.Pl0AbstractExpectedElement {
	
	private String value;
	
	public Pl0ExpectedCsString(String value) {
		super();
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String getTokenName() {
		return "'" + value + "'";
	}
	
	public String toString() {
		return "CsString \"" + value + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof Pl0ExpectedCsString) {
			return this.value.equals(((Pl0ExpectedCsString) o).value);
		}
		return false;
	}
	
}
