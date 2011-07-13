
package org.emftext.language.simpleweave.resource.simpleweave.analysis;

public class SimpleweaveQUOTED_60_62TokenResolver implements org.emftext.language.simpleweave.resource.simpleweave.ISimpleweaveTokenResolver {
	
	private org.emftext.language.simpleweave.resource.simpleweave.analysis.SimpleweaveDefaultTokenResolver defaultTokenResolver = new org.emftext.language.simpleweave.resource.simpleweave.analysis.SimpleweaveDefaultTokenResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String result = defaultTokenResolver.deResolve(value, feature, container);
		result += ">";
		result = "<" + result;
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.simpleweave.resource.simpleweave.ISimpleweaveTokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
