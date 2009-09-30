package org.emftext.language.uml_class.resource.uml_class.mopp;

public class Uml_classResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public Uml_classResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classResource(uri);
	}
}
