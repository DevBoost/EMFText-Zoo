package org.emftext.language.uml_class.resource.uml_class.mopp;

// A representation for a range in a document where a CsString (e.g.,
// a keyword) is expected.
public class Uml_classExpectedCsString extends org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classAbstractExpectedElement {
	private String value;
	
	public Uml_classExpectedCsString(String value) {
		this("0", value);
	}
	
	public Uml_classExpectedCsString(String scopeID, String value) {
		super(scopeID, false);
		this.value = value;
	}
	
	public Uml_classExpectedCsString(String scopeID, boolean discardFollowingExpectations, String value) {
		super(scopeID, discardFollowingExpectations);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return super.toString() + " CsString \"" + value + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof Uml_classExpectedCsString) {
			return this.value.equals(((Uml_classExpectedCsString) o).value);
		}
		return false;
	}
}
