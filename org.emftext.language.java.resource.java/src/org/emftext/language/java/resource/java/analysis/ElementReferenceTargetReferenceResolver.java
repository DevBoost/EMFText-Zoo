package org.emftext.language.java.resource.java.analysis;

import org.emftext.language.java.references.ElementReference;
import org.emftext.language.java.resource.java.analysis.helper.JavaReferenceResolver;

public class ElementReferenceTargetReferenceResolver extends JavaReferenceResolver<ElementReference> {
	
	@Override	
	protected java.lang.String doDeResolve(org.eclipse.emf.ecore.EObject element, org.emftext.language.java.references.ElementReference container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.java.references.ElementReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
