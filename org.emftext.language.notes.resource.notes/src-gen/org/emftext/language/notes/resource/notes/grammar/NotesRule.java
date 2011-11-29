/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class NotesRule extends org.emftext.language.notes.resource.notes.grammar.NotesSyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public NotesRule(org.eclipse.emf.ecore.EClass metaclass, org.emftext.language.notes.resource.notes.grammar.NotesChoice choice, org.emftext.language.notes.resource.notes.grammar.NotesCardinality cardinality) {
		super(cardinality, new org.emftext.language.notes.resource.notes.grammar.NotesSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public org.emftext.language.notes.resource.notes.grammar.NotesChoice getDefinition() {
		return (org.emftext.language.notes.resource.notes.grammar.NotesChoice) getChildren()[0];
	}
	
}

