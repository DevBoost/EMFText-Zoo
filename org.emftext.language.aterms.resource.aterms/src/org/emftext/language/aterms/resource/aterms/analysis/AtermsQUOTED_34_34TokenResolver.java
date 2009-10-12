package org.emftext.language.aterms.resource.aterms.analysis;

public class AtermsQUOTED_34_34TokenResolver implements org.emftext.language.aterms.resource.aterms.IAtermsTokenResolver {
	
	private org.emftext.language.aterms.resource.aterms.analysis.AtermsDefaultTokenResolver defaultTokenResolver = new org.emftext.language.aterms.resource.aterms.analysis.AtermsDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		result += "\"";
		result = "\"" + result;
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.aterms.resource.aterms.IAtermsTokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
