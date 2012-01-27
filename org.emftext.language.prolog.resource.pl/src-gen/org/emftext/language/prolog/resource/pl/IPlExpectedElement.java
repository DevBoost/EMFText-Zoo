/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface IPlExpectedElement {
	
	/**
	 * Returns the names of all tokens that are expected at the given position.
	 */
	public java.util.Set<String> getTokenNames();
	
	/**
	 * Returns the metaclass of the rule that contains the expected element.
	 */
	public org.eclipse.emf.ecore.EClass getRuleMetaclass();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(org.emftext.language.prolog.resource.pl.IPlExpectedElement follower, org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public java.util.Collection<org.emftext.language.prolog.resource.pl.util.PlPair<org.emftext.language.prolog.resource.pl.IPlExpectedElement, org.emftext.language.prolog.resource.pl.mopp.PlContainedFeature[]>> getFollowers();
	
}
