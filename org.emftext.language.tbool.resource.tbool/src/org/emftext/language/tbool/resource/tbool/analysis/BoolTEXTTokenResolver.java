package org.emftext.language.tbool.resource.tbool.analysis;

public class BoolTEXTTokenResolver implements org.emftext.language.tbool.resource.tbool.ITboolTokenResolver {
	
	private org.emftext.language.bool.resource.bool.analysis.BoolTEXTTokenResolver importedResolver = new org.emftext.language.bool.resource.bool.analysis.BoolTEXTTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = importedResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, final org.emftext.language.tbool.resource.tbool.ITboolTokenResolveResult result) {
		importedResolver.resolve(lexem, feature, new org.emftext.language.bool.resource.bool.IBoolTokenResolveResult() {
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
