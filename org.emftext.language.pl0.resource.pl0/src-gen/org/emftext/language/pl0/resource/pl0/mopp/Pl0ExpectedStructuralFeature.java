/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0.mopp;

// A representation for a range in a document where a structural feature (e.g.,
// a reference) is expected.
public class Pl0ExpectedStructuralFeature extends org.emftext.language.pl0.resource.pl0.mopp.Pl0AbstractExpectedElement {
	private org.eclipse.emf.ecore.EStructuralFeature feature;
	private String tokenName;
	
	public Pl0ExpectedStructuralFeature(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName) {
		super();
		this.feature = feature;
		this.tokenName = tokenName;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return feature;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
	public java.lang.String toString() {
		return "EFeature " + feature.getEContainingClass().getName() + "." + feature.getName();
	}
	
	public boolean equals(java.lang.Object o) {
		if (o instanceof Pl0ExpectedStructuralFeature) {
			return this.feature.equals(((Pl0ExpectedStructuralFeature) o).feature);
		}
		return false;
	}
}
