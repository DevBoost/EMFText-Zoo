package org.emftext.language.db_schema.resource.db_schema.analysis;

public class Db_schemaINTEGERTokenResolver implements org.emftext.language.db_schema.resource.db_schema.IDb_schemaTokenResolver {
	
	private org.emftext.language.db_schema.resource.db_schema.analysis.Db_schemaDefaultTokenResolver defaultTokenResolver = new org.emftext.language.db_schema.resource.db_schema.analysis.Db_schemaDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.db_schema.resource.db_schema.IDb_schemaTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
