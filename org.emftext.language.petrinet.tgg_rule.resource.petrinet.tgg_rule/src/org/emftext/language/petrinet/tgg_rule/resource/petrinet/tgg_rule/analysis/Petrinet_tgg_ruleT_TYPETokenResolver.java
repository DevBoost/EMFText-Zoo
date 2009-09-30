package org.emftext.language.petrinet.tgg_rule.resource.petrinet.tgg_rule.analysis;

import de.tudresden.tornado2.metamodel.tggRules.RuleElementType;

public class Petrinet_tgg_ruleT_TYPETokenResolver implements org.emftext.language.petrinet.tgg_rule.resource.petrinet.tgg_rule.IPetrinet_tgg_ruleTokenResolver {
	
	private org.emftext.language.petrinet.tgg_rule.resource.petrinet.tgg_rule.analysis.Petrinet_tgg_ruleDefaultTokenResolver defaultTokenResolver = new org.emftext.language.petrinet.tgg_rule.resource.petrinet.tgg_rule.analysis.Petrinet_tgg_ruleDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.petrinet.tgg_rule.resource.petrinet.tgg_rule.IPetrinet_tgg_ruleTokenResolveResult result) {
		if ("++".equals(lexem)) {
			result.setResolvedToken(RuleElementType.CREATE);
		}
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
