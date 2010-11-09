/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.egui.resource.egui.analysis;

public class EguiQUOTED_34_34TokenResolver implements org.emftext.language.egui.resource.egui.IEguiTokenResolver {
	
	private org.emftext.language.egui.resource.egui.analysis.EguiDefaultTokenResolver defaultTokenResolver = new org.emftext.language.egui.resource.egui.analysis.EguiDefaultTokenResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String result = defaultTokenResolver.deResolve(value, feature, container);
		result += "\"";
		result = "\"" + result;
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.egui.resource.egui.IEguiTokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
