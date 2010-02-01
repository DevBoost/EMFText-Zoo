package org.emftext.language.java.resource.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.JavaURIConverter;

public class JDTConnector {

	private static JDTConnector instance = null;
	
	public static JDTConnector getInstance() {
		if (instance == null) {
			instance = new JDTConnector();
		}
		return instance;
	}
	
	private boolean isJavaProject(IProject project) {
		try {
			return project.isNatureEnabled("org.eclipse.jdt.core.javanature");
		} catch (CoreException e) {
		}
		return false;
	}
	
	private IProject getProject(URI uri) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		if (uri.isPlatformResource() && uri.segmentCount() > 2) {
			return root.getProject(uri.segment(1));
		}
		return null;
	}
	
	private IJavaProject getJavaProject(URI uri) {
		IProject project = getProject(uri);
		return (isJavaProject(project) ? JavaCore.create(project) : null);
	}
	
	public String getPackageName(URI uri) {
		IJavaProject javaProject = getJavaProject(uri);
		IClasspathEntry[] classpathEntries = null;
		if (javaProject != null) {
			try {
				classpathEntries = javaProject.getResolvedClasspath(true);
			} catch (JavaModelException e) {
			}
		}
		if (classpathEntries == null) {
			return null;
		}
		processEntry: for (int i = 0; i < classpathEntries.length; i++) {
			IClasspathEntry entry = classpathEntries[i];
			if (entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
				// path is source folder
				URI sourceUri = getURI(entry.getPath());
				String packageName = null;
				for (int j = 2; j < uri.segmentCount() - 1; j++) {
					String segment = uri.segment(j);
					if (j < sourceUri.segmentCount() && (! segment.equals(sourceUri.segment(j)))) {
						continue processEntry;
					} else if (j == sourceUri.segmentCount() - 1) {
						// last segment corresponds to default package
						packageName = "";
					} else if (packageName != null) {
						packageName = (packageName.length() == 0 ? segment : packageName + "." + segment);
					}
				}
				return packageName;
			} 
		}
		return null;
	}
	public URI getURI(String wsRelativePath) {
		return URI.createPlatformResourceURI(wsRelativePath, true);
	}
	public URI getURI(IPath wsRelativePath) {
		return getURI(wsRelativePath.toString());
	}
	public URI getURI(IResource resource) {
		return getURI(resource.getFullPath());
	}
	public String getPackageName(Resource resource) {
		return getPackageName(resource.getURI());
	}
	public String getPackageName(IResource resource) {
		return getPackageName(getURI(resource));
	}

	public ResourceSet createResourceSet(URI resourceUri) {
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		initializeResourceSet(resourceSet, resourceUri);
		return resourceSet;
	}

	public void initializeResourceSet(ResourceSet resourceSet, URI resourceUri) {
		if (resourceSet.getURIConverter() instanceof JavaURIConverter) {
			return;
		}
		
		resourceSet.setURIConverter(new JavaURIConverter());
		Map<Object, Object> loadOptions = resourceSet.getLoadOptions();
		if (loadOptions.get(JavaClasspath.OPTION_USE_LOCAL_CLASSPATH) == null) {
			loadOptions.put(JavaClasspath.OPTION_USE_LOCAL_CLASSPATH, true);
		}
		if (loadOptions.get(JavaClasspath.OPTION_REGISTER_STD_LIB) == null) {
			loadOptions.put(JavaClasspath.OPTION_REGISTER_STD_LIB, false);
		}
		if (resourceUri != null) {
			JavaClasspath.setParentClasspath(resourceSet, getJavaProjectClasspath(
					resourceSet.getURIConverter().normalize(resourceUri)));
		}
	}

	public JavaClasspath getJavaProjectClasspath(URI uri) {
		return getJavaClasspath(getJavaProject(uri));
	}

	private Map<URI, JavaClasspath> javaClasspaths = new HashMap<URI, JavaClasspath>();
	
	private JavaClasspath getJavaClasspath(IJavaProject javaProject) {
		URI projectUri = URI.createPlatformResourceURI(javaProject.getPath().toString(), true);
		JavaClasspath javaClasspath = javaClasspaths.get(projectUri);
		if (javaClasspath != null) {
			return javaClasspath;
		}
		IClasspathEntry[] classpathEntries = null;
		try {
			classpathEntries = javaProject.getResolvedClasspath(true);
		} catch (JavaModelException e) {
		}
		if (classpathEntries == null) {
			return null;
		}
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		final ResourceSet classPath = new ResourceSetImpl();
		classPath.setURIConverter(new JavaURIConverter());
		classPath.getLoadOptions().put(JavaClasspath.OPTION_USE_LOCAL_CLASSPATH, true);
		classPath.getLoadOptions().put(JavaClasspath.OPTION_REGISTER_STD_LIB, false);
		for (int i = 0; i < classpathEntries.length; i++) {
			IClasspathEntry entry = classpathEntries[i];
			IPath path = entry.getPath();
			if (entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
				// path is source folder
				// System.out.println("Doing nothing for ClassPathEntry source: " + entry);
				// registerResourceInClasspath(root.getFolder(path), classPath);
			} else if (entry.getEntryKind() == IClasspathEntry.CPE_LIBRARY) {
				if ("jar".equals(path.getFileExtension()) || "zip".equals(path.getFileExtension())) {
					// path is jar
					// System.out.println("registerFileInClasspath for ClassPathEntry library: " + entry);
					IFile file = root.getFile(path);
					if (file.getLocation() != null) {
						path = file.getLocation();
					}
					registerFileInClasspath(path, classPath);
				} else {
					// path is binary folder
					// System.out.println("registerResourceInClasspath for ClassPathEntry library (folder): " + entry);
					registerResourceInClasspath(root.getFolder(path), "class", classPath);
				}
			} else if (entry.getEntryKind() == IClasspathEntry.CPE_CONTAINER) {
				// System.out.println("Doing nothing for ClassPathEntry container: " + entry);
			} else if (entry.getEntryKind() == IClasspathEntry.CPE_VARIABLE) {
				// System.out.println("Doing nothing for ClassPathEntry variable: " + entry);
			} 
		}
		try {
			registerResourceInClasspath(root.getFolder(javaProject.getOutputLocation()), "class", classPath);
		} catch (JavaModelException e) {
			System.err.println("Exception adding output folder to classpath: " + e);
		}
		javaClasspath = JavaClasspath.get(classPath);
		javaClasspaths.put(projectUri, javaClasspath);
		return javaClasspath;
	}
	
	private void registerResourceInClasspath(IResource resource, final String filter, final ResourceSet classPath) {
    	try {
			resource.accept(new IResourceVisitor() {
				public boolean visit(IResource resource) {
					if (resource instanceof IFile) {
						IFile file = (IFile)resource;
						String ext = file.getFileExtension();
						if (filter == null || filter.equals(ext)) {
							registerFileInClasspath(file.getFullPath(), classPath);
						}
					} 
					return true;
				}
			});
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	private void registerFileInClasspath(IPath file, ResourceSet classPath) {
		String fileExtension = file.getFileExtension();
		URI resourceUri = null;
		if ("java".equals(fileExtension) || "class".equals(fileExtension)) {
			resourceUri = URI.createPlatformResourceURI(file.toString(), true);
		} else if ("jar".equals(fileExtension) || "zip".equals(fileExtension)) {
			// resourceUri = URI.createFileURI(Platform.getLocation() + file.getFullPath().toString());
			IPath jarLocation = file;
			if (jarLocation != null) {
				resourceUri = URI.createFileURI(jarLocation.toString());
			} else {
				resourceUri = URI.createFileURI(file.toString());
			}
		} else {
			// unknown file extension
			return;
		}
		if (resourceUri == null || (! classPath.getURIConverter().exists(resourceUri, null))) {
			System.err.println("Resource for " + file + " does not exist (uri=" + resourceUri + ")");
			return;
		}
		if ("java".equals(fileExtension) || "class".equals(fileExtension)) {
			// System.out.println("Loading file in classpath: " + resourceUri);
			classPath.getResource(resourceUri, true);
		} else if ("jar".equals(fileExtension) || "zip".equals(fileExtension)) {
			try {
				JavaClasspath.get(classPath).registerClassifierJar(resourceUri);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
