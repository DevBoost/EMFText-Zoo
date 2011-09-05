/*******************************************************************************
 * Copyright (c) 2006-2011
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
package org.emftext.language.java.resource.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.TypeNameRequestor;
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
	
	private IJavaProject getJavaProject(IProject project) {
		return (isJavaProject(project) ? JavaCore.create(project) : null);
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
		URI projectUri = URI.createPlatformResourceURI(project.getFullPath()
				.toString(), true);
		JavaClasspath javaClasspath = javaClasspaths.get(projectUri);
		if (javaClasspath != null) {
			//return javaClasspath;
		}
		ResourceSet classPath = new ResourceSetImpl();
		IJavaProject javaProject = getJavaProject(project);
		registerJavaProjectInClassPath(classPath, javaProject);
		javaClasspath = JavaClasspath.get(classPath);
		javaClasspaths.put(projectUri, javaClasspath);
		return javaClasspath;
	}

	private void registerJavaProjectInClassPath(final ResourceSet classPath,
			IJavaProject javaProject) {

		SearchEngine searchEngine = new SearchEngine();
		
		try {
			searchEngine.searchAllTypeNames(null, null, 
					SearchEngine.createJavaSearchScope(new IJavaProject[] {javaProject}), 
					new ClasspathFiller(JavaClasspath.get(classPath)), IJavaSearchConstants.FORCE_IMMEDIATE_SEARCH, null);
		} catch (JavaModelException e) { 
			e.printStackTrace();
		}
	}	

	private static final class ClasspathFiller extends TypeNameRequestor {
		private final JavaClasspath classPath;

		private ClasspathFiller(JavaClasspath classPath) {
			this.classPath = classPath;
		}

		@Override
		public void acceptType(int modifiers,
				char[] packageName, char[] simpleTypeName,
				char[][] enclosingTypeNames, String path) {
			
			URI uri;
			if (isInWorkspace(path)) {
				uri = URI.createPlatformResourceURI(path, true);
			} else {
				uri = URI.createFileURI(path);
			}
			
			if (path.contains(".jar|")) {
				String[] split = uri.toString().split("%7C");
				uri = URI.createURI("archive:" + split[0] + "!/" + split[1]);
			}
			String fullContainerName = String.valueOf(packageName) + ".";
			for (char[] enclosingType : enclosingTypeNames) {
				fullContainerName = fullContainerName + String.valueOf(enclosingType) + "$";
			}
			
			classPath.registerClassifier(
					fullContainerName, 
					String.valueOf(simpleTypeName), uri);			
		}
		
		private boolean isInWorkspace(String path) {
			IWorkspaceRoot wsRoot = ResourcesPlugin.getWorkspace().getRoot();
			return wsRoot.findMember(path) != null;
		}
	}

}
