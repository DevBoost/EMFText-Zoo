package org.emftext.language.ecore.resource.facade.analysis;

import org.eclipse.emf.common.notify.impl.AdapterImpl;

public class AnnotatedURI extends AdapterImpl {
	
	String uri;
	
	public AnnotatedURI(String uri) {
		this.uri = uri;
	}
	
	public String getUri() {
		return uri;
	}
}
