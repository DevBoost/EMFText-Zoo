package org.eclipse.uml2.uml.resource.statemachine;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
public class StatemachineResourceFactoryImpl implements Resource.Factory {


	public StatemachineResourceFactoryImpl(){
		super();
	}

	public Resource createResource(URI uri){
		return new StatemachineResourceImpl(uri);
	}
}
