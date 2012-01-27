/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class PlAbstractExpectedElement implements org.emftext.language.prolog.resource.pl.IPlExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<org.emftext.language.prolog.resource.pl.util.PlPair<org.emftext.language.prolog.resource.pl.IPlExpectedElement, org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[]>> followers = new java.util.LinkedHashSet<org.emftext.language.prolog.resource.pl.util.PlPair<org.emftext.language.prolog.resource.pl.IPlExpectedElement, org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[]>>();
	
	public PlAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(org.emftext.language.prolog.resource.pl.IPlExpectedElement follower, org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] path) {
		followers.add(new org.emftext.language.prolog.resource.pl.util.PlPair<org.emftext.language.prolog.resource.pl.IPlExpectedElement, org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<org.emftext.language.prolog.resource.pl.util.PlPair<org.emftext.language.prolog.resource.pl.IPlExpectedElement, org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
