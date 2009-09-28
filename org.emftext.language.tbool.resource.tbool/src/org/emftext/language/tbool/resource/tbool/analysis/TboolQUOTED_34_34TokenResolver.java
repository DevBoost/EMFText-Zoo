package org.emftext.language.tbool.resource.tbool.analysis;

public class TboolQUOTED_34_34TokenResolver implements org.emftext.language.tbool.resource.tbool.ITboolTokenResolver {
	
	private org.emftext.language.tbool.resource.tbool.analysis.TboolDefaultTokenResolver defaultTokenResolver = new org.emftext.language.tbool.resource.tbool.analysis.TboolDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		result += "\"";
		result = "\"" + result;
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.tbool.resource.tbool.ITboolTokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
