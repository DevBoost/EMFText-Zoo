
package org.emftext.language.latex.resource.tex.analysis;

public class TexQUOTED_35_35TokenResolver implements org.emftext.language.latex.resource.tex.ITexTokenResolver {
	
	private org.emftext.language.latex.resource.tex.analysis.TexDefaultTokenResolver defaultTokenResolver = new org.emftext.language.latex.resource.tex.analysis.TexDefaultTokenResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String result = defaultTokenResolver.deResolve(value, feature, container);
		result += "#";
		result = "#" + result;
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.latex.resource.tex.ITexTokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
