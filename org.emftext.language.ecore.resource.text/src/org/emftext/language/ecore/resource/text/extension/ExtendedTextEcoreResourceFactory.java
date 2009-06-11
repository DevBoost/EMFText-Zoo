package org.emftext.language.ecore.resource.text.extension;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.ecore.resource.text.TextEcoreResourceFactory;

public class ExtendedTextEcoreResourceFactory extends TextEcoreResourceFactory {
	
	public Resource createResource(URI uri) {
		return new ExtendedTextEcoreResource(uri);
	}

}
