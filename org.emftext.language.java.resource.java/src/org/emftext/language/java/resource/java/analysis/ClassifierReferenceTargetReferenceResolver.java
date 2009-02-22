package org.emftext.language.java.resource.java.analysis;

public class ClassifierReferenceTargetReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.java.types.ClassifierReference, org.emftext.language.java.classifiers.Classifier> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.language.java.classifiers.Classifier element, org.emftext.language.java.types.ClassifierReference container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.java.types.ClassifierReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
