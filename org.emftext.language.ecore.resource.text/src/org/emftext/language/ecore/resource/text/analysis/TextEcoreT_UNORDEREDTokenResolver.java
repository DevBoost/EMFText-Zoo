/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.ecore.resource.text.analysis;

public class TextEcoreT_UNORDEREDTokenResolver implements org.emftext.language.ecore.resource.text.ITextEcoreTokenResolver {
	
	private org.emftext.language.ecore.resource.text.analysis.TextEcoreDefaultTokenResolver defaultTokenResolver = new org.emftext.language.ecore.resource.text.analysis.TextEcoreDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		if ((Boolean) value) {
			return "";
		} else {
			return "unordered";
		}
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.ecore.resource.text.ITextEcoreTokenResolveResult result) {
		if ("unordered".equalsIgnoreCase(lexem)) {
			result.setResolvedToken(false);
		} else {
			result.setResolvedToken(true);
		}
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
