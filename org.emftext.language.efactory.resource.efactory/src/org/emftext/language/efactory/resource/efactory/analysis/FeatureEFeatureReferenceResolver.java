/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.efactory.resource.efactory.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.efactory.NewObject;

public class FeatureEFeatureReferenceResolver implements org.emftext.language.efactory.resource.efactory.IEfactoryReferenceResolver<org.emftext.language.efactory.Feature, org.eclipse.emf.ecore.EStructuralFeature> {
	
	private org.emftext.language.efactory.resource.efactory.analysis.EfactoryDefaultResolverDelegate<org.emftext.language.efactory.Feature, org.eclipse.emf.ecore.EStructuralFeature> delegate = new org.emftext.language.efactory.resource.efactory.analysis.EfactoryDefaultResolverDelegate<org.emftext.language.efactory.Feature, org.eclipse.emf.ecore.EStructuralFeature>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.efactory.Feature container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.efactory.resource.efactory.IEfactoryReferenceResolveResult<org.eclipse.emf.ecore.EStructuralFeature> result) {
		NewObject newObject = findNewObject(container);
		if (newObject == null) {
			return;
		}
		EClass eClass = newObject.getEClass();
		if (eClass == null) {
			return;
		}
		if (eClass.eIsProxy()) {
			result.addMapping(identifier, URI.createURI(identifier));
			return;
		}
		EList<EStructuralFeature> structuralFeatures = eClass.getEAllStructuralFeatures();
		for (EStructuralFeature eStructuralFeature : structuralFeatures) {
			if (resolveFuzzy) {
				result.addMapping(eStructuralFeature.getName(), eStructuralFeature);
			} else {
				if (identifier.equals(eStructuralFeature.getName())) {
					result.addMapping(identifier, eStructuralFeature);
					return;
				}
			}
		}
	}
	
	private NewObject findNewObject(EObject object) {
		if (object == null) {
			return null;
		}
		if (object instanceof NewObject) {
			return (NewObject) object;
		}
		return findNewObject(object.eContainer());
	}

	public java.lang.String deResolve(org.eclipse.emf.ecore.EStructuralFeature element, org.emftext.language.efactory.Feature container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
