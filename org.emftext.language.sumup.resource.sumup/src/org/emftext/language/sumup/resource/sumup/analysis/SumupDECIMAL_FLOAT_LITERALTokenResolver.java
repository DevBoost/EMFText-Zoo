
package org.emftext.language.sumup.resource.sumup.analysis;

public class SumupDECIMAL_FLOAT_LITERALTokenResolver implements org.emftext.language.sumup.resource.sumup.ISumupTokenResolver {
	
	private org.emftext.language.sumup.resource.sumup.analysis.SumupDefaultTokenResolver defaultTokenResolver = new org.emftext.language.sumup.resource.sumup.analysis.SumupDefaultTokenResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.sumup.resource.sumup.ISumupTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
