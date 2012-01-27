/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.debug;

public class PlLineBreakpoint extends org.eclipse.debug.core.model.LineBreakpoint {
	
	private static final String LINE_BREAKPOINT_MARKER_ID = "org.emftext.language.prolog.resource.pl.debug.lineBreakpoint.marker";
	
	public PlLineBreakpoint() {
		super();
	}
	
	public PlLineBreakpoint(final org.eclipse.core.resources.IResource resource, final int lineNumber) throws org.eclipse.debug.core.DebugException {
		org.eclipse.core.resources.IWorkspaceRunnable runnable = new org.eclipse.core.resources.IWorkspaceRunnable() {
			public void run(org.eclipse.core.runtime.IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException {
				org.eclipse.core.resources.IMarker marker = resource.createMarker(LINE_BREAKPOINT_MARKER_ID);
				setMarker(marker);
				marker.setAttribute(org.eclipse.debug.core.model.IBreakpoint.ENABLED, Boolean.TRUE);
				marker.setAttribute(org.eclipse.core.resources.IMarker.LINE_NUMBER, lineNumber);
				marker.setAttribute(org.eclipse.debug.core.model.IBreakpoint.ID, getModelIdentifier());
				marker.setAttribute(org.eclipse.core.resources.IMarker.MESSAGE, "Line Breakpoint: " + resource.getName() + " [line: " + lineNumber + "]");
				marker.setAttribute(org.eclipse.core.resources.IMarker.LOCATION, resource.getRawLocation().toPortableString());
			}
		};
		run(getMarkerRule(resource), runnable);
	}
	
	public String getModelIdentifier() {
		return org.emftext.language.prolog.resource.pl.mopp.PlPlugin.DEBUG_MODEL_ID;
	}
	
	public void install(org.emftext.language.prolog.resource.pl.debug.PlDebugTarget target) {
		try {
			String location = (String) getMarker().getAttribute(org.eclipse.core.resources.IMarker.LOCATION);
			target.getDebugProxy().addLineBreakpoint(location, getLineNumber());
		} catch (org.eclipse.core.runtime.CoreException e) {
			e.printStackTrace();
		}
	}
	
	public void remove(org.emftext.language.prolog.resource.pl.debug.PlDebugTarget target) {
		try {
			String location = (String) getMarker().getAttribute(org.eclipse.core.resources.IMarker.LOCATION);
			target.getDebugProxy().removeLineBreakpoint(location, getLineNumber());
		} catch (org.eclipse.core.runtime.CoreException e) {
			e.printStackTrace();
		}
	}
	
}
