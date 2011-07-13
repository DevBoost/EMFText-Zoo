
package org.emftext.language.eocl.resource.eocl.analysis;

public class EGenericTypeETypeParameterReferenceResolver implements org.emftext.language.eocl.resource.eocl.IEoclReferenceResolver<org.eclipse.emf.ecore.EGenericType, org.eclipse.emf.ecore.ETypeParameter> {
	
	private org.emftext.language.eocl.resource.eocl.analysis.EoclDefaultResolverDelegate<org.eclipse.emf.ecore.EGenericType, org.eclipse.emf.ecore.ETypeParameter> delegate = new org.emftext.language.eocl.resource.eocl.analysis.EoclDefaultResolverDelegate<org.eclipse.emf.ecore.EGenericType, org.eclipse.emf.ecore.ETypeParameter>();
	
	public void resolve(java.lang.String identifier, org.eclipse.emf.ecore.EGenericType container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.eocl.resource.eocl.IEoclReferenceResolveResult<org.eclipse.emf.ecore.ETypeParameter> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.eclipse.emf.ecore.ETypeParameter element, org.eclipse.emf.ecore.EGenericType container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
