package org.emftext.language.java.resource.java;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
public class JavaResourceFactoryImpl implements Resource.Factory {


	public JavaResourceFactoryImpl(){
		super();
	}

	public Resource createResource(URI uri){
		return new JavaResourceImpl(uri);
	}
}
