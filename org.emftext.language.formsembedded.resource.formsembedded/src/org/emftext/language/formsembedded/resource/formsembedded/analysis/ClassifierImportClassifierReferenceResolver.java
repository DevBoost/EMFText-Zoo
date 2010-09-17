/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.formsembedded.resource.formsembedded.analysis;

public class ClassifierImportClassifierReferenceResolver implements org.emftext.language.formsembedded.resource.formsembedded.IFormsembeddedReferenceResolver<org.emftext.language.java.imports.ClassifierImport, org.emftext.language.java.classifiers.ConcreteClassifier> {
	
	private org.emftext.language.java.resource.java.analysis.ClassifierImportClassifierReferenceResolver delegate = new org.emftext.language.java.resource.java.analysis.ClassifierImportClassifierReferenceResolver();
	
	public void resolve(String identifier, org.emftext.language.java.imports.ClassifierImport container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.formsembedded.resource.formsembedded.IFormsembeddedReferenceResolveResult<org.emftext.language.java.classifiers.ConcreteClassifier> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, new org.emftext.language.java.resource.java.IJavaReferenceResolveResult<org.emftext.language.java.classifiers.ConcreteClassifier>() {
			
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
			
			public java.util.Collection<org.emftext.language.java.resource.java.IJavaReferenceMapping<org.emftext.language.java.classifiers.ConcreteClassifier>> getMappings() {
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
			
			public void addMapping(String identifier, org.emftext.language.java.classifiers.ConcreteClassifier target) {
				result.addMapping(identifier, target);
			}
			
			public void addMapping(String identifier, org.emftext.language.java.classifiers.ConcreteClassifier target, String warning) {
				result.addMapping(identifier, target, warning);
			}
		});
		
	}
	
	public String deResolve(org.emftext.language.java.classifiers.ConcreteClassifier element, org.emftext.language.java.imports.ClassifierImport container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
