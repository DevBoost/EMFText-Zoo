package org.emftext.language.java.javabehavior4uml.resource.javabehavior;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class JavabehaviorResourceFactory implements Resource.Factory {
	
	public JavabehaviorResourceFactory() {
		super();
	}
	
	public Resource createResource(URI uri) {
		return new JavabehaviorResource(uri);
	}
}
