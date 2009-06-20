package org.emftext.language.filesystem.resource.physical;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class PhysicalFilesystemResourceFactory implements Resource.Factory {
	
	public PhysicalFilesystemResourceFactory() {
		super();
	}
	
	public Resource createResource(URI uri) {
		return new PhysicalFilesystemResource(uri);
	}
}
