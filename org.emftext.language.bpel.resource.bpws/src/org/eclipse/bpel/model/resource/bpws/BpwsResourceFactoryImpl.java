package org.eclipse.bpel.model.resource.bpws;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
public class BpwsResourceFactoryImpl implements Resource.Factory {


	public BpwsResourceFactoryImpl(){
		super();
	}

	public Resource createResource(URI uri){
		return new BpwsResourceImpl(uri);
	}
}
