package org.emftext.language.tbool.resource.tbool.analysis;

public class FieldTypeReferenceResolver implements org.emftext.language.tbool.resource.tbool.ITboolReferenceResolver<org.emftext.language.bool.Field, org.emftext.language.bool.FieldType> {
	
	private org.emftext.language.bool.resource.bool.analysis.FieldTypeReferenceResolver delegate = new org.emftext.language.bool.resource.bool.analysis.FieldTypeReferenceResolver();
	
	public void resolve(java.lang.String identifier, org.emftext.language.bool.Field container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.tbool.resource.tbool.ITboolReferenceResolveResult<org.emftext.language.bool.FieldType> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, new org.emftext.language.bool.resource.bool.IBoolReferenceResolveResult<org.emftext.language.bool.FieldType>() {
			
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
			
			public java.util.Collection<org.emftext.language.bool.resource.bool.IBoolReferenceMapping<org.emftext.language.bool.FieldType>> getMappings() {
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
			
			public void addMapping(String identifier, org.emftext.language.bool.FieldType target) {
				result.addMapping(identifier, target);
			}
			
			public void addMapping(String identifier, org.emftext.language.bool.FieldType target, String warning) {
				result.addMapping(identifier, target, warning);
			}
		});
		
	}
	
	public java.lang.String deResolve(org.emftext.language.bool.FieldType element, org.emftext.language.bool.Field container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
