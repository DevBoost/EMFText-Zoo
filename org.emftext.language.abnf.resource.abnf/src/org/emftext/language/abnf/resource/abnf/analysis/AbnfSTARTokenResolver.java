
package org.emftext.language.abnf.resource.abnf.analysis;

public class AbnfSTARTokenResolver implements org.emftext.language.abnf.resource.abnf.IAbnfTokenResolver {
	
	private org.emftext.language.abnf.resource.abnf.analysis.AbnfDefaultTokenResolver defaultTokenResolver = new org.emftext.language.abnf.resource.abnf.analysis.AbnfDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		if (Boolean.TRUE.equals(value)) {
			return "*";
		} else {
			return "";
		}
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.abnf.resource.abnf.IAbnfTokenResolveResult result) {
		if ("*".equals(lexem)) {
			result.setResolvedToken(Boolean.TRUE);
		} else {
			result.setResolvedToken(Boolean.FALSE);
		}
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
