package org.emftext.language.valueflow.resource.valueflow.analysis;

import java.util.Map;

import org.emftext.language.valueflow.resource.valueflow.ITextValueflowReferenceResolveResult;
import org.emftext.language.valueflow.resource.valueflow.ITextValueflowReferenceResolver;

public class TakeStateTakeFromReferenceResolver implements ITextValueflowReferenceResolver<org.emftext.language.valueflow.TakeState, org.emftext.language.valueflow.GiveState> {
	
	private TextValueflowDefaultResolverDelegate<org.emftext.language.valueflow.TakeState, org.emftext.language.valueflow.GiveState> delegate = new TextValueflowDefaultResolverDelegate<org.emftext.language.valueflow.TakeState, org.emftext.language.valueflow.GiveState>();
	
	public java.lang.String deResolve(org.emftext.language.valueflow.GiveState element, org.emftext.language.valueflow.TakeState container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
		
	public void resolve(java.lang.String identifier, org.emftext.language.valueflow.TakeState container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, ITextValueflowReferenceResolveResult<org.emftext.language.valueflow.GiveState> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	public void setOptions(Map<?, ?> options) {
	}
}
