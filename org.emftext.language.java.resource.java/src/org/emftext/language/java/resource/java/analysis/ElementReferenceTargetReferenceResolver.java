package org.emftext.language.java.resource.java.analysis;

import org.emftext.language.java.references.ElementReference;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.resource.java.analysis.helper.JavaReferenceResolver;
import org.emftext.runtime.resource.IReferenceResolveResult;

public class ElementReferenceTargetReferenceResolver extends 
	JavaReferenceResolver<ElementReference, ReferenceableElement> {
	
	@Override	
	protected java.lang.String doDeResolve(ReferenceableElement element, ElementReference container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, ElementReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<ReferenceableElement> result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
