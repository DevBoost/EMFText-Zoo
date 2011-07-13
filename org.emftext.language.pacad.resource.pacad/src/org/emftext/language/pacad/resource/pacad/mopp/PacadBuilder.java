
package org.emftext.language.pacad.resource.pacad.mopp;

import org.emftext.language.pacad.resource.pacad.PacadConstraintChecker;

public class PacadBuilder implements org.emftext.language.pacad.resource.pacad.IPacadBuilder {
	
	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri) {
		return true;
	}
	
	public org.eclipse.core.runtime.IStatus build(org.emftext.language.pacad.resource.pacad.mopp.PacadResource resource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		new PacadConstraintChecker().check(resource);
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}
}
