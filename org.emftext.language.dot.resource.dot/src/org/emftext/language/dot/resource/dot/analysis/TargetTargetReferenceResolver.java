/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.dot.resource.dot.analysis;

public class TargetTargetReferenceResolver implements org.emftext.language.dot.resource.dot.IDotReferenceResolver<org.emftext.language.dot.Target, org.emftext.language.dot.Connectable> {
	
	private org.emftext.language.dot.resource.dot.analysis.DotDefaultResolverDelegate<org.emftext.language.dot.Target, org.emftext.language.dot.Connectable> delegate = new org.emftext.language.dot.resource.dot.analysis.DotDefaultResolverDelegate<org.emftext.language.dot.Target, org.emftext.language.dot.Connectable>();
	
	public void resolve(String identifier, org.emftext.language.dot.Target container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.dot.resource.dot.IDotReferenceResolveResult<org.emftext.language.dot.Connectable> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.dot.Connectable element, org.emftext.language.dot.Target container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
