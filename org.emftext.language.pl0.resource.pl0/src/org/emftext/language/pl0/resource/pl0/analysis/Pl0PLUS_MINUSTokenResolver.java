/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0.analysis;

import org.emftext.language.pl0.PlusMinusOperator;
import org.emftext.language.pl0.TermExpression;

public class Pl0PLUS_MINUSTokenResolver implements org.emftext.language.pl0.resource.pl0.IPl0TokenResolver {
	
	private org.emftext.language.pl0.resource.pl0.analysis.Pl0DefaultTokenResolver defaultTokenResolver = new org.emftext.language.pl0.resource.pl0.analysis.Pl0DefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
//		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		if(container instanceof TermExpression){
			if(value == PlusMinusOperator.PLUS){
				return "";
			} 
		}
		return defaultTokenResolver.deResolve(value, feature, container);
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.pl0.resource.pl0.IPl0TokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
