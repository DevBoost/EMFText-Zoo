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
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.containers.ContainersFactory;
import org.emftext.language.java.containers.Package;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.MemberContainer;
import org.emftext.language.java.members.MembersPackage;
import org.emftext.language.java.resource.java.JavaResource;
import org.emftext.runtime.resource.IContextDependentURIFragment;

public class JavaSourceOrClassFileResource extends JavaResource {
	
//	@Override
//	public ILocationMap getLocationMap() {
//		return new DevNullLocationMap();
//	}
	// TODO jjohannes: add comment for this option
	public static final String OPTION_REGISTER_LOCAL = "OPTION_REGISTER_LOCAL";
	
	ClassFileModelLoader classFileParser = new ClassFileModelLoader();
	
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
			CompilationUnit cu = classFileParser.parse(inputStream, getURI().lastSegment());
			getContents().add(cu);
		}
		else {
			super.doLoad(inputStream, options);
			if (getContents().isEmpty() && getErrors().isEmpty()) {
				contents.add(ContainersFactory.eINSTANCE.createEmptyModel());
			}
			if (options != null) {
				Boolean local = (Boolean) options.get(OPTION_REGISTER_LOCAL);
		    	register(Boolean.TRUE.equals(local));
			} else {
				register(false);
			}
		}
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
			//classes should have a physical resource
			//System.out.println("[JaMoPP] Warning: " + uri.lastSegment() + " not registered in class path");
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

	@Override
	public EObject getEObject(String id) {
		EObject result = null;
		if (isClassFile() && 
				id.startsWith(JavaUniquePathConstructor.CLASSIFIERS_ROOT_PATH_PREFIX)) {
			
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
			result = super.getEObject(id);
			if(!id.startsWith(IContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX)) {
				if(result != null && !(result instanceof ConcreteClassifier)) {
					//may happen if members of same name exist
					if(result.eContainingFeature().equals(MembersPackage.Literals.MEMBER_CONTAINER__MEMBERS) 
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
	
	private void register(boolean local) throws IOException {
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
				if (local) {
					JavaClasspath.INSTANCE.registerClassifierSource(cu, myURI, getURIConverter().getURIMap());
				}
				else {
					JavaClasspath.INSTANCE.registerClassifierSource(cu, myURI);	
				}
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
				pkg.getNamespaces().addAll(thisPackage.getNamespaces());
				pkg.getNamespaces().add(thisPackage.getName());
				pkg.setName(folder.getName());
				thisPackage.getSubpackages().add(pkg);
				collectSubunits(folder, pkg);
			}
		}
		populatePackage(thisPackage);
	}
	
	private String packageName(Package aPackage) {
		String name = "";
		for(int i=0; i < aPackage.getNamespaces().size(); i++) {
			name += aPackage.getNamespaces().get(i) + ".";
		}
		name += aPackage.getName();
		return name;
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
