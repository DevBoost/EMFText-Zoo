package org.emftext.language.owl.resource.owl.analysis;

public class AnnotationPropertySuperAnnotationPropertiesReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.owl.AnnotationProperty, org.emftext.language.owl.AnnotationProperty> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.language.owl.AnnotationProperty element, org.emftext.language.owl.AnnotationProperty container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.owl.AnnotationProperty container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.owl.AnnotationProperty> result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
