package org.emftext.language.java.treejava.resource.treejava.analysis;

public class JavaCOLLECT_commentsTokenResolver implements org.emftext.language.java.treejava.resource.treejava.ITreejavaTokenResolver {
	
	private org.emftext.language.java.resource.java.analysis.JavaCOLLECT_commentsTokenResolver importedResolver = new org.emftext.language.java.resource.java.analysis.JavaCOLLECT_commentsTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = importedResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, final org.emftext.language.java.treejava.resource.treejava.ITreejavaTokenResolveResult result) {
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
