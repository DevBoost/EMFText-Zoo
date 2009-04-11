package org.emftext.language.statemachine.resource.statemachine;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class StatemachineResourceFactory implements Resource.Factory {
	
	public StatemachineResourceFactory() {
		super();
	}
	
	public Resource createResource(URI uri) {
		return new StatemachineResource(uri);
	}
}
