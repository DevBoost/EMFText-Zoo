/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java.resource;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
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
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.containers.ContainersFactory;
import org.emftext.language.java.containers.Package;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.MemberContainer;
import org.emftext.language.java.members.MembersPackage;
import org.emftext.language.java.resource.java.IJavaContextDependentURIFragment;
import org.emftext.language.java.resource.java.mopp.JavaResource;
import org.emftext.language.java.resource.util.JDTConnector;
import org.emftext.language.java.util.JavaModelCompletion;

/**
 * A resource that uses either the generated <code>JavaParser</code> or
 * the <code>ClassFileModelLoader</code> for loading depending on the file
 * extension of the resource's URI.
 */
public class JavaSourceOrClassFileResource extends JavaResource {
	
//	@Override
//	public ILocationMap getLocationMap() {
//		return new DevNullLocationMap();
//	}
	
	public JavaSourceOrClassFileResource(URI uri) {
		super(uri);
	}

	private boolean isClassFile() {
		//is there a physical source file behind this URI?
		URI normalizedURI = getURIConverter().normalize(uri);
		
		if(normalizedURI.fileExtension().equals("class"))  {
			return true;
		}
		return false;
	}
	
	protected void doLoad(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		if (isClassFile()) {
			JavaClasspath javaClasspath = JavaClasspath.get(this);
			ClassFileModelLoader classFileParser = new ClassFileModelLoader(javaClasspath);
			CompilationUnit cu = classFileParser.parse(inputStream, getURI().lastSegment());
			getContents().add(cu);
			JavaModelCompletion.complete(this);
		}
		else {
			super.doLoad(inputStream, options);
			if (getContents().isEmpty() && getErrors().isEmpty()) {
				contents.add(ContainersFactory.eINSTANCE.createEmptyModel());
			}
		}
	}
	
