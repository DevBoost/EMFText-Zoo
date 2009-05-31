package org.emftext.language.km3.resource.km3.analysis;

public class TypedElementTypeReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.eclipse.gmt.am3.dsls.KM3.TypedElement, org.eclipse.gmt.am3.dsls.KM3.Classifier> {
	
	@Override	
	protected java.lang.String doDeResolve(org.eclipse.gmt.am3.dsls.KM3.Classifier element, org.eclipse.gmt.am3.dsls.KM3.TypedElement container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.eclipse.gmt.am3.dsls.KM3.TypedElement container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.eclipse.gmt.am3.dsls.KM3.Classifier> result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
