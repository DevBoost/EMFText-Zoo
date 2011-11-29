/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class NotesSyntaxElement {
	
	private NotesSyntaxElement[] children;
	private NotesSyntaxElement parent;
	private org.emftext.language.notes.resource.notes.grammar.NotesCardinality cardinality;
	
	public NotesSyntaxElement(org.emftext.language.notes.resource.notes.grammar.NotesCardinality cardinality, NotesSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (NotesSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	public void setParent(NotesSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	public NotesSyntaxElement[] getChildren() {
		if (children == null) {
			return new NotesSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public org.emftext.language.notes.resource.notes.grammar.NotesCardinality getCardinality() {
		return cardinality;
	}
	
}