	@Override
	public void load(Map<?, ?> options) throws IOException {
		JDTConnector.getInstance().initializeResourceSet(getResourceSet(), uri);
    	URIConverter uriConverter = getURIConverter();
    	URI normalizedURI = uriConverter.normalize(uri);
		if(normalizedURI.toString().startsWith(JavaUniquePathConstructor.JAVA_PACKAGE_PATHMAP)) {
			if (!isLoaded) {
				loadPackageFromClasspath();
			}
		}
		else if(normalizedURI.toString().startsWith(JavaUniquePathConstructor.JAVA_CLASSIFIER_PATHMAP)) {
			//classes should have a physical resource
			//System.out.println("[JaMoPP] Warning: " + uri.lastSegment() + " not registered in class path");
		}
		else {
			super.load(options);
		}
		register();
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

	@Override
	public EObject getEObject(String id) {
		EObject result = null;
		if (isClassFile() && 
				id.startsWith("//" + JavaUniquePathConstructor.CLASSIFIERS_ROOT_PATH_PREFIX)) {
			
			if (!getContents().isEmpty()) {
				//in a class file, there is always only one classifier as root element: 
				//id path can be ignored
				CompilationUnit cu =  (CompilationUnit) contents.get(0);
				return cu.getClassifiers().get(0);
			}
			else {
				assert(false);
			}
		}
		else {
			try {
			result = super.getEObject(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(!id.startsWith(IJavaContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX)) {
				if(result != null && !(result instanceof ConcreteClassifier)) {
					//may happen if members of same name exist
					if(result.eContainingFeature() != null 
							&& result.eContainingFeature().equals(MembersPackage.Literals.MEMBER_CONTAINER__MEMBERS) 
							&& result instanceof NamedElement) {
						String memberName = ((NamedElement)result).getName();
						for(Member m : ((MemberContainer)result.eContainer()).getMembers()) {
							if(memberName.equals(m.getName()) && m instanceof ConcreteClassifier) {
								result = m;
								return result;
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	protected EObject getEObject(List<String> uriFragmentPath) {
		int size = uriFragmentPath.size();
		EObject eObject = getEObjectForURIFragmentRootSegment(size == 0 ? ""
				: uriFragmentPath.get(0));
		for (int i = 1; i < size && eObject != null; ++i) {
			String uriFragment = uriFragmentPath.get(i);
			if (eObject instanceof MemberContainer && uriFragment.startsWith(
				JavaUniquePathConstructor.CLASSIFIERS_SUB_PATH_PREFIX)) {

				MemberContainer memberContainer = (MemberContainer) eObject;
				String name = uriFragment.substring(
						JavaUniquePathConstructor.CLASSIFIERS_SUB_PATH_PREFIX.length(),
						uriFragment.length() - 2);
				eObject = memberContainer.getContainedClassifier(name);
			}
			else if (eObject instanceof CompilationUnit && uriFragment.startsWith(
					JavaUniquePathConstructor.CLASSIFIERS_ROOT_PATH_PREFIX)){
				
				CompilationUnit compilationUnit = (CompilationUnit)eObject;
				String name = uriFragment.substring(
						JavaUniquePathConstructor.CLASSIFIERS_ROOT_PATH_PREFIX.length(), 
						uriFragment.length() - 2);
				eObject = compilationUnit.getContainedClassifier(name);
			} else {
				eObject = null;
			}
		}

		return eObject;
	}
	
	
	
	private void loadPackageFromClasspath() {
		Package thePackage = ContainersFactory.eINSTANCE.createPackage();
		String packageName = getURI().trimFileExtension().toString().substring(
				JavaUniquePathConstructor.JAVA_PACKAGE_PATHMAP.length());
		String[] packageNaemParts = packageName.split("\\.");
		for(int i = 0; i < packageNaemParts.length; i++) {
			if(i < packageNaemParts.length - 1) {
				thePackage.getNamespaces().add(packageNaemParts[i]);
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
				JavaClasspath.get(this).registerClassifierSource(cu, myURI);	
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
		String fullPackageName = JavaUniquePathConstructor.packageName(p);
		for (EObject classifier : JavaClasspath.get(this).getClassifiers(
				fullPackageName, "*")) {
			
			classifier = (ConcreteClassifier) EcoreUtil.resolve(classifier, this.getResourceSet());
			if (!classifier.eIsProxy()) {
				CompilationUnit cu = (CompilationUnit)classifier.eContainer();
				if (cu != null) {
					p.getCompilationUnits().add(cu);
				}
			}
		}
	}
	
	private void collectSubunits(IContainer container, Package thisPackage) throws CoreException, IOException {
		if (container == null) return;
		
		IResource[] members = container.members();
		String fullPackageName = JavaUniquePathConstructor.packageName(thisPackage);
		for (IResource resource : members) {
			if (resource instanceof IFile) {
				IFile file = (IFile) resource;
				if (file.getFileExtension().equals("java") && !file.getName().equals("package-info.java")) {
					//URI fileUri = URI.createFileURI( file.getFullPath().toString());
					URI resourceUri = URI.createURI("platform:/resource" + file.getFullPath().toString());
					if (!getURIConverter().getURIMap().values().contains(resourceUri)) {
						JavaClasspath.get(this).registerClassifier(
								fullPackageName, 
								file.getName().substring(0, file.getName().length() - 5), 
								resourceUri);
					}
				}
			} else if (resource instanceof IFolder && !resource.getName().startsWith(".")) { 
				IFolder folder = (IFolder) resource;
				
				Package pkg = ContainersFactory.eINSTANCE.createPackage();
				pkg.getNamespaces().addAll(thisPackage.getNamespaces());
				pkg.getNamespaces().add(thisPackage.getName());
				pkg.setName(folder.getName());
				thisPackage.getSubpackages().add(pkg);
				collectSubunits(folder, pkg);
			}
		}
		populatePackage(thisPackage);
	}
	

	@Override
	protected void doSave(OutputStream outputStream, Map<?, ?> options)
			throws IOException {
		if (isClassFile()) {
			//save not supported
			return;
		}
		
		if(getContents().size() > 1 && getResourceSet() != null) {
			for(EObject eObject : new BasicEList<EObject>(getContents())) {
				if (eObject instanceof CompilationUnit) {
					CompilationUnit cu = (CompilationUnit) eObject;
					if (cu.getClassifiers().isEmpty()) {
						continue;
					}
					
					String[] folder = cu.getNamespaces().toArray(
							new String[cu.getNamespaces().size()]);
					String   file   = cu.getClassifiers().get(0).getName();
					
					URI normalizedURI = getResourceSet().getURIConverter().normalize(getURI());
					
					URI subResourcURI = normalizedURI.trimFileExtension().trimFileExtension();
					
					if (normalizedURI.segmentCount() >= folder.length + 1 &&
						normalizedURI.segmentsList().subList(
								normalizedURI.segmentCount() - 1 - folder.length,
								normalizedURI.segmentCount() - 1).equals(Arrays.asList(folder))) {
						subResourcURI = subResourcURI.trimSegments(1);
					}
					else {
						subResourcURI = subResourcURI.appendSegments(folder);	
					}
					subResourcURI = subResourcURI.appendSegment(file);
					subResourcURI = subResourcURI.appendFileExtension("java");
					
					Resource subResource = 
						getResourceSet().createResource(subResourcURI);
					
					addPackageDeclaration(cu);
					
					subResource.getContents().add(cu);
					subResource.save(options);					
				}
				else {
					//nothing
				}
			}
		}
		else {
			if (!getContents().isEmpty() && getContents().get(0) instanceof CompilationUnit) {
				CompilationUnit cu = (CompilationUnit) getContents().get(0) ;
				addPackageDeclaration(cu);
			}
			super.doSave(outputStream, options);
		}
	}

	/**
	 * This method adds a package declaration (namespaces) to the given compilation unit
	 * if none is defined and this resource has a logical URI. The segments of the logical
	 * URI are assumed as package name.
	 * 
	 * @param cu
	 */
	private void addPackageDeclaration(CompilationUnit cu) {
		if (cu.getNamespaces().isEmpty() && !getURI().isFile() && !getURI().isPlatform()) {
			//if there is no package and this is a logical URI, guess the package based on the URI
			cu.getNamespaces().addAll(getURI().trimSegments(1).segmentsList());
		}
	}
}
