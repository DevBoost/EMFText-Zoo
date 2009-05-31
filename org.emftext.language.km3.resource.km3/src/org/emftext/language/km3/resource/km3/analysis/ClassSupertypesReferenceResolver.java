package org.emftext.language.km3.resource.km3.analysis;

public class ClassSupertypesReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.eclipse.gmt.am3.dsls.KM3.Class, org.eclipse.gmt.am3.dsls.KM3.Class> {
	
	@Override	
	protected java.lang.String doDeResolve(org.eclipse.gmt.am3.dsls.KM3.Class element, org.eclipse.gmt.am3.dsls.KM3.Class container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.eclipse.gmt.am3.dsls.KM3.Class container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.eclipse.gmt.am3.dsls.KM3.Class> result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
