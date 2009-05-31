package org.emftext.language.km3.resource.km3.analysis;

public class Km3CARDINALITYTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	
	@Override	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert value instanceof Integer;
		if (((Integer) value).intValue() < 0) {
			return "*";
		} else {
			java.lang.String result = super.deResolve(value, feature, container);
			return result;
		}
	}
	
	@Override	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.runtime.resource.ITokenResolveResult result) {
		if ("*".equals(lexem)) {
			result.setResolvedToken(new Integer(-1));
		} else {
			super.resolve(lexem, feature, result);
		}
	}
}
