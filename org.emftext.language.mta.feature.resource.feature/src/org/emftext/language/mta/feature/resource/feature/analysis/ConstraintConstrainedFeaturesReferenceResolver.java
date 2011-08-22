/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.mta.feature.resource.feature.analysis;

public class ConstraintConstrainedFeaturesReferenceResolver implements org.emftext.language.mta.feature.resource.feature.IFeatureReferenceResolver<org.emftext.language.mta.feature.Constraint, org.emftext.language.mta.feature.Feature> {
	
	private org.emftext.language.mta.feature.resource.feature.analysis.FeatureDefaultResolverDelegate<org.emftext.language.mta.feature.Constraint, org.emftext.language.mta.feature.Feature> delegate = new org.emftext.language.mta.feature.resource.feature.analysis.FeatureDefaultResolverDelegate<org.emftext.language.mta.feature.Constraint, org.emftext.language.mta.feature.Feature>();
	
	public void resolve(String identifier, org.emftext.language.mta.feature.Constraint container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.mta.feature.resource.feature.IFeatureReferenceResolveResult<org.emftext.language.mta.feature.Feature> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.mta.feature.Feature element, org.emftext.language.mta.feature.Constraint container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
