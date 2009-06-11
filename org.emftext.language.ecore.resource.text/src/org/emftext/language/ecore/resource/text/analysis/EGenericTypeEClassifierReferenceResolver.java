package org.emftext.language.ecore.resource.text.analysis;

import org.emftext.language.ecore.resource.text.analysis.helper.EMFTypesResolver;

public class EGenericTypeEClassifierReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.eclipse.emf.ecore.EGenericType, org.eclipse.emf.ecore.EClassifier> {
	
	@Override	
	protected java.lang.String doDeResolve(org.eclipse.emf.ecore.EClassifier element, org.eclipse.emf.ecore.EGenericType container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.eclipse.emf.ecore.EGenericType container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.eclipse.emf.ecore.EClassifier> result) {
		new EMFTypesResolver().doResolve(identifier, container.eResource(), reference, position, resolveFuzzy, result);
	}
}
