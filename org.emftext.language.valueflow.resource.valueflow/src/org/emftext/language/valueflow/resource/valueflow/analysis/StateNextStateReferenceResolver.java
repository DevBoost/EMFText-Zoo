package org.emftext.language.valueflow.resource.valueflow.analysis;

import java.util.Map;

public class StateNextStateReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.valueflow.State, org.emftext.language.valueflow.State> {
	
	private TextValueflowDefaultResolverDelegate<org.emftext.language.valueflow.State, org.emftext.language.valueflow.State> delegate = new TextValueflowDefaultResolverDelegate<org.emftext.language.valueflow.State, org.emftext.language.valueflow.State>();

	public java.lang.String deResolve(org.emftext.language.valueflow.State element, org.emftext.language.valueflow.State container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void resolve(java.lang.String identifier, org.emftext.language.valueflow.State container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.valueflow.State> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	public void setOptions(Map<?, ?> options) {
	}
}
