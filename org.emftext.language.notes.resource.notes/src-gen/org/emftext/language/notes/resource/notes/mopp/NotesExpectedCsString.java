/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class NotesExpectedCsString extends org.emftext.language.notes.resource.notes.mopp.NotesAbstractExpectedElement {
	
	private org.emftext.language.notes.resource.notes.grammar.NotesKeyword keyword;
	
	public NotesExpectedCsString(org.emftext.language.notes.resource.notes.grammar.NotesKeyword keyword) {
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
		if (o instanceof NotesExpectedCsString) {
			return getValue().equals(((NotesExpectedCsString) o).getValue());
		}
		return false;
	}
	
}
