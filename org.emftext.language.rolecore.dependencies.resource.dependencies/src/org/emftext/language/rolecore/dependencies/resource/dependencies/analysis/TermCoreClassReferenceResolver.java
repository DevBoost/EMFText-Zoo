/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.rolecore.dependencies.resource.dependencies.analysis;

public class TermCoreClassReferenceResolver implements org.emftext.language.rolecore.dependencies.resource.dependencies.IDependenciesReferenceResolver<org.emftext.language.rolecore.dependencies.Term, org.emftext.language.rolecore.dependencies.CoreClass> {
	
	private org.emftext.language.rolecore.dependencies.resource.dependencies.analysis.DependenciesDefaultResolverDelegate<org.emftext.language.rolecore.dependencies.Term, org.emftext.language.rolecore.dependencies.CoreClass> delegate = new org.emftext.language.rolecore.dependencies.resource.dependencies.analysis.DependenciesDefaultResolverDelegate<org.emftext.language.rolecore.dependencies.Term, org.emftext.language.rolecore.dependencies.CoreClass>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.rolecore.dependencies.Term container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.rolecore.dependencies.resource.dependencies.IDependenciesReferenceResolveResult<org.emftext.language.rolecore.dependencies.CoreClass> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.rolecore.dependencies.CoreClass element, org.emftext.language.rolecore.dependencies.Term container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
