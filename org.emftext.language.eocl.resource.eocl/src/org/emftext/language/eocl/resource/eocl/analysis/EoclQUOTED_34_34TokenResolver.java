
package org.emftext.language.eocl.resource.eocl.analysis;

public class EoclQUOTED_34_34TokenResolver implements org.emftext.language.eocl.resource.eocl.IEoclTokenResolver {
	
	private org.emftext.language.eocl.resource.eocl.analysis.EoclDefaultTokenResolver defaultTokenResolver = new org.emftext.language.eocl.resource.eocl.analysis.EoclDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		result += "\"";
		result = "\"" + result;
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.eocl.resource.eocl.IEoclTokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
