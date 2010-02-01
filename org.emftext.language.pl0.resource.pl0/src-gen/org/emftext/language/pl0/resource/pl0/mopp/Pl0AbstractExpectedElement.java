/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0.mopp;

// Abstract super class for all expected elements. Provides methods to
// add followers
public abstract class Pl0AbstractExpectedElement implements org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement {
	
	private java.util.Set<org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement> followers = new java.util.LinkedHashSet<org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement>();
	
	public Pl0AbstractExpectedElement() {
		super();
	}
	
	public void addFollower(org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement follower) {
		followers.add(follower);
	}
	
	public java.util.Collection<org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement> getFollowers() {
		return followers;
	}
	
}
