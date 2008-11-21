package org.reuseware.emftextedit.language.java.resource.classfile;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.reuseware.emftextedit.language.java.CompilationUnit;
import org.reuseware.emftextedit.language.java.JavaClasspath;
import org.reuseware.emftextedit.language.java.resource.java.JavaResourceImpl;


public class JavaSourceOrClassFileResourceFactoryImpl implements Resource.Factory {

	protected URIConverter myURIConverter = 
		new ExtensibleURIConverterImpl();

	public JavaSourceOrClassFileResourceFactoryImpl() {
	}


	public Resource createResource(URI uri){
		//is there a physical source file behind this URI?
		URI normailzedURI = myURIConverter.normalize(uri);

		if("pathmap".equals(normailzedURI.scheme())) {
			//something wrong
			System.out.println("Warning: " + uri + " not registered in ClassPath");
			return new JavaResourceImpl(uri);
		}
		
		if(normailzedURI.fileExtension().equals("java")) {
			if(!JavaClasspath.INSTANCE.URI_MAP.values().contains(normailzedURI)) {
				//not yet registered in classpath
				loadAndRegister(normailzedURI);
			}
			return new JavaResourceImpl(uri);
		}
		if(normailzedURI.fileExtension().equals("class"))  {
			return new JavaClassFileResorce(uri);
		}
		
		throw new UnsupportedOperationException();
	}


	private void loadAndRegister(URI uri) {
		//try to load and register
		Resource tempResource = new JavaResourceImpl(uri);
		try {
			tempResource.load(null);
		} catch (IOException e) {
			//e.printStackTrace();
		}
		if (!tempResource.getContents().isEmpty()) {
			CompilationUnit cu = (CompilationUnit) tempResource.getContents().get(0);
			JavaClasspath.INSTANCE.registerClassifierSource(cu, uri);
		}
	}
}
