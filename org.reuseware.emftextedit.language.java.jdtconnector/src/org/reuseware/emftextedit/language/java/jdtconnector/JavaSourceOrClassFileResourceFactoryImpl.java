package org.reuseware.emftextedit.language.java.jdtconnector;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.reuseware.emftextedit.language.java.JavaClasspath;
import org.reuseware.emftextedit.language.java.JavaUniquePathConstructor;
import org.reuseware.emftextedit.language.java.resource.java.JavaResourceImpl;


public class JavaSourceOrClassFileResourceFactoryImpl implements Resource.Factory {
	
	protected Map<URI, IType> classFileMap =
		new HashMap<URI, IType>();
	
	protected URIConverter myURIConverter = 
		new ExtensibleURIConverterImpl();
	

	public JavaSourceOrClassFileResourceFactoryImpl() {
		JavaCore.addElementChangedListener(new JavaEMFModelUpdateListener(this));
	}
	
	


	public void registerCompiledCompilationUnit(String packageName, ICompilationUnit cu) {
		try {
			for(IType type : cu.getAllTypes()) {
				JavaClasspath.INSTANCE.registerClassifier(packageName, type.getElementName(), null);
				classFileMap.put(JavaUniquePathConstructor.getClassifierResourceURI(
						packageName, type.getElementName()), 
						type);
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
	}
	
	public void registerSourceCompilationUnit(String packageName, ICompilationUnit cu, URI uri) {
		try {
			for(IType type : cu.getAllTypes()) {
				JavaClasspath.INSTANCE.registerClassifier(packageName, type.getElementName(), uri);
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
	}

	public Resource createResource(URI uri){
		//is there a physical source file behind this URI?
		if(!uri.equals(myURIConverter.normalize(uri))) {
			return new JavaResourceImpl(uri);
		}
		else {
			return new JavaClassFileResorce(uri, classFileMap.get(uri));
		}
	}
}
