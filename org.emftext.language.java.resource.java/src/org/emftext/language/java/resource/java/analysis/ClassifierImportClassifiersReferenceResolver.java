package org.emftext.language.java.resource.java.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.java.resource.java.analysis.helper.ImportReferenceResolver;

public class ClassifierImportClassifiersReferenceResolver extends ImportReferenceResolver {

	@Override
	protected String doDeResolve(EObject element, EObject container, EReference reference) {
		return super.doDeResolve(element, container, reference);
	}

	@Override
	protected void doResolve(String identifier, EObject container, EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IResolveResult result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
