/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.ecore.resource.text.analysis;

import java.util.Map;

import org.emftext.language.ecore.resource.text.ITextEcoreTokenResolveResult;

public class TextEcoreT_UNCHANGEABLETokenResolver implements org.emftext.language.ecore.resource.text.ITextEcoreTokenResolver {
	
	public java.lang.String deResolve(java.lang.Object value,
			org.eclipse.emf.ecore.EStructuralFeature feature,
			org.eclipse.emf.ecore.EObject container) {
		if ((Boolean) value) {
			return "";
		} else {
			return "unchangeable";
		}
	}

	public void resolve(java.lang.String lexem,
			org.eclipse.emf.ecore.EStructuralFeature feature,
			ITextEcoreTokenResolveResult result) {
		if ("unchangeable".equalsIgnoreCase(lexem)) {
			result.setResolvedToken(false);
		} else {
			result.setResolvedToken(true);
		}
	}

	public void setOptions(Map<?, ?> options) {
	}
}
