package org.emftext.language.ecore.change.resource.ecore_change.analysis;

public class Ecore_changeTEXTTokenResolver implements org.emftext.language.ecore.change.resource.ecore_change.IEcore_changeTokenResolver {
	
	private org.emftext.language.ecore.change.resource.ecore_change.analysis.Ecore_changeDefaultTokenResolver defaultTokenResolver = new org.emftext.language.ecore.change.resource.ecore_change.analysis.Ecore_changeDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.ecore.change.resource.ecore_change.IEcore_changeTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
