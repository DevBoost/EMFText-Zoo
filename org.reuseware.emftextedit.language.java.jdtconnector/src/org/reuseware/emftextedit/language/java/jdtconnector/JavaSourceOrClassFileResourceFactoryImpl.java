package org.reuseware.emftextedit.language.java.jdtconnector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.reuseware.emftextedit.language.java.resource.java.JavaResourceImpl;


public class JavaSourceOrClassFileResourceFactoryImpl implements Resource.Factory {

	public static final String JAVA_PATHMAP = "pathmap://java/";
	
	protected Map<URI, URI> URI_MAP = URIConverter.URI_MAP;

	protected Map<String, List<String>> packageClassifierMap =
		new HashMap<String, List<String>>();
	
	protected Map<URI, IType> classFileMap =
		new HashMap<URI, IType>();
	
	protected URIConverter myURIConverter = 
		new ExtensibleURIConverterImpl();
	
	public URI createJavaURI(String packageName, String name) {
		URI logicalUriString = 
			URI.createURI(JAVA_PATHMAP + packageName + "/" + name + ".javax");
		return logicalUriString;
	}
	
	public JavaSourceOrClassFileResourceFactoryImpl() {
		JavaCore.addElementChangedListener(new JavaEMFModelUpdateListener(this));
	}
	
	
	protected void registerClassifier(String packageName, String name, URI uri) {
		if (!packageClassifierMap.containsKey(packageName)) {
			packageClassifierMap.put(packageName, new ArrayList<String>());
		}
		if (!packageClassifierMap.get(packageName).contains(name)) {
			packageClassifierMap.get(packageName).add(name);
		}
		
		if (uri != null) {
			URI logicalUriString = createJavaURI(packageName, name);
			
			URI_MAP.put(logicalUriString, uri);
		}
	}

	public void registerCompiledCompilationUnit(String packageName, ICompilationUnit cu) {
		try {
			for(IType type : cu.getAllTypes()) {
				registerClassifier(packageName, type.getElementName(), null);
				classFileMap.put(createJavaURI(packageName, type.getElementName()), 
						type);
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
	}
	
	public void registerSourceCompilationUnit(String packageName, ICompilationUnit cu, URI uri) {
		try {
			for(IType type : cu.getAllTypes()) {
				registerClassifier(packageName, type.getElementName(), uri);
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
