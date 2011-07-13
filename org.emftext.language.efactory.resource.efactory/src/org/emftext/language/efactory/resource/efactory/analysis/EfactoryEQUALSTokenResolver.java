
package org.emftext.language.efactory.resource.efactory.analysis;

public class EfactoryEQUALSTokenResolver implements org.emftext.language.efactory.resource.efactory.IEfactoryTokenResolver {
	
	private org.emftext.language.efactory.resource.efactory.analysis.EfactoryDefaultTokenResolver defaultTokenResolver = new org.emftext.language.efactory.resource.efactory.analysis.EfactoryDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		if (Boolean.TRUE.equals(value)) {
			return "+=";
		} else {
			return "=";
		}
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.efactory.resource.efactory.IEfactoryTokenResolveResult result) {
		result.setResolvedToken(Boolean.FALSE);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
