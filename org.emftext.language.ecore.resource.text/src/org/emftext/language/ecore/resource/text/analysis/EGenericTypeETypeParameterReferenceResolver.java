package org.emftext.language.ecore.resource.text.analysis;

public class EGenericTypeETypeParameterReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.eclipse.emf.ecore.EGenericType, org.eclipse.emf.ecore.ETypeParameter> {
	
	@Override	
	protected java.lang.String doDeResolve(org.eclipse.emf.ecore.ETypeParameter element, org.eclipse.emf.ecore.EGenericType container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.eclipse.emf.ecore.EGenericType container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.eclipse.emf.ecore.ETypeParameter> result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
