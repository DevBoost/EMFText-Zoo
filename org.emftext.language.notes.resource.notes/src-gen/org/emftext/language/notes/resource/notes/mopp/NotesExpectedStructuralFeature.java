/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.mopp;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class NotesExpectedStructuralFeature extends org.emftext.language.notes.resource.notes.mopp.NotesAbstractExpectedElement {
	
	private org.emftext.language.notes.resource.notes.grammar.NotesPlaceholder placeholder;
	
	public NotesExpectedStructuralFeature(org.emftext.language.notes.resource.notes.grammar.NotesPlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	public String getTokenName() {
		return placeholder.getTokenName();
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton(getTokenName());
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof NotesExpectedStructuralFeature) {
			return getFeature().equals(((NotesExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
}
