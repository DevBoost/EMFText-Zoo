package org.emftext.language.ecore.change.resource.ecore_change.analysis;

public class EObjectToChangesMapEntryKeyReferenceResolver implements org.emftext.language.ecore.change.resource.ecore_change.IEcore_changeReferenceResolver<java.util.Map.Entry, org.eclipse.emf.ecore.EObject> {
	
	private org.emftext.language.ecore.change.resource.ecore_change.analysis.Ecore_changeDefaultResolverDelegate<java.util.Map.Entry, org.eclipse.emf.ecore.EObject> delegate = new org.emftext.language.ecore.change.resource.ecore_change.analysis.Ecore_changeDefaultResolverDelegate<java.util.Map.Entry, org.eclipse.emf.ecore.EObject>();
	
	public void resolve(java.lang.String identifier, java.util.Map.Entry container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.ecore.change.resource.ecore_change.IEcore_changeReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.eclipse.emf.ecore.EObject element, java.util.Map.Entry container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
