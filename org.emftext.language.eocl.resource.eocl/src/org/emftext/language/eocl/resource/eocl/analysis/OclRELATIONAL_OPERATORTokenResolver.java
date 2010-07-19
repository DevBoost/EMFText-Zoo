/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.eocl.resource.eocl.analysis;

public class OclRELATIONAL_OPERATORTokenResolver implements org.emftext.language.eocl.resource.eocl.IEoclTokenResolver {
	
	private tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis.OclRELATIONAL_OPERATORTokenResolver importedResolver = new tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis.OclRELATIONAL_OPERATORTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = importedResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, final org.emftext.language.eocl.resource.eocl.IEoclTokenResolveResult result) {
		importedResolver.resolve(lexem, feature, new tudresden.ocl20.pivot.language.ocl.resource.ocl.IOclTokenResolveResult() {
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
