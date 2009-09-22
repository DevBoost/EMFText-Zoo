package org.emftext.language.office.resource.office.analysis;

import java.util.Map;

import org.emftext.language.office.resource.office.IOfficeTokenResolveResult;
import org.emftext.language.office.resource.office.IOfficeTokenResolver;

public class OfficeTEXTTokenResolver implements IOfficeTokenResolver {
	
	private OfficeDefaultTokenResolver defaultResolver = new OfficeDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, IOfficeTokenResolveResult result) {
		defaultResolver.resolve(lexem, feature, result);
	}

	public void setOptions(Map<?, ?> options) {
	}
}
