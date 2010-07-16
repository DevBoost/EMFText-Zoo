/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.modelquery.resource.modelquery.analysis;

public class ModelqueryQUOTED_36_36TokenResolver implements org.emftext.language.modelquery.resource.modelquery.IModelqueryTokenResolver {
	
	private org.emftext.language.modelquery.resource.modelquery.analysis.ModelqueryDefaultTokenResolver defaultTokenResolver = new org.emftext.language.modelquery.resource.modelquery.analysis.ModelqueryDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		result += "$";
		result = "$" + result;
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.modelquery.resource.modelquery.IModelqueryTokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
