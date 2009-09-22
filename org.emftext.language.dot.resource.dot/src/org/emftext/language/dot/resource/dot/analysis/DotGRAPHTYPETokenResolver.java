package org.emftext.language.dot.resource.dot.analysis;

public class DotGRAPHTYPETokenResolver implements org.emftext.language.dot.resource.dot.IDotTokenResolver {
	
	private org.emftext.language.dot.resource.dot.analysis.DotDefaultTokenResolver defaultTokenResolver = new org.emftext.language.dot.resource.dot.analysis.DotDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.dot.resource.dot.IDotTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
