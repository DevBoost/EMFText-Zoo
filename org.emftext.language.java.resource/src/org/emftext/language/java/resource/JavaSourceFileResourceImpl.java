package org.emftext.language.java.resource;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.JavaUniquePathConstructor;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.containers.ContainersFactory;
import org.emftext.language.java.containers.Package;
import org.emftext.language.java.resource.java.JavaResource;

public class JavaSourceFileResourceImpl extends JavaResource {

	public JavaSourceFileResourceImpl(URI uri) {
		super(uri);
	}

	protected void doLoad(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		super.doLoad(inputStream, options);
		if (getContents().isEmpty() && getErrors().isEmpty()) {
			contents.add(ContainersFactory.eINSTANCE.createEmptyModel());
		}
	    register();
	}
	
	@Override
	public void load(Map<?, ?> options) throws IOException {
    	URIConverter uriConverter = getURIConverter();
    	URI normalizedURI = uriConverter.normalize(uri);
		if(normalizedURI.toString().startsWith(JavaUniquePathConstructor.JAVA_PACKAGE_PATHMAP)) {
			if (!isLoaded) {
				loadPackageFromClasspath();
			}
		}
		else if(normalizedURI.toString().startsWith(JavaUniquePathConstructor.JAVA_CLASSIFIER_PATHMAP)) {
			//do nothing. class not available.
		}
		else {
			super.load(options);
		}
	}
	
	protected void doUnload() {
		if (!getContents().isEmpty()) {
			if(getContents().get(0) instanceof Package) {
				getContents().clear();
			}
			else {
				super.doUnload();
			}
		}
	}

	private void loadPackageFromClasspath() {
		Package thePackage = ContainersFactory.eINSTANCE.createPackage();
		String packageName = getURI().trimFileExtension().toString().substring(
				JavaUniquePathConstructor.JAVA_PACKAGE_PATHMAP.length());
		String[] packageNaemParts = packageName.split("\\.");
		for(int i = 0; i < packageNaemParts.length; i++) {
			if(i < packageNaemParts.length - 1) {
				thePackage.getNamespace().add(packageNaemParts[i]);
			}
			else {
				thePackage.setName(packageNaemParts[i]);
			}
		}
		populatePackage(thePackage);
		getContents().add(thePackage);
	}
	
	private void register() throws IOException {
		URI myURI = getURI();
		
		//only for physical URIs
		if("pathmap".equals(myURI.scheme())) {
			return;
		}

		if (!getContents().isEmpty()) {
			EObject root = getContents().get(0);
			//could also be a package-info.java without CU
			if(root instanceof CompilationUnit) {
				CompilationUnit cu = (CompilationUnit) getContents().get(0);
				cu.setName(myURI.lastSegment());
				JavaClasspath.INSTANCE.registerClassifierSource(cu, myURI);
			}
			else if (root instanceof Package) {
				//package-info.java
				Package p = (Package) root;
				
				if(Platform.isRunning()) {
					//if inside eclipse, register other files is workspace
					IContainer container = WorkspaceSynchronizer.getFile(this).getParent();
					try {
						collectSubunits(container, p);
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
				else {
					populatePackage(p);
				}
			}
		}
	}

	private void populatePackage(Package p) {
		String fullPackageName = packageName(p);
		for (ConcreteClassifier classifier : JavaClasspath.INSTANCE.getClassifiers(
				fullPackageName, "*")) {
			
			classifier = (ConcreteClassifier) EcoreUtil.resolve(classifier, this.getResourceSet());
			CompilationUnit cu = (CompilationUnit)classifier.eContainer();
			//binary resource
			if (cu == null) {
				cu = ContainersFactory.eINSTANCE.createCompilationUnit();
				cu.getClassifiers().add(classifier);
			}
			
			p.getCompilationUnits().add(
					cu);
		}
	}
	
	private void collectSubunits(IContainer container, Package thisPackage) throws CoreException, IOException {
		if (container == null) return;
		
		IResource[] members = container.members();
		String fullPackageName = packageName(thisPackage);
		for (IResource resource : members) {
			if (resource instanceof IFile) {
				IFile file = (IFile) resource;
				if (file.getFileExtension().equals("java") && !file.getName().equals("package-info.java")) {
					//URI fileUri = URI.createFileURI( file.getFullPath().toString());
					URI resourceUri = URI.createURI("platform:/resource" + file.getFullPath().toString());
					if (!JavaClasspath.INSTANCE.URI_MAP.values().contains(resourceUri)) {
						JavaClasspath.INSTANCE.registerClassifier(
								fullPackageName, 
								file.getName().substring(0, file.getName().length() - 5), 
								resourceUri);
					}
				}
			} else if (resource instanceof IFolder && !resource.getName().startsWith(".")) { 
				IFolder folder = (IFolder) resource;
				
				Package pkg = ContainersFactory.eINSTANCE.createPackage();
				pkg.getNamespace().addAll(thisPackage.getNamespace());
				pkg.getNamespace().add(thisPackage.getName());
				pkg.setName(folder.getName());
				thisPackage.getSubpackages().add(pkg);
				collectSubunits(folder, pkg);
			}
		}
		populatePackage(thisPackage);
	}
	
	private String packageName(Package aPackage) {
		String name = "";
		for(int i=0; i < aPackage.getNamespace().size(); i++) {
			name += aPackage.getNamespace().get(i) + ".";
		}
		name += aPackage.getName();
		return name;
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
					
					String[] folder = cu.getNamespace().toArray(
							new String[cu.getNamespace().size()]);
					String   file   = cu.getClassifiers().get(0).getName();
					
					URI subResourcURI = getURI().trimFileExtension().trimFileExtension();
					subResourcURI = subResourcURI.appendSegments(folder);
					subResourcURI = subResourcURI.appendSegment(file);
					subResourcURI = subResourcURI.appendFileExtension("java");
					
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
