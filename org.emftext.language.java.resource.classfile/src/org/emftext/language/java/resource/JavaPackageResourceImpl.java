package org.emftext.language.java.resource;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.JavaUniquePathConstructor;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.containers.ContainersFactory;
import org.emftext.language.java.containers.Package;

// TODO Jendrik: check if this class is needed any more 
// or is better replaced by CustomPkgResourceImpl.java
public class JavaPackageResourceImpl extends ResourceImpl {

	protected Package myPackage = null;
	
	public JavaPackageResourceImpl(URI uri) {
		super(uri);
	}
	
	@Override
	public void load(Map<?, ?> options) throws IOException {
	    if (!isLoaded) {
			myPackage = ContainersFactory.eINSTANCE.createPackage();
			
			String packageName = getURI().trimFileExtension().toString().substring(
					JavaUniquePathConstructor.JAVA_PACKAGE_PATHMAP.length());
			
			EList<Classifier> classifierList = JavaClasspath.INSTANCE.getClassifiers(
					packageName, "*");
			
			// TODO adapted to new package abstraction
	
//			for (Classifier classifier : classifierList) {
//				if (classifier.eContainer() instanceof CompilationUnit) {
//					myPackage.getCompilationUnits().add((CompilationUnit) classifier.eContainer());
//				}
//					
//			}
			
			
			getContents().add(myPackage);
	    }
	}
	

	@Override
	public void save(Map<?, ?> options) throws IOException {
		// save not supported
	}
}
