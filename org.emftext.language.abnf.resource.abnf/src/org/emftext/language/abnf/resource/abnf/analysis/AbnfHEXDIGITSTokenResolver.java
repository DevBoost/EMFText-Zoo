
package org.emftext.language.abnf.resource.abnf.analysis;

public class AbnfHEXDIGITSTokenResolver implements org.emftext.language.abnf.resource.abnf.IAbnfTokenResolver {
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert value instanceof Integer;
		Integer integerObject = (Integer) value;
		return Integer.toHexString(integerObject);
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.abnf.resource.abnf.IAbnfTokenResolveResult result) {
		int value = Integer.parseInt(lexem, 16);
		result.setResolvedToken(value);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
	}
}
