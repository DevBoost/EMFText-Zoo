
package org.emftext.language.sql.resource.sql.analysis;

public class SqlQUOTED_39_39TokenResolver implements org.emftext.language.sql.resource.sql.ISqlTokenResolver {
	
	private org.emftext.language.sql.resource.sql.analysis.SqlDefaultTokenResolver defaultTokenResolver = new org.emftext.language.sql.resource.sql.analysis.SqlDefaultTokenResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String result = defaultTokenResolver.deResolve(value, feature, container);
		result += "'";
		result = "'" + result;
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.sql.resource.sql.ISqlTokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
