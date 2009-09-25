package org.emftext.language.java.javabehavior4uml.resource.javabehavior.analysis;

public class JavaSTRING_LITERALTokenResolver implements org.emftext.language.java.javabehavior4uml.resource.javabehavior.IJavabehaviorTokenResolver {
	
	private org.emftext.language.java.resource.java.analysis.JavaSTRING_LITERALTokenResolver importedResolver = new org.emftext.language.java.resource.java.analysis.JavaSTRING_LITERALTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = importedResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, final org.emftext.language.java.javabehavior4uml.resource.javabehavior.IJavabehaviorTokenResolveResult result) {
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
