/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.java.sqljava.resource.sqljava.analysis;

import org.emftext.language.sql.resource.sql.ISqlTokenResolveResult;

public class SqlQUOTED_39_39TokenResolver implements org.emftext.language.java.sqljava.resource.sqljava.ISqljavaTokenResolver {
	
	private org.emftext.language.sql.resource.sql.analysis.SqlQUOTED_39_39TokenResolver importedResolver = new org.emftext.language.sql.resource.sql.analysis.SqlQUOTED_39_39TokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = importedResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, final org.emftext.language.java.sqljava.resource.sqljava.ISqljavaTokenResolveResult result) {
		importedResolver.resolve(lexem, feature, new ISqlTokenResolveResult() {
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
