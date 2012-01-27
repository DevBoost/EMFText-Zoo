/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class PlPlaceholder extends org.emftext.language.prolog.resource.pl.grammar.PlTerminal {
	
	private final String tokenName;
	
	public PlPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, org.emftext.language.prolog.resource.pl.grammar.PlCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
