package org.emftext.language.uml_class.resource.uml_class.mopp;

// An implementation of the ResolveResult interface that delegates
// all method calls to another ResolveResult. Client may subclass
// this class to easily create custom ResolveResults.
//
// @param <ReferenceType> the type of the references that can be contained in this result
//
public class Uml_classDelegatingResolveResult<ReferenceType> implements org.emftext.language.uml_class.resource.uml_class.IUml_classReferenceResolveResult<ReferenceType> {
	
	private org.emftext.language.uml_class.resource.uml_class.IUml_classReferenceResolveResult<ReferenceType> delegate;
	
	public Uml_classDelegatingResolveResult(org.emftext.language.uml_class.resource.uml_class.IUml_classReferenceResolveResult<ReferenceType> delegate) {
		this.delegate = delegate;
	}
	
	public String getErrorMessage() {
		return delegate.getErrorMessage();
	}
	
	public java.util.Collection<org.emftext.language.uml_class.resource.uml_class.IUml_classReferenceMapping<ReferenceType>> getMappings() {
		return delegate.getMappings();
	}
	
	public boolean wasResolved() {
		return delegate.wasResolved();
	}
	
	public boolean wasResolvedMultiple() {
		return delegate.wasResolvedMultiple();
	}
	
	public boolean wasResolvedUniquely() {
		return delegate.wasResolvedUniquely();
	}
	
	public void setErrorMessage(String message) {
		delegate.setErrorMessage(message);
	}
	
	public void addMapping(String identifier, ReferenceType target) {
		delegate.addMapping(identifier, target);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		delegate.addMapping(identifier, uri);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		delegate.addMapping(identifier, target, warning);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		delegate.addMapping(identifier, uri, warning);
	}
}
