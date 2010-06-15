/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0extended.resource.pl0extended.analysis;

public class AssignmentLeftReferenceResolver implements org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedReferenceResolver<org.emftext.language.pl0.Assignment, org.emftext.language.pl0.VarDeclaration> {
	
	private org.emftext.language.pl0.resource.pl0.analysis.AssignmentLeftReferenceResolver delegate = new org.emftext.language.pl0.resource.pl0.analysis.AssignmentLeftReferenceResolver();
	
	public void resolve(java.lang.String identifier, org.emftext.language.pl0.Assignment container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedReferenceResolveResult<org.emftext.language.pl0.VarDeclaration> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, new org.emftext.language.pl0.resource.pl0.IPl0ReferenceResolveResult<org.emftext.language.pl0.VarDeclaration>() {
			
			public boolean wasResolvedUniquely() {
				return result.wasResolvedUniquely();
			}
			
			public boolean wasResolvedMultiple() {
				return result.wasResolvedMultiple();
			}
			
			public boolean wasResolved() {
				return result.wasResolved();
			}
			
			public void setErrorMessage(String message) {
				result.setErrorMessage(message);
			}
			
			public java.util.Collection<org.emftext.language.pl0.resource.pl0.IPl0ReferenceMapping<org.emftext.language.pl0.VarDeclaration>> getMappings() {
				throw new UnsupportedOperationException();
			}
			
			public String getErrorMessage() {
				return result.getErrorMessage();
			}
			
			public void addMapping(String identifier, org.eclipse.emf.common.util.URI newIdentifier) {
				result.addMapping(identifier, newIdentifier);
			}
			
			public void addMapping(String identifier, org.eclipse.emf.common.util.URI newIdentifier, String warning) {
				result.addMapping(identifier, newIdentifier, warning);
			}
			
			public void addMapping(String identifier, org.emftext.language.pl0.VarDeclaration target) {
				result.addMapping(identifier, target);
			}
			
			public void addMapping(String identifier, org.emftext.language.pl0.VarDeclaration target, String warning) {
				result.addMapping(identifier, target, warning);
			}
		});
		
	}
	
	public java.lang.String deResolve(org.emftext.language.pl0.VarDeclaration element, org.emftext.language.pl0.Assignment container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
