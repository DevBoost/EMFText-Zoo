package org.emftext.language.simple_c.resource.c;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
public class CResourceFactoryImpl implements Resource.Factory {


	public CResourceFactoryImpl(){
		super();
	}

	public Resource createResource(URI uri){
		return new CResourceImpl(uri);
	}
}
