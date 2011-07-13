
package org.emftext.language.abnf.resource.abnf.analysis;

public class RuleReferenceRuleReferenceResolver implements org.emftext.language.abnf.resource.abnf.IAbnfReferenceResolver<org.emftext.language.abnf.RuleReference, org.emftext.language.abnf.Rule> {
	
	private org.emftext.language.abnf.resource.abnf.analysis.AbnfDefaultResolverDelegate<org.emftext.language.abnf.RuleReference, org.emftext.language.abnf.Rule> delegate = new org.emftext.language.abnf.resource.abnf.analysis.AbnfDefaultResolverDelegate<org.emftext.language.abnf.RuleReference, org.emftext.language.abnf.Rule>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.abnf.RuleReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.abnf.resource.abnf.IAbnfReferenceResolveResult<org.emftext.language.abnf.Rule> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.abnf.Rule element, org.emftext.language.abnf.RuleReference container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
