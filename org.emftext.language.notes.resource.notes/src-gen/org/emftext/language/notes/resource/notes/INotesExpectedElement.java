/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface INotesExpectedElement {
	
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
	public void addFollower(org.emftext.language.notes.resource.notes.INotesExpectedElement follower, org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public java.util.Collection<org.emftext.language.notes.resource.notes.util.NotesPair<org.emftext.language.notes.resource.notes.INotesExpectedElement, org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[]>> getFollowers();
	
}
