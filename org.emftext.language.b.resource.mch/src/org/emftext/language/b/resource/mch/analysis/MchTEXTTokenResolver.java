package org.emftext.language.b.resource.mch.analysis;

public class MchTEXTTokenResolver extends org.emftext.runtime.resource.impl.AbstractTokenResolver {
	
	private org.emftext.language.b.resource.mch.MchDefaultTokenResolver defaultTokenResolver = new org.emftext.language.b.resource.mch.MchDefaultTokenResolver();
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.runtime.resource.ITokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
