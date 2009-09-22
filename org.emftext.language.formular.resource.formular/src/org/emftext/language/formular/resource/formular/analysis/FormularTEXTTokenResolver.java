package org.emftext.language.formular.resource.formular.analysis;

public class FormularTEXTTokenResolver implements org.emftext.language.formular.resource.formular.IFormularTokenResolver {
	
	private org.emftext.language.formular.resource.formular.analysis.FormularDefaultTokenResolver defaultTokenResolver = new org.emftext.language.formular.resource.formular.analysis.FormularDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.formular.resource.formular.IFormularTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
