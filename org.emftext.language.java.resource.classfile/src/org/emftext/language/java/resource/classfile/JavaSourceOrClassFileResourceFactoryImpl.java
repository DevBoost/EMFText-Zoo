package org.emftext.language.java.resource.classfile;

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
		//package
		if (uri.toString().startsWith(JavaUniquePathConstructor.JAVA_PACKAGE_PATHMAP)) {
			return new JavaPackageResourceImpl(uri);
		}
		//file
		else {
			//is there a physical source file behind this URI?
			URI normalizedURI = myURIConverter.normalize(uri);

			if("pathmap".equals(normalizedURI.scheme())) {
				//something wrong
				System.out.println("[JaMoPP] Warning: " + uri + " not registered in ClassPath");
				return new JavaSourceFileResourceImpl(uri);
			}
			
			if(normalizedURI.fileExtension().equals("java")) {
				return new JavaSourceFileResourceImpl(uri);
			}
			if(normalizedURI.fileExtension().equals("class"))  {
				return new JavaClassFileResorceImpl(uri);
			}
		}

		throw new UnsupportedOperationException();
	}
}
