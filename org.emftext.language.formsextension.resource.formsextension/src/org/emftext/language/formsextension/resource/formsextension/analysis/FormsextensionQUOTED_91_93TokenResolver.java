
package org.emftext.language.formsextension.resource.formsextension.analysis;

public class FormsextensionQUOTED_91_93TokenResolver implements org.emftext.language.formsextension.resource.formsextension.IFormsextensionTokenResolver {
	
	private org.emftext.language.formsextension.resource.formsextension.analysis.FormsextensionDefaultTokenResolver defaultTokenResolver = new org.emftext.language.formsextension.resource.formsextension.analysis.FormsextensionDefaultTokenResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String result = defaultTokenResolver.deResolve(value, feature, container);
		result += "]";
		result = "[" + result;
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.formsextension.resource.formsextension.IFormsextensionTokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
