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
package org.emftext.language.java.resource.register;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.emftext.language.java.JavaClasspath;

/**
 * This action registers all <code>java</code>, <code>class</code> and <code>jar</code> files
 * contained in the given selection in the global JaMoPP Java classpath (see <code>JavaClasspath</code>).
 */
public class RegisterJavaFilesAction implements IObjectActionDelegate {

	private ISelection selection;

	public void run(IAction action) {
       	if (selection instanceof IStructuredSelection) {	
            for (Iterator<?> i = ((IStructuredSelection)selection).iterator(); i.hasNext(); ) {
                Object next = i.next();
                if (next instanceof IResource) {
                	IResource resource = (IResource) next;
                	try {
						resource.accept(new IResourceVisitor() {
							public boolean visit(IResource resource) {
								if (resource instanceof IFile) {
									IFile file = (IFile) resource;
									registerFileInClasspath(file);
								} 
								return true;
							}
						});
					} catch (CoreException e) {
						e.printStackTrace();
					}               	
                }
            }
        }
	}

	private void registerFileInClasspath(
			IFile file) {
		
		if (file == null) {
			return;
		}
		if (file.getFileExtension() == null) {
			return;
		}
		
		if (file.getFileExtension().equals("java") || file.getFileExtension().equals("class")) {
			URI resourceUri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			ResourceSet rs = new ResourceSetImpl();
			//loading the file once without "local" option will register all classifiers contained
			rs.getResource(resourceUri, true);
		}
		if (file.getFileExtension().equals("jar")) {
			URI resourceUri = URI.createFileURI(Platform.getLocation() + file.getFullPath().toString());
			try {
				Platform.getLocation();
				JavaClasspath.get().registerClassifierJar(resourceUri);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

}
