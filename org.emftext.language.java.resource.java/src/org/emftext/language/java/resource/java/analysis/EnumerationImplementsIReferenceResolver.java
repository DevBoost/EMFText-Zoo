package org.emftext.language.java.resource.java.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class EnumerationImplementsIReferenceResolver extends org.emftext.runtime.resource.impl.ReferenceResolverImpl {

	@Override
	protected String doDeResolve(EObject element, EObject container, EReference reference) {
		return super.doDeResolve(element, container, reference);
	}

	@Override
	protected void doResolve(String identifier, EObject container, EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IResolveResult result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
