package org.emftext.language.java_templates.resource.java_template.analysis;

public class JavaOCTAL_INTEGER_LITERALTokenResolver implements org.emftext.language.java_templates.resource.java_template.IJava_templateTokenResolver {
	
	private org.emftext.language.java.resource.java.analysis.JavaOCTAL_INTEGER_LITERALTokenResolver importedResolver = new org.emftext.language.java.resource.java.analysis.JavaOCTAL_INTEGER_LITERALTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = importedResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, final org.emftext.language.java_templates.resource.java_template.IJava_templateTokenResolveResult result) {
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
