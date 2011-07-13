
package org.emftext.language.rolecore.resource.rolecore.analysis;

public class RolecoreREFTYPETokenResolver implements org.emftext.language.rolecore.resource.rolecore.IRolecoreTokenResolver {
	
	private org.emftext.language.rolecore.resource.rolecore.analysis.RolecoreDefaultTokenResolver defaultTokenResolver = new org.emftext.language.rolecore.resource.rolecore.analysis.RolecoreDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// TODO implement
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.rolecore.resource.rolecore.IRolecoreTokenResolveResult result) {
		if (lexem!=null && lexem.length()>5){
			lexem = lexem.substring(5);
		}
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
