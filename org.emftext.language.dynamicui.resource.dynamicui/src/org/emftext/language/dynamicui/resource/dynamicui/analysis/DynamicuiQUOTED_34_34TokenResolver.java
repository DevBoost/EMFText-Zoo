/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.dynamicui.resource.dynamicui.analysis;

public class DynamicuiQUOTED_34_34TokenResolver implements org.emftext.language.dynamicui.resource.dynamicui.IDynamicuiTokenResolver {
	
	private org.emftext.language.dynamicui.resource.dynamicui.analysis.DynamicuiDefaultTokenResolver defaultTokenResolver = new org.emftext.language.dynamicui.resource.dynamicui.analysis.DynamicuiDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, "\"", "\"", null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.dynamicui.resource.dynamicui.IDynamicuiTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, "\"", "\"", null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
