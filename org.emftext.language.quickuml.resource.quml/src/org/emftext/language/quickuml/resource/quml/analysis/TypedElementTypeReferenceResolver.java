package org.emftext.language.quickuml.resource.quml.analysis;

public class TypedElementTypeReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.eclipse.uml2.uml.TypedElement, org.eclipse.uml2.uml.Type> {
	
	@Override	
	protected java.lang.String doDeResolve(org.eclipse.uml2.uml.Type element, org.eclipse.uml2.uml.TypedElement container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.eclipse.uml2.uml.TypedElement container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.eclipse.uml2.uml.Type> result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
