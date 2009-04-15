package org.emftext.language.owl.resource.owl.analysis;

public class OwlIRITokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	
	@Override	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = super.deResolve(value, feature, container);
		if (result.indexOf("://") != -1) {
			result = "<" + result + ">";
		}
		return result;
	}
	
	@Override	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.runtime.resource.ITokenResolveResult result) {
		if (lexem.startsWith("<") && lexem.endsWith(">")) {
			lexem = lexem.substring(1, lexem.length()-1);
		}
		super.resolve(lexem, feature, result);
	}
}
