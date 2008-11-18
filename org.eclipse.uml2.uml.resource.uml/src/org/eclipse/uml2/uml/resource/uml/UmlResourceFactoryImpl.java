package org.eclipse.uml2.uml.resource.uml;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
public class UmlResourceFactoryImpl implements Resource.Factory {


	public UmlResourceFactoryImpl(){
		super();
	}

	public Resource createResource(URI uri){
		return new UmlResourceImpl(uri);
	}
}
