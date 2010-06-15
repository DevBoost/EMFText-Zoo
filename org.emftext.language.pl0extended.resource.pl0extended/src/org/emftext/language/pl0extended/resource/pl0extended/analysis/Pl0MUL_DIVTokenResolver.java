/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0extended.resource.pl0extended.analysis;

public class Pl0MUL_DIVTokenResolver implements org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedTokenResolver {
	
	private org.emftext.language.pl0.resource.pl0.analysis.Pl0MUL_DIVTokenResolver importedResolver = new org.emftext.language.pl0.resource.pl0.analysis.Pl0MUL_DIVTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = importedResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, final org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedTokenResolveResult result) {
		importedResolver.resolve(lexem, feature, new org.emftext.language.pl0.resource.pl0.IPl0TokenResolveResult() {
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
