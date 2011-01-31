/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.grammar;

public class BibContainment extends org.emftext.language.bibtex.resource.bib.grammar.BibTerminal {
	
	public BibContainment(org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.bibtex.resource.bib.grammar.BibCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
	}
	
	public String toString() {
		return getFeature().getName();
	}
	
}
