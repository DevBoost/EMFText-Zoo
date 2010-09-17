/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.forms.resource.forms.analysis;

public class FormsIDENTIFIERTokenResolver implements org.emftext.language.forms.resource.forms.IFormsTokenResolver {
	
	private org.emftext.language.forms.resource.forms.analysis.FormsDefaultTokenResolver defaultTokenResolver = new org.emftext.language.forms.resource.forms.analysis.FormsDefaultTokenResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.forms.resource.forms.IFormsTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
