package org.emftext.language.featherweight_java.resource.fj.analysis;

import org.emftext.language.featherweight_java.resource.fj.analysis.helper.ClassResolver;

public class ClassSuperclassReferenceResolver implements org.emftext.language.featherweight_java.resource.fj.IFjReferenceResolver<org.emftext.language.featherweight_java.Class, org.emftext.language.featherweight_java.Class> {
	
	private ClassResolver delegate = new ClassResolver();
	
	public void resolve(java.lang.String identifier, org.emftext.language.featherweight_java.Class container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.language.featherweight_java.resource.fj.IFjReferenceResolveResult<org.emftext.language.featherweight_java.Class> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.featherweight_java.Class element, org.emftext.language.featherweight_java.Class container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		
	}
	
}
