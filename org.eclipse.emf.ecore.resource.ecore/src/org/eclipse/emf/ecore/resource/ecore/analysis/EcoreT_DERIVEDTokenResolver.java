package org.eclipse.emf.ecore.resource.ecore.analysis;

public class EcoreT_DERIVEDTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	
	@Override	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = super.deResolve(value, feature, container);
		return result;
	}
	
	@Override	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.runtime.resource.ITokenResolveResult result) {
		if ("derived".equalsIgnoreCase(lexem)) {
			result.setResolvedToken(true);
		} else {
			result.setResolvedToken(false);
		}
	}
}
