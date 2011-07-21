/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.java.treejava.resource.treejava.mopp;

import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.emftext.language.java.treejava.resource.treejava.ITreejavaBuilder;
import org.emftext.language.java.treejava.resource.treejava.compiler.TreeJavaCompiler;

public class TreejavaBuilder implements ITreejavaBuilder {
	
	public boolean isBuildingNeeded(URI uri) {
		return true;
	}
	
	public IStatus build(TreejavaResource resource, IProgressMonitor monitor) {
		try {
			new TreeJavaCompiler().compile(resource);
			return Status.OK_STATUS;
		} catch (IOException e) {
			return new Status(IStatus.ERROR, TreejavaPlugin.PLUGIN_ID, e.getMessage());
		}
	}
}
