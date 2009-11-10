package org.emftext.language.tcltk.resource.tcl.analysis;

import java.util.Map;

public class TclVARTokenResolver implements org.emftext.language.tcltk.resource.tcl.ITclTokenResolver {

	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		return "$" + value;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.tcltk.resource.tcl.ITclTokenResolveResult result) {
		result.setResolvedToken(lexem.substring(1));
	}

	public void setOptions(Map<?, ?> options) {
	}

	
}
