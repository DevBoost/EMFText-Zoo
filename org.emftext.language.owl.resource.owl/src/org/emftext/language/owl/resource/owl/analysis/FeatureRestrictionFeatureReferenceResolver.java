package org.emftext.language.owl.resource.owl.analysis;

import org.emftext.language.owl.resource.owl.analysis.custom.CrossResourceIRIResolver;

public class FeatureRestrictionFeatureReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.owl.FeatureRestriction, org.emftext.language.owl.Feature> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.language.owl.Feature element, org.emftext.language.owl.FeatureRestriction container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.owl.FeatureRestriction container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.owl.Feature> result) {
		CrossResourceIRIResolver.theInstance().doResolve(identifier, container, resolveFuzzy, result, org.emftext.language.owl.Feature.class);
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
