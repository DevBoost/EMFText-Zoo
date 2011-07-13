
package org.emftext.language.secprop.resource.text.secprop.analysis;

public class TextSecpropTEXTTokenResolver implements org.emftext.language.secprop.resource.text.secprop.ITextSecpropTokenResolver {
	
	private org.emftext.language.secprop.resource.text.secprop.analysis.TextSecpropDefaultTokenResolver defaultTokenResolver = new org.emftext.language.secprop.resource.text.secprop.analysis.TextSecpropDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.secprop.resource.text.secprop.ITextSecpropTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
