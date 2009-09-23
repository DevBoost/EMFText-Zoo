package org.emftext.language.valueflow.resource.valueflow.analysis;

import java.util.Map;

import org.emftext.language.valueflow.resource.valueflow.ITextValueflowReferenceResolveResult;
import org.emftext.language.valueflow.resource.valueflow.ITextValueflowReferenceResolver;

public class StateNextStateReferenceResolver implements ITextValueflowReferenceResolver<org.emftext.language.valueflow.State, org.emftext.language.valueflow.State> {
	
	private TextValueflowDefaultResolverDelegate<org.emftext.language.valueflow.State, org.emftext.language.valueflow.State> delegate = new TextValueflowDefaultResolverDelegate<org.emftext.language.valueflow.State, org.emftext.language.valueflow.State>();

	public java.lang.String deResolve(org.emftext.language.valueflow.State element, org.emftext.language.valueflow.State container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void resolve(java.lang.String identifier, org.emftext.language.valueflow.State container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, ITextValueflowReferenceResolveResult<org.emftext.language.valueflow.State> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	public void setOptions(Map<?, ?> options) {
	}
}
