/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.analysis;

public class BibQUOTED_35_35TokenResolver implements org.emftext.language.bibtex.resource.bib.IBibTokenResolver {
	
	private org.emftext.language.bibtex.resource.bib.analysis.BibDefaultTokenResolver defaultTokenResolver = new org.emftext.language.bibtex.resource.bib.analysis.BibDefaultTokenResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String result = defaultTokenResolver.deResolve(value, feature, container);
		result += "#";
		result = "#" + result;
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
