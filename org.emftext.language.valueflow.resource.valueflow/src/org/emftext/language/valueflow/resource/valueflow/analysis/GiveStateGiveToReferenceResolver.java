package org.emftext.language.valueflow.resource.valueflow.analysis;

import java.util.Map;

public class GiveStateGiveToReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.valueflow.GiveState, org.emftext.language.valueflow.TakeState> {

	private TextValueflowDefaultResolverDelegate<org.emftext.language.valueflow.GiveState, org.emftext.language.valueflow.TakeState> delegate = new TextValueflowDefaultResolverDelegate<org.emftext.language.valueflow.GiveState, org.emftext.language.valueflow.TakeState>();

	public java.lang.String deResolve(org.emftext.language.valueflow.TakeState element, org.emftext.language.valueflow.GiveState container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void resolve(java.lang.String identifier, org.emftext.language.valueflow.GiveState container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.valueflow.TakeState> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	public void setOptions(Map<?, ?> options) {
	}
}
