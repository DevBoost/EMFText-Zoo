/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0.mopp;

public class Pl0BuilderAdapter extends org.eclipse.core.resources.IncrementalProjectBuilder {
	
	// the ID of the default, generated builder
	public final static String BUILDER_ID = "org.emftext.language.pl0.resource.pl0.builder";
	
	private org.emftext.language.pl0.resource.pl0.IPl0Builder builder = new org.emftext.language.pl0.resource.pl0.mopp.Pl0Builder();
	
	public org.eclipse.core.resources.IProject[] build(int kind, java.util.Map args, final org.eclipse.core.runtime.IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException {
		return build(kind, args, monitor, builder, getProject());
	}
	
	public org.eclipse.core.resources.IProject[] build(int kind, java.util.Map args, final org.eclipse.core.runtime.IProgressMonitor monitor, final org.emftext.language.pl0.resource.pl0.IPl0Builder builder, org.eclipse.core.resources.IProject project) throws org.eclipse.core.runtime.CoreException {
		org.eclipse.core.resources.IResourceDelta delta = getDelta(project);
		if (delta == null) {
			return null;
		}
		delta.accept(new org.eclipse.core.resources.IResourceDeltaVisitor() {
			public boolean visit(org.eclipse.core.resources.IResourceDelta delta) throws org.eclipse.core.runtime.CoreException {
				org.eclipse.core.resources.IResource resource = delta.getResource();
				if (resource instanceof org.eclipse.core.resources.IFile && "pl0".equals(resource.getFileExtension())) {
					org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
					if (builder.isBuildingNeeded(uri)) {
						org.emftext.language.pl0.resource.pl0.mopp.Pl0Resource customResource = (org.emftext.language.pl0.resource.pl0.mopp.Pl0Resource) new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl().getResource(uri, true);
						builder.build(customResource, monitor);
					}
					return false;
				}
				return true;
			}
		});
		return null;
	}
	
}
