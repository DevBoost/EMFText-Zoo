/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class NotesAbstractExpectedElement implements org.emftext.language.notes.resource.notes.INotesExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<org.emftext.language.notes.resource.notes.util.NotesPair<org.emftext.language.notes.resource.notes.INotesExpectedElement, org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[]>> followers = new java.util.LinkedHashSet<org.emftext.language.notes.resource.notes.util.NotesPair<org.emftext.language.notes.resource.notes.INotesExpectedElement, org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[]>>();
	
	public NotesAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(org.emftext.language.notes.resource.notes.INotesExpectedElement follower, org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[] path) {
		followers.add(new org.emftext.language.notes.resource.notes.util.NotesPair<org.emftext.language.notes.resource.notes.INotesExpectedElement, org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<org.emftext.language.notes.resource.notes.util.NotesPair<org.emftext.language.notes.resource.notes.INotesExpectedElement, org.emftext.language.notes.resource.notes.mopp.NotesContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
