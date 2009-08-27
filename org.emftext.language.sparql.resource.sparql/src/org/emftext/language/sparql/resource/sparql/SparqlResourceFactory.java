package org.emftext.language.sparql.resource.sparql;

public class SparqlResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public SparqlResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new org.emftext.language.sparql.resource.sparql.SparqlResource(uri);
	}
}
