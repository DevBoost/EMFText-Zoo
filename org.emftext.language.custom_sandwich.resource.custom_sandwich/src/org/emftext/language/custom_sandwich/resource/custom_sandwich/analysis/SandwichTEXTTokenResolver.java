package org.emftext.language.custom_sandwich.resource.custom_sandwich.analysis;

public class SandwichTEXTTokenResolver implements org.emftext.language.custom_sandwich.resource.custom_sandwich.ICustom_sandwichTokenResolver {
	
	private org.emftext.language.sandwich.resource.sandwich.analysis.SandwichTEXTTokenResolver importedResolver = new org.emftext.language.sandwich.resource.sandwich.analysis.SandwichTEXTTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = importedResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, final org.emftext.language.custom_sandwich.resource.custom_sandwich.ICustom_sandwichTokenResolveResult result) {
		importedResolver.resolve(lexem, feature, new org.emftext.language.sandwich.resource.sandwich.ISandwichTokenResolveResult() {
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
