package org.emftext.language.java.resource.java.analysis;

public class ClassifierImportClassifierReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.java.imports.ClassifierImport, org.emftext.language.java.classifiers.ConcreteClassifier> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.language.java.classifiers.ConcreteClassifier element, org.emftext.language.java.imports.ClassifierImport container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.java.imports.ClassifierImport container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
