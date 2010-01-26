package org.emftext.language.java;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.resource.impl.URIMappingRegistryImpl;

public class JavaURIConverter extends ExtensibleURIConverterImpl {

	private URIMap parentMap = null;
	
	public void setParentMap(URIMap parentMap) {
		this.parentMap = parentMap;
	}

	protected URIMap getInternalURIMap() {
		if (uriMap == null)	{
			URIMappingRegistryImpl mappingRegistryImpl = new URIMappingRegistryImpl() {
				
				private static final long serialVersionUID = 1L;

				@Override
				protected URI delegatedGetURI(URI uri) {
					if (parentMap != null) {
						URI mappedUri = parentMap.getURI(uri);
						if (! uri.equals(mappedUri)) {
							// System.out.println("Mapped " + uri + " to " + mappedUri + " by " + JavaURIConverter.this);
						}
						return mappedUri;
					}
					return URIMappingRegistryImpl.INSTANCE.getURI(uri);
				}
			};
			uriMap = (URIMap)mappingRegistryImpl.map();
		}
		return uriMap;
	}

}
