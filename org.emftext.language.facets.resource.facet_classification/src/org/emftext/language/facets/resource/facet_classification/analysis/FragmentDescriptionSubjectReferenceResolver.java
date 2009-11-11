package org.emftext.language.facets.resource.facet_classification.analysis;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

public class FragmentDescriptionSubjectReferenceResolver implements org.emftext.language.facets.resource.facet_classification.IFacet_classificationReferenceResolver<org.emftext.language.description.FragmentDescription, org.eclipse.emf.ecore.EObject> {
	
	private org.emftext.language.facets.resource.facet_classification.analysis.Facet_classificationDefaultResolverDelegate<org.emftext.language.description.FragmentDescription, org.eclipse.emf.ecore.EObject> delegate = new org.emftext.language.facets.resource.facet_classification.analysis.Facet_classificationDefaultResolverDelegate<org.emftext.language.description.FragmentDescription, org.eclipse.emf.ecore.EObject>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.description.FragmentDescription container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.facets.resource.facet_classification.IFacet_classificationReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		EObject target = container.eResource().getResourceSet().getEObject(URI.createURI(identifier), false);
		if (target != null) {
			result.addMapping(identifier, target);
		}
		return;
	}
	
	public java.lang.String deResolve(org.eclipse.emf.ecore.EObject element, org.emftext.language.description.FragmentDescription container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
