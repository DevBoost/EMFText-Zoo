
package org.emftext.language.formsfamily.resource.formsfamily.analysis;

import org.emftext.language.formsfamily.resource.formsfamily.analysis.helper.BooleanAttributeResolver;

public class FormsfamilyMULTIPLETokenResolver implements org.emftext.language.formsfamily.resource.formsfamily.IFormsfamilyTokenResolver {
	
	private BooleanAttributeResolver defaultTokenResolver = new BooleanAttributeResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.formsfamily.resource.formsfamily.IFormsfamilyTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
	}
	
}
