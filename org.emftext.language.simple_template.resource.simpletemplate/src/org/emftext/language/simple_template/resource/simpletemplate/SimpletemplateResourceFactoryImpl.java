package org.emftext.language.simple_template.resource.simpletemplate;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
public class SimpletemplateResourceFactoryImpl implements Resource.Factory {


	public SimpletemplateResourceFactoryImpl(){
		super();
	}

	public Resource createResource(URI uri){
		return new SimpletemplateResourceImpl(uri);
	}
}
