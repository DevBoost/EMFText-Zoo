/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.webtest.resource.webtest.analysis;

public class WebtestQUOTED_60_62TokenResolver implements org.emftext.language.webtest.resource.webtest.IWebtestTokenResolver {
	
	private org.emftext.language.webtest.resource.webtest.analysis.WebtestDefaultTokenResolver defaultTokenResolver = new org.emftext.language.webtest.resource.webtest.analysis.WebtestDefaultTokenResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String result = defaultTokenResolver.deResolve(value, feature, container);
		result += ">";
		result = "<" + result;
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.webtest.resource.webtest.IWebtestTokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
