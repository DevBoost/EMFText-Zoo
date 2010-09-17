/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.formsembedded.resource.formsembedded.analysis;

public class ItemDependentOfReferenceResolver implements org.emftext.language.formsembedded.resource.formsembedded.IFormsembeddedReferenceResolver<org.emftext.language.forms.Item, org.emftext.language.forms.Option> {
	
	private org.emftext.language.forms.resource.forms.analysis.ItemDependentOfReferenceResolver delegate = new org.emftext.language.forms.resource.forms.analysis.ItemDependentOfReferenceResolver();
	
	public void resolve(String identifier, org.emftext.language.forms.Item container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.formsembedded.resource.formsembedded.IFormsembeddedReferenceResolveResult<org.emftext.language.forms.Option> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, new org.emftext.language.forms.resource.forms.IFormsReferenceResolveResult<org.emftext.language.forms.Option>() {
			
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
			
			public java.util.Collection<org.emftext.language.forms.resource.forms.IFormsReferenceMapping<org.emftext.language.forms.Option>> getMappings() {
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
			
			public void addMapping(String identifier, org.emftext.language.forms.Option target) {
				result.addMapping(identifier, target);
			}
			
			public void addMapping(String identifier, org.emftext.language.forms.Option target, String warning) {
				result.addMapping(identifier, target, warning);
			}
		});
		
	}
	
	public String deResolve(org.emftext.language.forms.Option element, org.emftext.language.forms.Item container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
