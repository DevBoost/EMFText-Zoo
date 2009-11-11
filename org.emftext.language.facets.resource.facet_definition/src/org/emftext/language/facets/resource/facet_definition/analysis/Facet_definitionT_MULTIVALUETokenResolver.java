package org.emftext.language.facets.resource.facet_definition.analysis;

public class Facet_definitionT_MULTIVALUETokenResolver implements org.emftext.language.facets.resource.facet_definition.IFacet_definitionTokenResolver {
	
	private static final String MULTI = "multi";
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		if (Boolean.TRUE.equals(value)) {
			return MULTI;
		} else {
			return "";
		}
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.facets.resource.facet_definition.IFacet_definitionTokenResolveResult result) {
		if (MULTI.equals(lexem)) {
			result.setResolvedToken(Boolean.TRUE);
		} else {
			result.setResolvedToken(Boolean.FALSE);
		}
	}
	
	public void setOptions(java.util.Map<?,?> options) {
	}
}
