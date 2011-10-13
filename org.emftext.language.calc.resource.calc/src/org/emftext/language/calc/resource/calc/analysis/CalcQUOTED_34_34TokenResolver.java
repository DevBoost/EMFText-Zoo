/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.calc.resource.calc.analysis;

public class CalcQUOTED_34_34TokenResolver implements org.emftext.language.calc.resource.calc.ICalcTokenResolver {
	
	private org.emftext.language.calc.resource.calc.analysis.CalcDefaultTokenResolver defaultTokenResolver = new org.emftext.language.calc.resource.calc.analysis.CalcDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, "\"", "\"", null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.calc.resource.calc.ICalcTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, "\"", "\"", null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
