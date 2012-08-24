/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.csv.resource.csv.analysis;

public class CsvQUOTED_34_34_92TokenResolver implements org.emftext.language.csv.resource.csv.ICsvTokenResolver {
	
	private org.emftext.language.csv.resource.csv.analysis.CsvDefaultTokenResolver defaultTokenResolver = new org.emftext.language.csv.resource.csv.analysis.CsvDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, "\"", "\"", "\\");
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.csv.resource.csv.ICsvTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, "\"", "\"", "\\");
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
