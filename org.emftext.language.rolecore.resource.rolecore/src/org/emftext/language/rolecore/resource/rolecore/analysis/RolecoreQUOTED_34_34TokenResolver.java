package org.emftext.language.rolecore.resource.rolecore.analysis;

public class RolecoreQUOTED_34_34TokenResolver implements org.emftext.language.rolecore.resource.rolecore.IRolecoreTokenResolver {
	
	private org.emftext.language.rolecore.resource.rolecore.analysis.RolecoreDefaultTokenResolver defaultTokenResolver = new org.emftext.language.rolecore.resource.rolecore.analysis.RolecoreDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		result += "\"";
		result = "\"" + result;
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.rolecore.resource.rolecore.IRolecoreTokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}