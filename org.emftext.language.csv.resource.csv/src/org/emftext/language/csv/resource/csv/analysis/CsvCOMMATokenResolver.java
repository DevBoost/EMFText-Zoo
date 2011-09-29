/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.csv.resource.csv.analysis;

public class CsvCOMMATokenResolver implements org.emftext.language.csv.resource.csv.ICsvTokenResolver {
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		return ";";
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.csv.resource.csv.ICsvTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		result.setResolvedToken("");
	}
	
	public void setOptions(java.util.Map<?,?> options) { }
	
}
