package org.emftext.language.valueflow.resource.valueflow.analysis;

public class TakeStateTakeFromReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.valueflow.TakeState, org.emftext.language.valueflow.GiveState> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.language.valueflow.GiveState element, org.emftext.language.valueflow.TakeState container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.valueflow.TakeState container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.valueflow.GiveState> result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
