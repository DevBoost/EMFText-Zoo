/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.formsembedded.resource.formsembedded.analysis;

public class JavaHEX_FLOAT_LITERALTokenResolver implements org.emftext.language.formsembedded.resource.formsembedded.IFormsembeddedTokenResolver {
	
	private org.emftext.language.java.resource.java.analysis.JavaHEX_FLOAT_LITERALTokenResolver importedResolver = new org.emftext.language.java.resource.java.analysis.JavaHEX_FLOAT_LITERALTokenResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String result = importedResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, final org.emftext.language.formsembedded.resource.formsembedded.IFormsembeddedTokenResolveResult result) {
		importedResolver.resolve(lexem, feature, new org.emftext.language.java.resource.java.IJavaTokenResolveResult() {
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
