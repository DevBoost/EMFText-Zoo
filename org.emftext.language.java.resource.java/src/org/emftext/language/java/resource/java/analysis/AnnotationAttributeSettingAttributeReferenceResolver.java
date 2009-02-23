package org.emftext.language.java.resource.java.analysis;

import org.emftext.language.java.annotations.AnnotationAttributeSetting;
import org.emftext.language.java.members.InterfaceMethod;
import org.emftext.language.java.resource.java.analysis.helper.JavaReferenceResolver;
import org.emftext.runtime.resource.IReferenceResolveResult;

public class AnnotationAttributeSettingAttributeReferenceResolver extends 
	JavaReferenceResolver<AnnotationAttributeSetting, InterfaceMethod> {
	
	@Override	
	protected java.lang.String doDeResolve(InterfaceMethod element, AnnotationAttributeSetting container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, AnnotationAttributeSetting container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<InterfaceMethod> result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
