
package org.emftext.language.lwc11.resource.lwc11.analysis;

public class Lwc11TEXTTokenResolver implements org.emftext.language.lwc11.resource.lwc11.ILwc11TokenResolver {
	
	private org.emftext.language.lwc11.resource.lwc11.analysis.Lwc11DefaultTokenResolver defaultTokenResolver = new org.emftext.language.lwc11.resource.lwc11.analysis.Lwc11DefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.lwc11.resource.lwc11.ILwc11TokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
