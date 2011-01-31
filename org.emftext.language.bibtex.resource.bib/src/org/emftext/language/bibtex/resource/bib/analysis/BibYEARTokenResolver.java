/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.analysis;

public class BibYEARTokenResolver implements org.emftext.language.bibtex.resource.bib.IBibTokenResolver {
	
	private org.emftext.language.bibtex.resource.bib.analysis.BibDefaultTokenResolver defaultTokenResolver = new org.emftext.language.bibtex.resource.bib.analysis.BibDefaultTokenResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.bibtex.resource.bib.IBibTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
