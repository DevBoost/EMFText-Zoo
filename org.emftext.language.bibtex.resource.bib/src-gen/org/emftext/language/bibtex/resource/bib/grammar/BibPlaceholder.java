/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class BibPlaceholder extends org.emftext.language.bibtex.resource.bib.grammar.BibTerminal {
	
	private final String tokenName;
	
	public BibPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, org.emftext.language.bibtex.resource.bib.grammar.BibCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
