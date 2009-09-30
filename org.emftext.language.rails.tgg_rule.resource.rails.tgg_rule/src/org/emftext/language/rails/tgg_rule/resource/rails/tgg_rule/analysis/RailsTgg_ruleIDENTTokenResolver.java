package org.emftext.language.rails.tgg_rule.resource.rails.tgg_rule.analysis;

public class RailsTgg_ruleIDENTTokenResolver implements org.emftext.language.rails.tgg_rule.resource.rails.tgg_rule.IRailsTgg_ruleTokenResolver {
	
	private org.emftext.language.rails.tgg_rule.resource.rails.tgg_rule.analysis.RailsTgg_ruleDefaultTokenResolver defaultTokenResolver = new org.emftext.language.rails.tgg_rule.resource.rails.tgg_rule.analysis.RailsTgg_ruleDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.rails.tgg_rule.resource.rails.tgg_rule.IRailsTgg_ruleTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
