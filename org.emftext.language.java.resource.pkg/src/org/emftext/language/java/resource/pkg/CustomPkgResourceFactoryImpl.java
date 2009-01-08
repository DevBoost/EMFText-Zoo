package org.emftext.language.java.resource.pkg;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
public class CustomPkgResourceFactoryImpl implements Resource.Factory {


	public CustomPkgResourceFactoryImpl() {
		super();
	}

	public Resource createResource(URI uri) {
		return new CustomPkgResourceImpl(uri);
	}
}
