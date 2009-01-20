package org.emftext.language.java.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.emftext.language.java.JavaUniquePathConstructor;


public class JavaSourceOrClassFileResourceFactoryImpl implements Resource.Factory {

	protected URIConverter myURIConverter = 
		new ExtensibleURIConverterImpl();

	public JavaSourceOrClassFileResourceFactoryImpl() {
	}


	public Resource createResource(URI uri){
		//is there a physical source file behind this URI?
		URI normalizedURI = myURIConverter.normalize(uri);

		if("pathmap".equals(normalizedURI.scheme())) {
			//there is no physical resource
			if(normalizedURI.toString().startsWith(JavaUniquePathConstructor.JAVA_PACKAGE_PATHMAP)) {
				//JavaSourceFileResource can handle packages without physical resource
				return new JavaSourceFileResourceImpl(uri);
			}
			if(normalizedURI.toString().startsWith(JavaUniquePathConstructor.JAVA_PACKAGE_PATHMAP)) {
				//classes should have a physical resource
				System.out.println("[JaMoPP] Warning: " + uri.lastSegment() + " not registered in class path");
				return new JavaSourceFileResourceImpl(uri);
			}
		}
		
		if(normalizedURI.fileExtension().equals("java")) {
			return new JavaSourceFileResourceImpl(uri);
		}
		if(normalizedURI.fileExtension().equals("class"))  {
			return new JavaClassFileResorceImpl(uri);
		}
		
		//if this happens the factory is not registered correctly
		throw new UnsupportedOperationException();
	}
}
