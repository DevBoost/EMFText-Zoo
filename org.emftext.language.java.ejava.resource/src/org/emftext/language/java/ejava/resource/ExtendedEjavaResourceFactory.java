package org.emftext.language.java.ejava.resource;

public class ExtendedEjavaResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public ExtendedEjavaResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new org.emftext.language.java.ejava.resource.ExtendedEjavaResource(uri);
	}
}
