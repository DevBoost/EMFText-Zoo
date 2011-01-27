/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.requirements.resource.requirements.analysis;

public class RequirementsQUOTED_60_62TokenResolver implements org.emftext.language.requirements.resource.requirements.IRequirementsTokenResolver {
	
	private org.emftext.language.requirements.resource.requirements.analysis.RequirementsDefaultTokenResolver defaultTokenResolver = new org.emftext.language.requirements.resource.requirements.analysis.RequirementsDefaultTokenResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String result = defaultTokenResolver.deResolve(value, feature, container);
		result += ">";
		result = "<" + result;
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.requirements.resource.requirements.IRequirementsTokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
