package org.emftext.language.forms.resource.forms.analysis;

import org.emftext.language.forms.resource.forms.analysis.helper.BooleanAttributeResolver;

public class FormsMULTIPLETokenResolver implements org.emftext.language.forms.resource.forms.IFormsTokenResolver {
	
	private BooleanAttributeResolver defaultTokenResolver = new BooleanAttributeResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.forms.resource.forms.IFormsTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
	}
	
}
