/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0extended.resource.pl0extended.analysis;

public class Pl0extendedQUOTED_60_62TokenResolver implements org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedTokenResolver {
	
	private org.emftext.language.pl0extended.resource.pl0extended.analysis.Pl0extendedDefaultTokenResolver defaultTokenResolver = new org.emftext.language.pl0extended.resource.pl0extended.analysis.Pl0extendedDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		result += ">";
		result = "<" + result;
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedTokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
