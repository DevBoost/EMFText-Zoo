/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.javaforms.resource.javaforms.analysis;

public class JumpTargetReferenceResolver implements org.emftext.language.javaforms.resource.javaforms.IJavaformsReferenceResolver<org.emftext.language.java.statements.Jump, org.emftext.language.java.statements.JumpLabel> {
	
	private org.emftext.language.java.resource.java.analysis.JumpTargetReferenceResolver delegate = new org.emftext.language.java.resource.java.analysis.JumpTargetReferenceResolver();
	
	public void resolve(String identifier, org.emftext.language.java.statements.Jump container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.javaforms.resource.javaforms.IJavaformsReferenceResolveResult<org.emftext.language.java.statements.JumpLabel> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, new org.emftext.language.java.resource.java.IJavaReferenceResolveResult<org.emftext.language.java.statements.JumpLabel>() {
			
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
			
			public java.util.Collection<org.emftext.language.java.resource.java.IJavaReferenceMapping<org.emftext.language.java.statements.JumpLabel>> getMappings() {
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
			
			public void addMapping(String identifier, org.emftext.language.java.statements.JumpLabel target) {
				result.addMapping(identifier, target);
			}
			
			public void addMapping(String identifier, org.emftext.language.java.statements.JumpLabel target, String warning) {
				result.addMapping(identifier, target, warning);
			}
		});
		
	}
	
	public String deResolve(org.emftext.language.java.statements.JumpLabel element, org.emftext.language.java.statements.Jump container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
