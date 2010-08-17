/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.eag.resource.eag.analysis;

public class AttributeValueTargetAttributeReferenceResolver implements org.emftext.language.eag.resource.eag.IEagReferenceResolver<org.emftext.language.eag.AttributeValue, org.emftext.language.eag.Attribute> {
	
	private org.emftext.language.eag.resource.eag.analysis.EagDefaultResolverDelegate<org.emftext.language.eag.AttributeValue, org.emftext.language.eag.Attribute> delegate = new org.emftext.language.eag.resource.eag.analysis.EagDefaultResolverDelegate<org.emftext.language.eag.AttributeValue, org.emftext.language.eag.Attribute>();
	
	public void resolve(String identifier, org.emftext.language.eag.AttributeValue container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.eag.resource.eag.IEagReferenceResolveResult<org.emftext.language.eag.Attribute> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.eag.Attribute element, org.emftext.language.eag.AttributeValue container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
