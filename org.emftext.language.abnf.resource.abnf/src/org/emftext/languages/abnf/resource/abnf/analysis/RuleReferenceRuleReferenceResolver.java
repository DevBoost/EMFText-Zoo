/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.languages.abnf.resource.abnf.analysis;

public class RuleReferenceRuleReferenceResolver implements org.emftext.languages.abnf.resource.abnf.IAbnfReferenceResolver<org.emftext.languages.abnf.RuleReference, org.emftext.languages.abnf.Rule> {
	
	private org.emftext.languages.abnf.resource.abnf.analysis.AbnfDefaultResolverDelegate<org.emftext.languages.abnf.RuleReference, org.emftext.languages.abnf.Rule> delegate = new org.emftext.languages.abnf.resource.abnf.analysis.AbnfDefaultResolverDelegate<org.emftext.languages.abnf.RuleReference, org.emftext.languages.abnf.Rule>();
	
	public void resolve(java.lang.String identifier, org.emftext.languages.abnf.RuleReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.languages.abnf.resource.abnf.IAbnfReferenceResolveResult<org.emftext.languages.abnf.Rule> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.languages.abnf.Rule element, org.emftext.languages.abnf.RuleReference container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
