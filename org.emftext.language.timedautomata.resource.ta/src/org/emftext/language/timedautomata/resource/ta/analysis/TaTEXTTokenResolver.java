
package org.emftext.language.timedautomata.resource.ta.analysis;

public class TaTEXTTokenResolver implements org.emftext.language.timedautomata.resource.ta.ITaTokenResolver {
	
	private org.emftext.language.timedautomata.resource.ta.analysis.TaDefaultTokenResolver defaultTokenResolver = new org.emftext.language.timedautomata.resource.ta.analysis.TaDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.timedautomata.resource.ta.ITaTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
