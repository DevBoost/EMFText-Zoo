package org.emftext.language.java.resource.classfile;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.emftext.language.java.core.CompilationUnit;
import org.emftext.language.java.JavaClasspath;
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
				System.out.println("Warning: " + uri + " not registered in ClassPath");
				return new JavaSourceFileResourceImpl(uri);
			}
			
			if(normalizedURI.fileExtension().equals("java")) {
				JavaSourceFileResourceImpl javaResource =  new JavaSourceFileResourceImpl(uri);
				if(!JavaClasspath.INSTANCE.URI_MAP.values().contains(normalizedURI)) {
					//not yet registered in classpath
					loadAndRegister(javaResource, normalizedURI);
				}
				return javaResource;
			}
			if(normalizedURI.fileExtension().equals("class"))  {
				return new JavaClassFileResorceImpl(uri);
			}
		}

		throw new UnsupportedOperationException();
	}


	private void loadAndRegister(Resource javaResource, URI normalizedURI) {
		try {
			javaResource.load(null);
		} catch (IOException e) {
			//e.printStackTrace();
		}
		if (!javaResource.getContents().isEmpty()) {
			CompilationUnit cu = (CompilationUnit) javaResource.getContents().get(0);
			JavaClasspath.INSTANCE.registerClassifierSource(cu, normalizedURI);
		}
	}
}
