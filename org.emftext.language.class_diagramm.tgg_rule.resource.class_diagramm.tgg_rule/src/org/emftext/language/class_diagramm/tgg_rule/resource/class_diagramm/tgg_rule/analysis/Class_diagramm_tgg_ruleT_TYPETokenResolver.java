
package org.emftext.language.class_diagramm.tgg_rule.resource.class_diagramm.tgg_rule.analysis;

import de.tudresden.tornado2.metamodel.tggRules.RuleElementType;

public class Class_diagramm_tgg_ruleT_TYPETokenResolver implements org.emftext.language.class_diagramm.tgg_rule.resource.class_diagramm.tgg_rule.IClass_diagramm_tgg_ruleTokenResolver {
	
	private org.emftext.language.class_diagramm.tgg_rule.resource.class_diagramm.tgg_rule.analysis.Class_diagramm_tgg_ruleDefaultTokenResolver defaultTokenResolver = new org.emftext.language.class_diagramm.tgg_rule.resource.class_diagramm.tgg_rule.analysis.Class_diagramm_tgg_ruleDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.class_diagramm.tgg_rule.resource.class_diagramm.tgg_rule.IClass_diagramm_tgg_ruleTokenResolveResult result) {
		if ("++".equals(lexem)) {
			result.setResolvedToken(RuleElementType.CREATE);
		}
		if ("!".equals(lexem)) {
			result.setResolvedToken(RuleElementType.REQUIRED);
		}
		if ("/".equals(lexem)) {
			result.setResolvedToken(RuleElementType.FORBIDDEN);
		}
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
