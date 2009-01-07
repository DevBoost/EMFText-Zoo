package org.emftext.language.java.resource.classfile;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.core.CompilationUnit;
import org.emftext.language.java.resource.java.JavaResourceImpl;

public class JavaSourceFileResourceImpl extends JavaResourceImpl {

	public JavaSourceFileResourceImpl(URI uri) {
		super(uri);
	}

	/**
	 * Registers pathmap if not done already.
	 */
	public void load(Map<?, ?> options) throws IOException {
		boolean wasLoaded = !isLoaded;
		super.load(options);
	    if (wasLoaded) {
	    	register();
	    }
	}

	private void register() {
		URI myURI = getURI();
		
		//only for physical URIs
		if("pathmap".equals(myURI.scheme())) {
			return;
		}
		
		//only for not yet registered
		if(JavaClasspath.INSTANCE.URI_MAP.values().contains(myURI)) {
			return;
		}
		
		if (!getContents().isEmpty()) {
			CompilationUnit cu = (CompilationUnit) getContents().get(0);
			JavaClasspath.INSTANCE.registerClassifierSource(cu, myURI);
		}
	}

	@Override
	protected void doSave(OutputStream outputStream, Map<?, ?> options)
			throws IOException {
		if(getContents().size() > 1 && getResourceSet() != null) {
			for(EObject eObject : new BasicEList<EObject>(getContents())) {
				if (eObject instanceof CompilationUnit) {
					CompilationUnit cu = (CompilationUnit) eObject;
					if (cu.getClassifiers().isEmpty()) {
						continue;
					}
					
					String[] folder = cu.getPackage().toArray(
							new String[cu.getPackage().size()]);
					String   file   = cu.getClassifiers().get(0).getName();
					
					URI subResourcURI = getURI().trimFileExtension().trimFileExtension();
					subResourcURI = subResourcURI.appendSegments(folder);
					subResourcURI = subResourcURI.appendSegment(file);
					subResourcURI =  subResourcURI.appendFileExtension("java");
					
					Resource subResource = 
						getResourceSet().createResource(subResourcURI);
					
					subResource.getContents().add(cu);
					subResource.save(options);					
				}
				else {
					//nothing
				}
			}
		}
		else {
			super.doSave(outputStream, options);
		}
	}
}
