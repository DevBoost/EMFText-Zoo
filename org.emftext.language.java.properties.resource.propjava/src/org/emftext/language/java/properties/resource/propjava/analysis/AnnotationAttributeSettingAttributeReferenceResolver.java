package org.emftext.language.java.properties.resource.propjava.analysis;

public class AnnotationAttributeSettingAttributeReferenceResolver implements org.emftext.language.java.properties.resource.propjava.IPropjavaReferenceResolver<org.emftext.language.java.annotations.AnnotationAttributeSetting, org.emftext.language.java.members.InterfaceMethod> {
	
	private org.emftext.language.java.resource.java.analysis.AnnotationAttributeSettingAttributeReferenceResolver delegate = new org.emftext.language.java.resource.java.analysis.AnnotationAttributeSettingAttributeReferenceResolver();
	
	public void resolve(java.lang.String identifier, org.emftext.language.java.annotations.AnnotationAttributeSetting container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.java.properties.resource.propjava.IPropjavaReferenceResolveResult<org.emftext.language.java.members.InterfaceMethod> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, new org.emftext.language.java.resource.java.IJavaReferenceResolveResult<org.emftext.language.java.members.InterfaceMethod>() {
			
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
			
			public java.util.Collection<org.emftext.language.java.resource.java.IJavaReferenceMapping<org.emftext.language.java.members.InterfaceMethod>> getMappings() {
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
			
			public void addMapping(String identifier, org.emftext.language.java.members.InterfaceMethod target) {
				result.addMapping(identifier, target);
			}
			
			public void addMapping(String identifier, org.emftext.language.java.members.InterfaceMethod target, String warning) {
				result.addMapping(identifier, target, warning);
			}
		});
		
	}
	
	public java.lang.String deResolve(org.emftext.language.java.members.InterfaceMethod element, org.emftext.language.java.annotations.AnnotationAttributeSetting container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
