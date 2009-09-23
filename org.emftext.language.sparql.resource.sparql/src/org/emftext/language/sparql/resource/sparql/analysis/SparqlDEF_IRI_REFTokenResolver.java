package org.emftext.language.sparql.resource.sparql.analysis;

import org.emftext.language.sparql.resource.sparql.ISparqlTokenResolveResult;
import org.emftext.language.sparql.resource.sparql.ISparqlTokenResolver;

public class SparqlDEF_IRI_REFTokenResolver implements ISparqlTokenResolver {
	
	private SparqlDefaultTokenResolver defaultTokenResolver = new SparqlDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, ISparqlTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
