/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.efactory.resource.efactory.analysis;

import org.eclipse.emf.ecore.EReference;
import org.emftext.language.efactory.Feature;
import org.emftext.language.efactory.resource.efactory.analysis.helper.CustomEfactoryDefaultResolverDelegate;

public class ReferenceValueReferenceResolver implements org.emftext.language.efactory.resource.efactory.IEfactoryReferenceResolver<org.emftext.language.efactory.Reference, org.eclipse.emf.ecore.EObject> {
	
	private org.emftext.language.efactory.resource.efactory.analysis.EfactoryDefaultResolverDelegate<org.emftext.language.efactory.Reference, org.eclipse.emf.ecore.EObject> delegate = new CustomEfactoryDefaultResolverDelegate<org.emftext.language.efactory.Reference, org.eclipse.emf.ecore.EObject>();
	
	public void resolve(String identifier, org.emftext.language.efactory.Reference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.efactory.resource.efactory.IEfactoryReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		Feature feature = (Feature) container.eContainer();
		if (feature.getEFeature() instanceof EReference) {
			EReference realReference = (EReference) feature.getEFeature();
			delegate.resolve(identifier, container, realReference, position, resolveFuzzy, result);
		}
	}
	
	public String deResolve(org.eclipse.emf.ecore.EObject element, org.emftext.language.efactory.Reference container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
