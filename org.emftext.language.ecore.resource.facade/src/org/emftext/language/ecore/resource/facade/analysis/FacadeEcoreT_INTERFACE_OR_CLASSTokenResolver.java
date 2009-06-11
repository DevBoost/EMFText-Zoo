package org.emftext.language.ecore.resource.facade.analysis;

public class FacadeEcoreT_INTERFACE_OR_CLASSTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	
	@Override
	public java.lang.String deResolve(java.lang.Object value,
			org.eclipse.emf.ecore.EStructuralFeature feature,
			org.eclipse.emf.ecore.EObject container) {
		if ((Boolean) value) {
			return "interface";
		} else {
			return "class";
		}
	}

	@Override
	public void resolve(java.lang.String lexem,
			org.eclipse.emf.ecore.EStructuralFeature feature,
			org.emftext.runtime.resource.ITokenResolveResult result) {
		if (feature.getName().equalsIgnoreCase(lexem)) {
			result.setResolvedToken(true);
		} else {
			result.setResolvedToken(false);
		}
	}
}
