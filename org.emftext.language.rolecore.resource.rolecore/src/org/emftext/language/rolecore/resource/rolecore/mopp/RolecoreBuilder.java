/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.rolecore.resource.rolecore.mopp;

import org.eclipse.emf.common.util.URI;
import org.emftext.language.rolecore.ecore_compiler.RolecoreCompiler;

public class RolecoreBuilder implements org.emftext.language.rolecore.resource.rolecore.IRolecoreBuilder {
	
	public org.eclipse.core.runtime.IStatus build(org.emftext.language.rolecore.resource.rolecore.mopp.RolecoreResource resource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		RolecoreCompiler compiler = new RolecoreCompiler();
		return compiler.process(resource.getContents());
	}

	public boolean isBuildingNeeded(URI uri) {
		return true;
	}
}
