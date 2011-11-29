/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.grammar;

public class NotesContainment extends org.emftext.language.notes.resource.notes.grammar.NotesTerminal {
	
	private final org.eclipse.emf.ecore.EClass[] allowedTypes;
	
	public NotesContainment(org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.notes.resource.notes.grammar.NotesCardinality cardinality, org.eclipse.emf.ecore.EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public org.eclipse.emf.ecore.EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = org.emftext.language.notes.resource.notes.util.NotesStringUtil.explode(allowedTypes, ", ", new org.emftext.language.notes.resource.notes.INotesFunction1<String, org.eclipse.emf.ecore.EClass>() {
				public String execute(org.eclipse.emf.ecore.EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
