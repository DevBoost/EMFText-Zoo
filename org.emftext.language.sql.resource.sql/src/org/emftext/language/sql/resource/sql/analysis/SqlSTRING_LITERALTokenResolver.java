/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.sql.resource.sql.analysis;

public class SqlSTRING_LITERALTokenResolver implements org.emftext.language.sql.resource.sql.ISqlTokenResolver {
	
	private org.emftext.language.sql.resource.sql.analysis.SqlDefaultTokenResolver defaultTokenResolver = new org.emftext.language.sql.resource.sql.analysis.SqlDefaultTokenResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.sql.resource.sql.ISqlTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
