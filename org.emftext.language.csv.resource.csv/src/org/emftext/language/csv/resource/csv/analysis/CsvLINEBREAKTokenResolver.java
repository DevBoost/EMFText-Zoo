package org.emftext.language.csv.resource.csv.analysis;

public class CsvLINEBREAKTokenResolver implements org.emftext.language.csv.resource.csv.ICsvTokenResolver {
	
	private org.emftext.language.csv.resource.csv.analysis.CsvDefaultTokenResolver defaultTokenResolver = new org.emftext.language.csv.resource.csv.analysis.CsvDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.csv.resource.csv.ICsvTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
