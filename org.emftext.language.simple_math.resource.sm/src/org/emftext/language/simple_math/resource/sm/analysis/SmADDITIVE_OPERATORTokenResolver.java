package org.emftext.language.simple_math.resource.sm.analysis;

public class SmADDITIVE_OPERATORTokenResolver implements org.emftext.language.simple_math.resource.sm.ISmTokenResolver {
	
	private org.emftext.language.simple_math.resource.sm.analysis.SmDefaultTokenResolver defaultTokenResolver = new org.emftext.language.simple_math.resource.sm.analysis.SmDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.simple_math.resource.sm.ISmTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
