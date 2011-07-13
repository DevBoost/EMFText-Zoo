
package org.emftext.language.company.resource.company.analysis;

public class CompanyDECIMAL_DOUBLE_LITERALTokenResolver implements org.emftext.language.company.resource.company.ICompanyTokenResolver {
	
	private org.emftext.language.company.resource.company.analysis.CompanyDefaultTokenResolver defaultTokenResolver = new org.emftext.language.company.resource.company.analysis.CompanyDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.company.resource.company.ICompanyTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
