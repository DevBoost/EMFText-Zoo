package org.emftext.language.facets.resource.facet_classification.analysis;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.description.FacetType;

public class FacetTypeReferenceResolver implements org.emftext.language.facets.resource.facet_classification.IFacet_classificationReferenceResolver<org.emftext.language.description.Facet, org.emftext.language.description.FacetType> {
	
	private org.emftext.language.facets.resource.facet_classification.analysis.Facet_classificationDefaultResolverDelegate<org.emftext.language.description.Facet, org.emftext.language.description.FacetType> delegate = new org.emftext.language.facets.resource.facet_classification.analysis.Facet_classificationDefaultResolverDelegate<org.emftext.language.description.Facet, org.emftext.language.description.FacetType>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.description.Facet container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.facets.resource.facet_classification.IFacet_classificationReferenceResolveResult<org.emftext.language.description.FacetType> result) {
		EObject target = container.eResource().getResourceSet().getEObject(URI.createURI(identifier), false);
		if (target != null) {
			if (target instanceof FacetType) {
				FacetType facetType = (FacetType) target;
				result.addMapping(identifier, facetType);
			} else {
				result.setErrorMessage(identifier + " is not a facet type, but " + target.eClass().getName());
			}
		}
		return;
	}
	
	public java.lang.String deResolve(org.emftext.language.description.FacetType element, org.emftext.language.description.Facet container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
}
