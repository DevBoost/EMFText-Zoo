package org.eclipse.emf.ecore.resource.ecore.customized;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class CustomizedEcoreResourceFactory implements Resource.Factory {
	
	public CustomizedEcoreResourceFactory() {
		super();
	}
	
	public Resource createResource(URI uri) {
		return new CustomizedEcoreResource(uri);
	}
}
