package org.emftext.language.java.resource.java.analysis;

public class ElementReferenceTargetReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.java.references.ElementReference, org.emftext.language.java.references.ReferenceableElement> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.language.java.references.ReferenceableElement element, org.emftext.language.java.references.ElementReference container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.java.references.ElementReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
