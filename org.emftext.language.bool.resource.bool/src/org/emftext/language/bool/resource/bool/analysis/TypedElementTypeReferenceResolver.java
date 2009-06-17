package org.emftext.language.bool.resource.bool.analysis;

public class TypedElementTypeReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.bool.TypedElement, org.emftext.language.bool.TypedElementType> {
	
	private org.emftext.language.bool.resource.bool.analysis.BoolDefaultResolverDelegate<org.emftext.language.bool.TypedElement, org.emftext.language.bool.TypedElementType> delegate = new org.emftext.language.bool.resource.bool.analysis.BoolDefaultResolverDelegate<org.emftext.language.bool.TypedElement, org.emftext.language.bool.TypedElementType>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.bool.TypedElement container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.bool.TypedElementType> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.bool.TypedElementType element, org.emftext.language.bool.TypedElement container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
