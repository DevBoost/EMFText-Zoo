package org.emftext.language.java.resource.java.analysis;

import org.emftext.language.java.resource.java.analysis.helper.JavaTypeResolver;

public class AnnotationInstanceAnnotationReferenceResolver extends JavaTypeResolver<org.emftext.language.java.annotations.AnnotationInstance, org.emftext.language.java.classifiers.Classifier> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.language.java.classifiers.Classifier element, org.emftext.language.java.annotations.AnnotationInstance container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.java.annotations.AnnotationInstance container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.java.classifiers.Classifier> result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
