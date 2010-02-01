/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0;

// An element that is expected at a given position in a resource
// stream.
public interface IPl0ExpectedElement {
	
	public java.lang.String getTokenName();
	public void addFollower(org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement follower);
	public java.util.Collection<org.emftext.language.pl0.resource.pl0.IPl0ExpectedElement> getFollowers();
}
