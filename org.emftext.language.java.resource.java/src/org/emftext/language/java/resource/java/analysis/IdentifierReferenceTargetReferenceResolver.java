package org.emftext.language.java.resource.java.analysis;

import org.emftext.language.java.resource.java.analysis.helper.JavaReferenceResolver;

public class IdentifierReferenceTargetReferenceResolver extends JavaReferenceResolver {

	@Override
	protected java.lang.String doDeResolve(org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}

	@Override
	protected void doResolve(java.lang.String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IResolveResult result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
