
package org.emftext.language.xmas.resource.xmas.analysis;

public class XmasTEXTTokenResolver implements org.emftext.language.xmas.resource.xmas.IXmasTokenResolver {
	
	private org.emftext.language.xmas.resource.xmas.analysis.XmasDefaultTokenResolver defaultTokenResolver = new org.emftext.language.xmas.resource.xmas.analysis.XmasDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.xmas.resource.xmas.IXmasTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
