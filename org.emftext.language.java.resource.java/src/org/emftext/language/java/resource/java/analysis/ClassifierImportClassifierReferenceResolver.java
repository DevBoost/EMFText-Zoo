package org.emftext.language.java.resource.java.analysis;

import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.imports.ClassifierImport;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;

public class ClassifierImportClassifierReferenceResolver extends 
	AbstractReferenceResolver<ClassifierImport, ConcreteClassifier> {
	
	@Override	
	protected java.lang.String doDeResolve(ConcreteClassifier element, ClassifierImport container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, ClassifierImport container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<ConcreteClassifier> result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
