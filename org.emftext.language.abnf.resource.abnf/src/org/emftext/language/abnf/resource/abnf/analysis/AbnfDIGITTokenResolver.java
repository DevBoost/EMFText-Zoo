/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.abnf.resource.abnf.analysis;

public class AbnfDIGITTokenResolver implements org.emftext.language.abnf.resource.abnf.IAbnfTokenResolver {
	
	private org.emftext.language.abnf.resource.abnf.analysis.AbnfDefaultTokenResolver defaultTokenResolver = new org.emftext.language.abnf.resource.abnf.analysis.AbnfDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		if (value instanceof Integer) {
			Integer intValue = (Integer) value;
			if (intValue.intValue() == 0) {
				return "";
			}
		}
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.abnf.resource.abnf.IAbnfTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
