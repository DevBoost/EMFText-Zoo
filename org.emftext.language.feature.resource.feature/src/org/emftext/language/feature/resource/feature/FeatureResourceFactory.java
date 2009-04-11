package org.emftext.language.feature.resource.feature;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class FeatureResourceFactory implements Resource.Factory {
	
	public FeatureResourceFactory() {
		super();
	}
	
	public Resource createResource(URI uri) {
		return new FeatureResource(uri);
	}
}
