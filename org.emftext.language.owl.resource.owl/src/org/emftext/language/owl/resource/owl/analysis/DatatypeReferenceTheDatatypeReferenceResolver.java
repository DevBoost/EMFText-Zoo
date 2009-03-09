package org.emftext.language.owl.resource.owl.analysis;

public class DatatypeReferenceTheDatatypeReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.owl.DatatypeReference, org.emftext.language.owl.Datatype> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.language.owl.Datatype element, org.emftext.language.owl.DatatypeReference container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.owl.DatatypeReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.owl.Datatype> result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
