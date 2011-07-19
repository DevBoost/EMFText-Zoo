/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.dbschema.resource.dbschema.analysis;

public class DbschemaTEXTTokenResolver implements org.emftext.language.dbschema.resource.dbschema.IDbschemaTokenResolver {
	
	private org.emftext.language.dbschema.resource.dbschema.analysis.DbschemaDefaultTokenResolver defaultTokenResolver = new org.emftext.language.dbschema.resource.dbschema.analysis.DbschemaDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.dbschema.resource.dbschema.IDbschemaTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
