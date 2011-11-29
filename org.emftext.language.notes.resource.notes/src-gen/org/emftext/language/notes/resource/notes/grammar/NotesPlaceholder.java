/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class NotesPlaceholder extends org.emftext.language.notes.resource.notes.grammar.NotesTerminal {
	
	private final String tokenName;
	
	public NotesPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, org.emftext.language.notes.resource.notes.grammar.NotesCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
