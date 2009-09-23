package org.emftext.language.parametercheck.resource.pcheck.analysis;

public class PcheckNAME_TYPETokenResolver implements org.emftext.language.parametercheck.resource.pcheck.IPcheckTokenResolver {
	
	private org.emftext.language.parametercheck.resource.pcheck.analysis.PcheckDefaultTokenResolver defaultTokenResolver = new org.emftext.language.parametercheck.resource.pcheck.analysis.PcheckDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.parametercheck.resource.pcheck.IPcheckTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
