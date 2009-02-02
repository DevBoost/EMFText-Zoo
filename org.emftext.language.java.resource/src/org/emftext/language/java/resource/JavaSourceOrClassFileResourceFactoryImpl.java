package org.emftext.language.java.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;


public class JavaSourceOrClassFileResourceFactoryImpl implements Resource.Factory {

	public JavaSourceOrClassFileResourceFactoryImpl() {
	}


	public Resource createResource(URI uri){
		return new JavaSourceOrClassFileResource(uri);
	}
}
