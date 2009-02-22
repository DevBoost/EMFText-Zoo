package org.emftext.language.java.resource.java.analysis;

import org.emftext.language.java.annotations.AnnotationAttribute;
import org.emftext.language.java.annotations.AnnotationAttributeSetting;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;

public class AnnotationAttributeSettingAttributeReferenceResolver extends 
	AbstractReferenceResolver<AnnotationAttributeSetting, AnnotationAttribute> {
	
	@Override	
	protected java.lang.String doDeResolve(AnnotationAttribute element, AnnotationAttributeSetting container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, AnnotationAttributeSetting container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<AnnotationAttribute> result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
