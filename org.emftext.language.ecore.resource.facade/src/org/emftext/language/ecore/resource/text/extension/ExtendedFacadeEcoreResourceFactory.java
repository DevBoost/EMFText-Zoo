package org.emftext.language.ecore.resource.text.extension;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.ecore.resource.facade.FacadeEcoreResourceFactory;

public class ExtendedFacadeEcoreResourceFactory extends FacadeEcoreResourceFactory {

	public Resource createResource(URI uri) {
		return new ExtendedFacadeEcoreResource(uri);
	}
	
}
