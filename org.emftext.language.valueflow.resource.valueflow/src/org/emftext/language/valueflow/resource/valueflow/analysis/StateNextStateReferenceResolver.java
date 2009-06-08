package org.emftext.language.valueflow.resource.valueflow.analysis;

public class StateNextStateReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.valueflow.State, org.emftext.language.valueflow.State> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.language.valueflow.State element, org.emftext.language.valueflow.State container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.valueflow.State container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.valueflow.State> result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
