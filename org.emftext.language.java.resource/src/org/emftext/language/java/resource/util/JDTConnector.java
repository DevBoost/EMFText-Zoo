package org.emftext.language.java.resource.util;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IElementChangedListener;
import org.eclipse.jdt.core.IJavaElementDelta;
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

	public JDTConnector() {
//		addClasspathListener();
	}

//	private void addClasspathListener() {
//		JavaCore.addElementChangedListener(new IElementChangedListener() {
//
//			private IJavaProject checkDeltas(IJavaElementDelta delta) {
//				if ((delta.getFlags() & IJavaElementDelta.F_ADDED_TO_CLASSPATH) != 0
//						|| (delta.getFlags() & IJavaElementDelta.F_CLASSPATH_CHANGED) != 0
//						|| (delta.getFlags() & IJavaElementDelta.F_REMOVED_FROM_CLASSPATH) != 0
//						|| (delta.getFlags() & IJavaElementDelta.F_RESOLVED_CLASSPATH_CHANGED) != 0) {
//					if ((delta.getElement() instanceof IJavaProject))
//						return (IJavaProject) delta.getElement();
//				}
//				IJavaElementDelta[] affectedChildren = delta
//						.getAffectedChildren();
//				for (IJavaElementDelta iJavaElementDelta : affectedChildren) {
//					if (checkDeltas(iJavaElementDelta) != null)
//						return checkDeltas(iJavaElementDelta);
//				}
//				return null;
//			}
//
//			public void elementChanged(ElementChangedEvent event) {
//				IJavaElementDelta delta = event.getDelta();
//				if (checkDeltas(delta) != null) {
//					IJavaProject project = checkDeltas(delta);
//					System.out.println("should refresh "
//							+ project.getProject().getName());
//				}
//			}
//		});
//	}

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
		return getJavaProject(project);
	}

	private IJavaProject getJavaProject(IProject project) {
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
					if (j < sourceUri.segmentCount()
							&& (!segment.equals(sourceUri.segment(j)))) {
						continue processEntry;
					} else if (j == sourceUri.segmentCount() - 1) {
						// last segment corresponds to default package
						packageName = "";
					} else if (packageName != null) {
						packageName = (packageName.length() == 0 ? segment
								: packageName + "." + segment);
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
		if (resourceSet == null) {
			return;
		}
		if (resourceSet.getURIConverter() == null) {
			return;
		}
		if (!resourceSet.getURIConverter().normalize(resourceUri)
				.isPlatformResource()) {
			return;
		}
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
			JavaClasspath.setParentClasspath(resourceSet,
					getJavaProjectClasspath(resourceSet.getURIConverter()
							.normalize(resourceUri)));
		}
	}

	public JavaClasspath getJavaProjectClasspath(URI uri) {
		return getJavaClasspath(getProject(uri));
	}

	public void refreshJavaProjectClasspath(IProject project) {
		URI projectUri = URI.createPlatformResourceURI(project.getFullPath()
				.toString(), true);
		javaClasspaths.remove(projectUri);
	}

	private Map<URI, JavaClasspath> javaClasspaths = new HashMap<URI, JavaClasspath>();

	private JavaClasspath getJavaClasspath(IProject project) {
		// TODO There is caching functionality here which has been deactivated.
		// If reactivated, the cache needs to be updated if the classpath of
		// a project changes (e.g., if a new class is created, or a new library
		// is referenced)
		//
		URI projectUri = URI.createPlatformResourceURI(project.getFullPath()
				.toString(), true);
		JavaClasspath javaClasspath = javaClasspaths.get(projectUri);
		if (javaClasspath != null) {
			return javaClasspath;
		}
		ResourceSet classPath = new ResourceSetImpl();
		IJavaProject javaProject = getJavaProject(project);
		registerJavaProjectInClassPath(classPath, javaProject);
		javaClasspath = JavaClasspath.get(classPath);
		javaClasspaths.put(projectUri, javaClasspath);
		return javaClasspath;
	}

	private void registerJavaProjectInClassPath(ResourceSet classPath,
			IJavaProject javaProject) {
		IClasspathEntry[] classpathEntries = null;
		if (javaProject != null) {
			try {
				classpathEntries = javaProject.getResolvedClasspath(true);
			} catch (JavaModelException e) {
			}
		}
		if (classpathEntries != null) {
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			classPath.setURIConverter(new JavaURIConverter());
			classPath.getLoadOptions().put(
					JavaClasspath.OPTION_USE_LOCAL_CLASSPATH, true);
			classPath.getLoadOptions().put(
					JavaClasspath.OPTION_REGISTER_STD_LIB, false);
			for (int i = 0; i < classpathEntries.length; i++) {
				IClasspathEntry entry = classpathEntries[i];
				IPath path = entry.getPath();
				if (entry.getEntryKind() == IClasspathEntry.CPE_PROJECT) {
					// TODO this can cause an infinite loop when there is cyclic
					// project dependencies!
					for (IProject nextPoject : root.getProjects()) {
						if (nextPoject.getFullPath().equals(path)) {
							IJavaProject importedJavaProject = getJavaProject(nextPoject);
							if (importedJavaProject != null) {
								registerJavaProjectInClassPath(classPath,
										importedJavaProject);
							}
						}
					}
				} else if (entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
					IPath outputLocation = entry.getOutputLocation();
					if (outputLocation == null) {
						try {
							outputLocation = javaProject.getOutputLocation();
						} catch (JavaModelException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					IFolder folder = root.getFolder(outputLocation);

					// path is source folder
					// System.out.println("Doing nothing for ClassPathEntry source: "
					// + entry);

					// Parsing the real java files induces a huge performance
					// problem
					// Therefore we use BCEL here
					registerResourceTreeInClasspath(folder, "class", classPath);
				} else if (entry.getEntryKind() == IClasspathEntry.CPE_LIBRARY) {
					IFolder folder = root.getFolder(path);
					if ("jar".equals(path.getFileExtension())
							|| "zip".equals(path.getFileExtension())) {
						// path is jar
						// System.out.println("registerFileInClasspath for ClassPathEntry library: "
						// + entry);
						IFile file = root.getFile(path);
						if (file.getLocation() != null) {
							path = file.getLocation();
						}
						registerFileInClasspath(path, classPath);
					} else {
						// check whether path is inside or outside of the
						// workspace
						IResource member = root.findMember(path);
						if (member != null) {
							// path is binary folder in workspace
							System.out
									.println("registerResourceInClasspath for ClassPathEntry library (folder): "
											+ entry + " -> " + path);
							registerResourceTreeInClasspath(folder, "class",
									classPath);
						} else {
							// path is binary folder outside of workspace
							String osPath = path.toOSString();
							java.io.File osFile = new java.io.File(osPath);
							registerExternalDirectoryInClasspath(osFile,
									"class", classPath);
						}
					}
				} else if (entry.getEntryKind() == IClasspathEntry.CPE_CONTAINER) {
					// System.out.println("Doing nothing for ClassPathEntry container: "
					// + entry);
				} else if (entry.getEntryKind() == IClasspathEntry.CPE_VARIABLE) {
					// System.out.println("Doing nothing for ClassPathEntry variable: "
					// + entry);
				}
			}
			/*
			 * try { //registerResourceInClasspath(root.getFolder(javaProject.
			 * getOutputLocation()), "class", classPath); } catch
			 * (JavaModelException e) {
			 * System.err.println("Exception adding output folder to classpath: "
			 * + e); }
			 */
		}
	}

	private void registerExternalDirectoryInClasspath(File osFile,
			final String filter, ResourceSet classPath) {
		File[] files = osFile.listFiles(new FileFilter() {

			public boolean accept(File file) {
				return file.getName().endsWith("." + filter)
						|| file.isDirectory();
			}
		});
		for (File file : files) {
			if (file.isDirectory()) {
				registerExternalDirectoryInClasspath(file, filter, classPath);
			} else {
				IPath filePath = new Path(file.getAbsolutePath());
				URI fileURI = URI.createFileURI(filePath.toOSString());
				registerResourceInClassPath(filePath, classPath, fileURI);
			}
		}
	}

	private void registerResourceTreeInClasspath(IResource resource,
			final String filter, final ResourceSet classPath) {
		try {
			resource.accept(new IResourceVisitor() {
				public boolean visit(IResource resource) {
					if (resource instanceof IFile) {
						IFile file = (IFile) resource;
						String ext = file.getFileExtension();
						if (file.getType() == IFile.FILE
								&& (filter == null || filter.equals(ext))) {
							registerFileInClasspath(file.getFullPath(),
									classPath);
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
			resourceUri = URI.createFileURI(file.toString());
		} else {
			// unknown file extension
			return;
		}
		registerResourceInClassPath(file, classPath, resourceUri);
	}

	private void registerResourceInClassPath(IPath file, ResourceSet classPath,
			URI resourceUri) {
		String fileExtension = file.getFileExtension();
		if (resourceUri == null
				|| (!classPath.getURIConverter().exists(resourceUri, null))) {
			System.err.println("Resource for " + file + " does not exist (uri="
					+ resourceUri + ")");
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
