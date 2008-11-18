package org.featuremapper.models.feature.resource.feature;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
public class FeatureResourceFactoryImpl implements Resource.Factory {


	public FeatureResourceFactoryImpl(){
		super();
	}

	public Resource createResource(URI uri){
		return new FeatureResourceImpl(uri);
	}
}
