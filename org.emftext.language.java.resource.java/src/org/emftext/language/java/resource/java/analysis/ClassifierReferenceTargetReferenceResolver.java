package org.emftext.language.java.resource.java.analysis;

import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.resource.java.analysis.helper.JavaTypeResolver;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.runtime.resource.IReferenceResolveResult;

public class ClassifierReferenceTargetReferenceResolver extends 
	JavaTypeResolver<ClassifierReference, Classifier> {
	
	@Override	
	protected java.lang.String doDeResolve(Classifier classifier, ClassifierReference container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(classifier, container, reference);
	}	
	@Override	
	protected void doResolve(java.lang.String identifier, ClassifierReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<Classifier> result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
