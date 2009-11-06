package org.emftext.language.otcl.resource.tcl.analysis;

public class TclTEXTTokenResolver implements org.emftext.language.otcl.resource.tcl.ITclTokenResolver {
	
	private org.emftext.language.otcl.resource.tcl.analysis.TclDefaultTokenResolver defaultTokenResolver = new org.emftext.language.otcl.resource.tcl.analysis.TclDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.otcl.resource.tcl.ITclTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
