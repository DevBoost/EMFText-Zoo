package org.emftext.language.facets.resource.facet_classification.analysis;

public class Facet_classificationQUOTED_34_34TokenResolver implements org.emftext.language.facets.resource.facet_classification.IFacet_classificationTokenResolver {
	
	private org.emftext.language.facets.resource.facet_classification.analysis.Facet_classificationDefaultTokenResolver defaultTokenResolver = new org.emftext.language.facets.resource.facet_classification.analysis.Facet_classificationDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		result += "\"";
		result = "\"" + result;
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.facets.resource.facet_classification.IFacet_classificationTokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
