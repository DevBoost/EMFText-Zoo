package org.emftext.language.featherweight_java.resource.fj.analysis;

public class FjTEXTTokenResolver implements org.emftext.language.featherweight_java.resource.fj.IFjTokenResolver {
	
	private org.emftext.language.featherweight_java.resource.fj.analysis.FjDefaultTokenResolver defaultTokenResolver = new org.emftext.language.featherweight_java.resource.fj.analysis.FjDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.featherweight_java.resource.fj.IFjTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
