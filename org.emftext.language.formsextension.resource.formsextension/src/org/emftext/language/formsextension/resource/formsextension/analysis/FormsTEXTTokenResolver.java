/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.formsextension.resource.formsextension.analysis;

public class FormsTEXTTokenResolver implements org.emftext.language.formsextension.resource.formsextension.IFormsextensionTokenResolver {
	
	private org.emftext.language.forms.resource.forms.analysis.FormsTEXTTokenResolver importedResolver = new org.emftext.language.forms.resource.forms.analysis.FormsTEXTTokenResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String result = importedResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, final org.emftext.language.formsextension.resource.formsextension.IFormsextensionTokenResolveResult result) {
		importedResolver.resolve(lexem, feature, new org.emftext.language.forms.resource.forms.IFormsTokenResolveResult() {
			public String getErrorMessage() {
				return result.getErrorMessage();
			}
			
			public Object getResolvedToken() {
				return result.getResolvedToken();
			}
			
			public void setErrorMessage(String message) {
				result.setErrorMessage(message);
			}
			
			public void setResolvedToken(Object resolvedToken) {
				result.setResolvedToken(resolvedToken);
			}
			
		});
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		importedResolver.setOptions(options);
	}
	
}
