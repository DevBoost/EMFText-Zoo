
package org.emftext.language.database.tgg_rule.resource.database.tgg_rule.analysis;

public class Database_tgg_ruleTEXTTokenResolver implements org.emftext.language.database.tgg_rule.resource.database.tgg_rule.IDatabase_tgg_ruleTokenResolver {
	
	private org.emftext.language.database.tgg_rule.resource.database.tgg_rule.analysis.Database_tgg_ruleDefaultTokenResolver defaultTokenResolver = new org.emftext.language.database.tgg_rule.resource.database.tgg_rule.analysis.Database_tgg_ruleDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.database.tgg_rule.resource.database.tgg_rule.IDatabase_tgg_ruleTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
