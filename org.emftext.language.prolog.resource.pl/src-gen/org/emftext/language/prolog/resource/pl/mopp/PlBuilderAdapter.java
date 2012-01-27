/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.mopp;

public class PlBuilderAdapter extends org.eclipse.core.resources.IncrementalProjectBuilder {
	
	/**
	 * The ID of the default, generated builder.
	 */
	public final static String BUILDER_ID = "org.emftext.language.prolog.resource.pl.builder";
	
	private org.emftext.language.prolog.resource.pl.IPlBuilder defaultBuilder = new org.emftext.language.prolog.resource.pl.mopp.PlBuilder();
	
	public org.eclipse.core.resources.IProject[] build(int kind, java.util.Map<String, String> args, final org.eclipse.core.runtime.IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException {
		org.eclipse.core.resources.IResourceDelta delta = getDelta(getProject());
		if (delta == null) {
			return null;
		}
		delta.accept(new org.eclipse.core.resources.IResourceDeltaVisitor() {
			public boolean visit(org.eclipse.core.resources.IResourceDelta delta) throws org.eclipse.core.runtime.CoreException {
				org.eclipse.core.resources.IResource resource = delta.getResource();
				if (delta.getKind() == org.eclipse.core.resources.IResourceDelta.REMOVED) {
					new org.emftext.language.prolog.resource.pl.mopp.PlMarkerHelper().removeAllMarkers(resource, getBuilderMarkerId());
					return false;
				}
				if (resource instanceof org.eclipse.core.resources.IFile && resource.getName().endsWith("." + new org.emftext.language.prolog.resource.pl.mopp.PlMetaInformation().getSyntaxName())) {
					build((org.eclipse.core.resources.IFile) resource, monitor);
					return false;
				}
				return true;
			}
		});
		return null;
	}
	
	public void build(org.eclipse.core.resources.IFile resource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
		org.emftext.language.prolog.resource.pl.IPlBuilder builder = getBuilder();
		if (builder.isBuildingNeeded(uri)) {
			org.emftext.language.prolog.resource.pl.mopp.PlResource customResource = (org.emftext.language.prolog.resource.pl.mopp.PlResource) new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl().getResource(uri, true);
			new org.emftext.language.prolog.resource.pl.mopp.PlMarkerHelper().removeAllMarkers(resource, getBuilderMarkerId());
			builder.build(customResource, monitor);
		}
	}
	
	/**
	 * Returns the builder that shall be used by this adapter. This allows subclasses
	 * to perform builds with different builders.
	 */
	public org.emftext.language.prolog.resource.pl.IPlBuilder getBuilder() {
		return defaultBuilder;
	}
	
	/**
	 * Returns the id for the markers that are created by this builder. This allows
	 * subclasses to produce different kinds of markers.
	 */
	public String getBuilderMarkerId() {
		return org.emftext.language.prolog.resource.pl.mopp.PlMarkerHelper.getMarkerID(org.emftext.language.prolog.resource.pl.PlEProblemType.BUILDER_ERROR);
	}
	
}
