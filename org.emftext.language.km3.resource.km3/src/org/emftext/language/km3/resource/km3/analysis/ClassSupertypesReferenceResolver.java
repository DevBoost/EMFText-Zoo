package org.emftext.language.km3.resource.km3.analysis;

import java.util.Map;

public class ClassSupertypesReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.eclipse.gmt.am3.dsls.KM3.Class, org.eclipse.gmt.am3.dsls.KM3.Class> {
	
	private Km3DefaultResolverDelegate<org.eclipse.gmt.am3.dsls.KM3.Class, org.eclipse.gmt.am3.dsls.KM3.Class> delegate = new Km3DefaultResolverDelegate<org.eclipse.gmt.am3.dsls.KM3.Class, org.eclipse.gmt.am3.dsls.KM3.Class>();
	
	public java.lang.String deResolve(org.eclipse.gmt.am3.dsls.KM3.Class element, org.eclipse.gmt.am3.dsls.KM3.Class container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void resolve(java.lang.String identifier, org.eclipse.gmt.am3.dsls.KM3.Class container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.eclipse.gmt.am3.dsls.KM3.Class> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	public void setOptions(Map<?, ?> options) {
	}
}
