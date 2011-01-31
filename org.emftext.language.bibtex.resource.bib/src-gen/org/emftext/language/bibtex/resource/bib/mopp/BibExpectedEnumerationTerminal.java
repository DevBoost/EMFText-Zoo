/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.mopp;

/**
 * A representation for a range in a document where an enumeration literal (i.e.,
 * a set of static strings) is expected.
 */
public class BibExpectedEnumerationTerminal extends org.emftext.language.bibtex.resource.bib.mopp.BibAbstractExpectedElement {
	
	private org.emftext.language.bibtex.resource.bib.grammar.BibEnumerationTerminal enumerationTerminal;
	
	public BibExpectedEnumerationTerminal(org.emftext.language.bibtex.resource.bib.grammar.BibEnumerationTerminal enumerationTerminal) {
		super(enumerationTerminal.getMetaclass());
		this.enumerationTerminal = enumerationTerminal;
	}
	
	public java.util.Set<String> getTokenNames() {
		// EnumerationTerminals are associated with multiple tokens, one for each literal
		// that was mapped to a string
		java.util.Set<String> tokenNames = new java.util.LinkedHashSet<String>();
		java.util.Map<String, String> mapping = enumerationTerminal.getLiteralMapping();
		for (String literalName : mapping.keySet()) {
			String text = mapping.get(literalName);
			if (text != null && !"".equals(text)) {
				tokenNames.add("'" + text + "'");
			}
		}
		return tokenNames;
	}
	
	public org.emftext.language.bibtex.resource.bib.grammar.BibEnumerationTerminal getEnumerationTerminal() {
		return this.enumerationTerminal;
	}
}
