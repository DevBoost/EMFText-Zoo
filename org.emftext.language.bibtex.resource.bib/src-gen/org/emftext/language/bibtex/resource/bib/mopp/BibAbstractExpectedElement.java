/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class BibAbstractExpectedElement implements org.emftext.language.bibtex.resource.bib.IBibExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	private java.util.Set<org.emftext.language.bibtex.resource.bib.util.BibPair<org.emftext.language.bibtex.resource.bib.IBibExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> followers = new java.util.LinkedHashSet<org.emftext.language.bibtex.resource.bib.util.BibPair<org.emftext.language.bibtex.resource.bib.IBibExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>>();
	
	public BibAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(org.emftext.language.bibtex.resource.bib.IBibExpectedElement follower, org.eclipse.emf.ecore.EStructuralFeature[] path) {
		followers.add(new org.emftext.language.bibtex.resource.bib.util.BibPair<org.emftext.language.bibtex.resource.bib.IBibExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>(follower, path));
	}
	
	public java.util.Collection<org.emftext.language.bibtex.resource.bib.util.BibPair<org.emftext.language.bibtex.resource.bib.IBibExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> getFollowers() {
		return followers;
	}
	
}
