package org.eclipse.emf.ecore.resource.ecore.analysis;

public class EReferenceEOppositeReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.eclipse.emf.ecore.EReference, org.eclipse.emf.ecore.EReference> {
	
	@Override	
	protected java.lang.String doDeResolve(org.eclipse.emf.ecore.EReference element, org.eclipse.emf.ecore.EReference container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.eclipse.emf.ecore.EReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
