package org.emftext.language.tcltk.resource.tcl.analysis;

public class TclT_NONEWLINETokenResolver implements org.emftext.language.tcltk.resource.tcl.ITclTokenResolver {
	
	private org.emftext.language.tcltk.resource.tcl.analysis.TclDefaultTokenResolver defaultTokenResolver = new org.emftext.language.tcltk.resource.tcl.analysis.TclDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.tcltk.resource.tcl.ITclTokenResolveResult result) {
		if (lexem.equals("-nonewline")) {
			result.setResolvedToken(true);
		} else {
			result.setResolvedToken(false);
		}
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
