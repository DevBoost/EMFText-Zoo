/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.mopp;

public class NotesReferenceResolverSwitch implements org.emftext.language.notes.resource.notes.INotesReferenceResolverSwitch {
	
	protected org.emftext.language.notes.resource.notes.analysis.SectionSuperSectionReferenceResolver sectionSuperSectionReferenceResolver = new org.emftext.language.notes.resource.notes.analysis.SectionSuperSectionReferenceResolver();
	
	public org.emftext.language.notes.resource.notes.analysis.SectionSuperSectionReferenceResolver getSectionSuperSectionReferenceResolver() {
		return sectionSuperSectionReferenceResolver;
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		sectionSuperSectionReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, org.emftext.language.notes.resource.notes.INotesReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (org.emftext.language.notes.NotesPackage.eINSTANCE.getSection().isInstance(container)) {
			NotesFuzzyResolveResult<org.emftext.language.notes.Section> frr = new NotesFuzzyResolveResult<org.emftext.language.notes.Section>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("superSection")) {
				sectionSuperSectionReferenceResolver.resolve(identifier, (org.emftext.language.notes.Section) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public org.emftext.language.notes.resource.notes.INotesReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == org.emftext.language.notes.NotesPackage.eINSTANCE.getSection_SuperSection()) {
			return sectionSuperSectionReferenceResolver;
		}
		return null;
	}
	
}
