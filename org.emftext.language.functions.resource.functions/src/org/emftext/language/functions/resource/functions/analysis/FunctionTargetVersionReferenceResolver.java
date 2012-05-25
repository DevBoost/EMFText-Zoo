/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.functions.resource.functions.analysis;

public class FunctionTargetVersionReferenceResolver implements org.emftext.language.functions.resource.functions.IFunctionsReferenceResolver<org.emftext.language.functions.Function, org.emftext.language.functions.TargetVersion> {
	
	private org.emftext.language.functions.resource.functions.analysis.FunctionsDefaultResolverDelegate<org.emftext.language.functions.Function, org.emftext.language.functions.TargetVersion> delegate = new org.emftext.language.functions.resource.functions.analysis.FunctionsDefaultResolverDelegate<org.emftext.language.functions.Function, org.emftext.language.functions.TargetVersion>();
	
	public void resolve(String identifier, org.emftext.language.functions.Function container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.functions.resource.functions.IFunctionsReferenceResolveResult<org.emftext.language.functions.TargetVersion> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.functions.TargetVersion element, org.emftext.language.functions.Function container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
