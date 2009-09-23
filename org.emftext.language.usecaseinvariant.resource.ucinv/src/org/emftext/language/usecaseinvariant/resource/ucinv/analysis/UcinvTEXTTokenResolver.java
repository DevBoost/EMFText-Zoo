package org.emftext.language.usecaseinvariant.resource.ucinv.analysis;

import java.util.Map;

import org.emftext.language.usecaseinvariant.resource.ucinv.IUcinvTokenResolveResult;
import org.emftext.language.usecaseinvariant.resource.ucinv.IUcinvTokenResolver;

public class UcinvTEXTTokenResolver implements IUcinvTokenResolver {
	
	private UcinvDefaultTokenResolver defaultResolver = new UcinvDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, IUcinvTokenResolveResult result) {
		defaultResolver.resolve(lexem, feature, result);
	}

	public void setOptions(Map<?, ?> options) {
		defaultResolver.setOptions(options);
	}
}
