/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.petrinets.resource.petrinets.analysis;

public class PetrinetsSTRING_LITERALTokenResolver implements org.emftext.language.petrinets.resource.petrinets.IPetrinetsTokenResolver {
	
	private org.emftext.language.petrinets.resource.petrinets.analysis.PetrinetsDefaultTokenResolver defaultTokenResolver = new org.emftext.language.petrinets.resource.petrinets.analysis.PetrinetsDefaultTokenResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		//String result = defaultTokenResolver.deResolve(value, feature, container);
		String lexem = value.toString();
		if (!lexem.startsWith("\"")) lexem = "\"" + lexem;
		if (!lexem.endsWith("\"")) lexem = lexem + "\"";
		return lexem;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.petrinets.resource.petrinets.IPetrinetsTokenResolveResult result) {
		//defaultTokenResolver.resolve(lexem, feature, result);
		lexem = trimQuotes(lexem);
		result.setResolvedToken(lexem);
	}
	
	private String trimQuotes(String lexem) {
		if (lexem.startsWith("\"")) lexem = lexem.substring(1);
		if (lexem.endsWith("\"")) lexem = lexem.substring(0, lexem.length()-1);
		return lexem;
	}

	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
