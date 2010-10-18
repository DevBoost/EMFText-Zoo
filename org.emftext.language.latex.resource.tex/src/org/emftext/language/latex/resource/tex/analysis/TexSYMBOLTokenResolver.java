/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.latex.resource.tex.analysis;

public class TexSYMBOLTokenResolver implements org.emftext.language.latex.resource.tex.ITexTokenResolver {
	
	private org.emftext.language.latex.resource.tex.analysis.TexDefaultTokenResolver defaultTokenResolver = new org.emftext.language.latex.resource.tex.analysis.TexDefaultTokenResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.latex.resource.tex.ITexTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
