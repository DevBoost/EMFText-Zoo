/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.mopp;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class BibExpectedStructuralFeature extends org.emftext.language.bibtex.resource.bib.mopp.BibAbstractExpectedElement {
	
	private org.emftext.language.bibtex.resource.bib.grammar.BibPlaceholder placeholder;
	
	public BibExpectedStructuralFeature(org.emftext.language.bibtex.resource.bib.grammar.BibPlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	public String getTokenName() {
		return placeholder.getTokenName();
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton(getTokenName());
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof BibExpectedStructuralFeature) {
			return getFeature().equals(((BibExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
}
