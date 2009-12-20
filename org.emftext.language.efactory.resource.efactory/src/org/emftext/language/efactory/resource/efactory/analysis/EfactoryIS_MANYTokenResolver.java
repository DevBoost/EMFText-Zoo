/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.efactory.resource.efactory.analysis;

public class EfactoryIS_MANYTokenResolver implements org.emftext.language.efactory.resource.efactory.IEfactoryTokenResolver {
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		if (Boolean.TRUE.equals(value)) {
			return "+=";
		} else {
			return "=";
		}
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.efactory.resource.efactory.IEfactoryTokenResolveResult result) {
		if ("+=".equals(lexem)) {
			result.setResolvedToken(Boolean.TRUE);
		} else {
			result.setResolvedToken(Boolean.FALSE);
		}
	}
	
	public void setOptions(java.util.Map<?,?> options) {
	}
}
