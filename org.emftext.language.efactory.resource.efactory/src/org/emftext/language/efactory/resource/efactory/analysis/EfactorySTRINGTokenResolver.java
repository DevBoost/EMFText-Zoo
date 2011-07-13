
package org.emftext.language.efactory.resource.efactory.analysis;

public class EfactorySTRINGTokenResolver implements org.emftext.language.efactory.resource.efactory.IEfactoryTokenResolver {
	
	private org.emftext.language.efactory.resource.efactory.analysis.EfactoryDefaultTokenResolver defaultTokenResolver = new org.emftext.language.efactory.resource.efactory.analysis.EfactoryDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		result += "\"";
		result = "\"" + result;
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.efactory.resource.efactory.IEfactoryTokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
}
