package org.emftext.language.java.resource.register;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.emftext.language.java.resource.util.JDTConnector;

public class RefreshClasspath implements IObjectActionDelegate {

	private ISelection selection;

	public void run(IAction action) {
		if (selection instanceof IStructuredSelection) {
			for (Iterator<?> i = ((IStructuredSelection) selection).iterator(); i
					.hasNext();) {
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

	private void registerFileInClasspath(IFile file) {

		if (file == null) {
			return;
		}
		IProject project = file.getProject();
		Platform.getLocation();
		JDTConnector.getInstance().refreshJavaProjectClasspath(project);

	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

}
