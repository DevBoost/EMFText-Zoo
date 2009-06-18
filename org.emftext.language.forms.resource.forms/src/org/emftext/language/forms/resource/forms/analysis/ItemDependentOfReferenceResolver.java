package org.emftext.language.forms.resource.forms.analysis;

public class ItemDependentOfReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.forms.Item, org.emftext.language.forms.Option> {
	
	private org.emftext.language.forms.resource.forms.analysis.FormsDefaultResolverDelegate<org.emftext.language.forms.Item, org.emftext.language.forms.Option> delegate = new org.emftext.language.forms.resource.forms.analysis.FormsDefaultResolverDelegate<org.emftext.language.forms.Item, org.emftext.language.forms.Option>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.forms.Item container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.forms.Option> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.forms.Option element, org.emftext.language.forms.Item container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
