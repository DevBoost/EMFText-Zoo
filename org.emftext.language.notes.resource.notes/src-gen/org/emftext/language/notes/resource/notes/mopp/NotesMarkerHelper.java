/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.mopp;

/**
 * Helper class to add markers to text files based on EMF's
 * <code>org.eclipse.emf.ecore.resource.Resource.Diagnostic</code>. If a resource
 * contains
 * <code>org.emftext.language.notes.resource.notes.INotesTextDiagnostic</code>s it
 * uses the more precise information of this extended diagnostic type.
 */
public class NotesMarkerHelper {
	
	/**
	 * The extension id of the custom marker type that is used by this text resource.
	 */
	public static final String MARKER_TYPE = org.emftext.language.notes.resource.notes.mopp.NotesPlugin.PLUGIN_ID + ".problem";
	
	/**
	 * The total number of markers per file is restricted with this constant.
	 * Restriction is needed because the performance of Eclipse decreases drastically
	 * if large amounts of markers are added to files.
	 */
	public static int MAXIMUM_MARKERS = 500;
	
	/**
	 * We use a queue to aggregate commands that create or remove markers. This is
	 * basically for performance reasons. Without the queue we would need to create a
	 * job for each marker creation/removal, which creates tons of threads and takes
	 * very long time.
	 */
	private final static MarkerCommandQueue COMMAND_QUEUE = new MarkerCommandQueue();
	
	private static class MarkerCommandQueue {
		
		private java.util.List<org.emftext.language.notes.resource.notes.INotesCommand<Object>> commands = new java.util.ArrayList<org.emftext.language.notes.resource.notes.INotesCommand<Object>>();
		private final Object jobLock = new Object();
		
		public void addCommand(org.emftext.language.notes.resource.notes.INotesCommand<Object> command) {
			synchronized(commands) {
				commands.add(command);
				// we only need to schedule a job, if the queue was empty
				if (commands.size() == 1) {
					scheduleRunCommandsJob();
				}
			}
		}
		
		private void scheduleRunCommandsJob() {
			new org.eclipse.core.runtime.jobs.Job("updating markers") {
				@Override				
				protected org.eclipse.core.runtime.IStatus run(org.eclipse.core.runtime.IProgressMonitor monitor) {
					synchronized(jobLock) {
						java.util.List<org.emftext.language.notes.resource.notes.INotesCommand<Object>> commandsToProcess = new java.util.ArrayList<org.emftext.language.notes.resource.notes.INotesCommand<Object>>();
						synchronized(commands) {
							commandsToProcess.addAll(commands);
							commands.clear();
						}
						for (org.emftext.language.notes.resource.notes.INotesCommand<Object> command : commandsToProcess) {
							command.execute(null);
						}
					}
					return org.eclipse.core.runtime.Status.OK_STATUS;
				}
			}.schedule();
		}
		
	}
	
	/**
	 * Creates a marker from the given diagnostics object and attaches the marker to
	 * the resource. Markers are created and removed asynchronously. Thus, they may
	 * not appear when calls to this method return. But, the order of marker additions
	 * and removals is preserved.
	 * 
	 * @param resource The resource that is the file to mark.
	 * @param diagnostic The diagnostic with information for the marker.
	 */
	public static void mark(org.eclipse.emf.ecore.resource.Resource resource, final org.emftext.language.notes.resource.notes.INotesTextDiagnostic diagnostic) {
		final org.eclipse.core.resources.IFile file = getFile(resource);
		if (file == null) {
			return;
		}
		createMarkerFromDiagnostic(file, diagnostic);
	}
	
	private static void createMarkerFromDiagnostic(final org.eclipse.core.resources.IFile file, final org.emftext.language.notes.resource.notes.INotesTextDiagnostic diagnostic) {
		final org.emftext.language.notes.resource.notes.INotesProblem problem = diagnostic.getProblem();
		org.emftext.language.notes.resource.notes.NotesEProblemType problemType = problem.getType();
		final String markerID = getMarkerID(problemType);
		COMMAND_QUEUE.addCommand(new org.emftext.language.notes.resource.notes.INotesCommand<Object>() {
			public boolean execute(Object context) {
				try {
					// if there are too many markers, we do not add new ones
					if (file.findMarkers(markerID, false, org.eclipse.core.resources.IResource.DEPTH_ZERO).length >= MAXIMUM_MARKERS) {
						return true;
					}
					
					org.eclipse.core.resources.IMarker marker = file.createMarker(markerID);
					if (problem.getSeverity() == org.emftext.language.notes.resource.notes.NotesEProblemSeverity.ERROR) {
						marker.setAttribute(org.eclipse.core.resources.IMarker.SEVERITY, org.eclipse.core.resources.IMarker.SEVERITY_ERROR);
					} else {
						marker.setAttribute(org.eclipse.core.resources.IMarker.SEVERITY, org.eclipse.core.resources.IMarker.SEVERITY_WARNING);
					}
					marker.setAttribute(org.eclipse.core.resources.IMarker.MESSAGE, diagnostic.getMessage());
					org.emftext.language.notes.resource.notes.INotesTextDiagnostic textDiagnostic = (org.emftext.language.notes.resource.notes.INotesTextDiagnostic) diagnostic;
					marker.setAttribute(org.eclipse.core.resources.IMarker.LINE_NUMBER, textDiagnostic.getLine());
					marker.setAttribute(org.eclipse.core.resources.IMarker.CHAR_START, textDiagnostic.getCharStart());
					marker.setAttribute(org.eclipse.core.resources.IMarker.CHAR_END, textDiagnostic.getCharEnd() + 1);
					if (diagnostic instanceof org.emftext.language.notes.resource.notes.mopp.NotesResource.ElementBasedTextDiagnostic) {
						org.eclipse.emf.ecore.EObject element = ((org.emftext.language.notes.resource.notes.mopp.NotesResource.ElementBasedTextDiagnostic) diagnostic).getElement();
						String elementURI = getObjectURI(element);
						if (elementURI != null) {
							marker.setAttribute(org.eclipse.emf.ecore.util.EcoreValidator.URI_ATTRIBUTE, elementURI);
						}
					}
					java.util.Collection<org.emftext.language.notes.resource.notes.INotesQuickFix> quickFixes = textDiagnostic.getProblem().getQuickFixes();
					java.util.Collection<Object> sourceIDs = new java.util.ArrayList<Object>();
					if (quickFixes != null) {
						for (org.emftext.language.notes.resource.notes.INotesQuickFix quickFix : quickFixes) {
							if (quickFix != null) {
								sourceIDs.add(quickFix.getContextAsString());
							}
						}
					}
					if (!sourceIDs.isEmpty()) {
						marker.setAttribute(org.eclipse.core.resources.IMarker.SOURCE_ID, org.emftext.language.notes.resource.notes.util.NotesStringUtil.explode(sourceIDs, "|"));
					}
				} catch (org.eclipse.core.runtime.CoreException ce) {
					handleException(ce);
				}
				return true;
			}
		});
	}
	
	/**
	 * Removes all markers from the given resource regardless of their type. Markers
	 * are created and removed asynchronously. Thus, they may not appear when calls to
	 * this method return. But, the order of marker additions and removals is
	 * preserved.
	 * 
	 * @param resource The resource where to delete markers from
	 */
	public static void unmark(org.eclipse.emf.ecore.resource.Resource resource) {
		for (org.emftext.language.notes.resource.notes.NotesEProblemType nextType : org.emftext.language.notes.resource.notes.NotesEProblemType.values()) {
			unmark(resource, nextType);
		}
	}
	
	/**
	 * Removes all markers of the given type from the given resource. Markers are
	 * created and removed asynchronously. Thus, they may not appear when calls to
	 * this method return. But, the order of marker additions and removals is
	 * preserved.
	 * 
	 * @param resource The resource where to delete markers from
	 * @param problemType The type of problem to remove
	 */
	public static void unmark(org.eclipse.emf.ecore.resource.Resource resource, org.emftext.language.notes.resource.notes.NotesEProblemType problemType) {
		final org.eclipse.core.resources.IFile file = getFile(resource);
		if (file == null) {
			return;
		}
		final String markerType = getMarkerID(problemType);
		COMMAND_QUEUE.addCommand(new org.emftext.language.notes.resource.notes.INotesCommand<Object>() {
			public boolean execute(Object context) {
				try {
					file.deleteMarkers(markerType, false, org.eclipse.core.resources.IResource.DEPTH_ZERO);
				} catch (org.eclipse.core.runtime.CoreException ce) {
					handleException(ce);
				}
				return true;
			}
		});
	}
	
	/**
	 * Removes all markers that were caused by the given object from the resource.
	 * Markers are created and removed asynchronously. Thus, they may not appear when
	 * calls to this method return. But, the order of marker additions and removals is
	 * preserved.
	 * 
	 * @param resource The resource where to delete markers from
	 * @param causingObject The cause of the problems to remove
	 */
	public static void unmark(org.eclipse.emf.ecore.resource.Resource resource, final org.eclipse.emf.ecore.EObject causingObject) {
		final org.eclipse.core.resources.IFile file = getFile(resource);
		if (file == null) {
			return;
		}
		final String markerID = getMarkerID(org.emftext.language.notes.resource.notes.NotesEProblemType.UNKNOWN);
		final String causingObjectURI = getObjectURI(causingObject);
		if (causingObjectURI == null) {
			return;
		}
		COMMAND_QUEUE.addCommand(new org.emftext.language.notes.resource.notes.INotesCommand<Object>() {
			public boolean execute(Object context) {
				try {
					org.eclipse.core.resources.IMarker[] markers = file.findMarkers(markerID, true, org.eclipse.core.resources.IResource.DEPTH_ZERO);
					for (org.eclipse.core.resources.IMarker marker : markers) {
						if (causingObjectURI.equals(marker.getAttribute(org.eclipse.emf.ecore.util.EcoreValidator.URI_ATTRIBUTE))) {
							marker.delete();
						}
					}
				} catch (org.eclipse.core.runtime.CoreException ce) {
					handleException(ce);
				}
				return true;
			}
		});
	}
	
	/**
	 * Returns the ID of the marker type that is used to indicate problems of the
	 * given type.
	 */
	private static String getMarkerID(org.emftext.language.notes.resource.notes.NotesEProblemType problemType) {
		String markerID = MARKER_TYPE;
		String typeID = problemType.getID();
		if (!"".equals(typeID)) {
			markerID += "." + typeID;
		}
		return markerID;
	}
	
	/**
	 * Tries to determine the file for the given resource. If the platform is not
	 * running, the resource is not a platform resource, or the resource cannot be
	 * found in the workspace, this method returns <code>null</code>.
	 */
	private static org.eclipse.core.resources.IFile getFile(org.eclipse.emf.ecore.resource.Resource resource) {
		if (resource == null || !org.eclipse.core.runtime.Platform.isRunning()) {
			return null;
		}
		String platformString = resource.getURI().toPlatformString(true);
		if (platformString == null) {
			return null;
		}
		org.eclipse.core.resources.IFile file = (org.eclipse.core.resources.IFile) org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
		return file;
	}
	
	/**
	 * Returns an URI that identifies the given object.
	 */
	private static String getObjectURI(org.eclipse.emf.ecore.EObject object) {
		if (object == null) {
			return null;
		}
		if (object.eIsProxy() && object instanceof org.eclipse.emf.ecore.impl.BasicEObjectImpl) {
			return ((org.eclipse.emf.ecore.impl.BasicEObjectImpl) object).eProxyURI().toString();
		}
		org.eclipse.emf.ecore.resource.Resource eResource = object.eResource();
		if (eResource == null) {
			return null;
		}
		return eResource.getURI().toString() + "#" + eResource.getURIFragment(object);
	}
	
	private static void handleException(org.eclipse.core.runtime.CoreException ce) {
		if (ce.getMessage().matches("Marker.*not found.")) {
			// ignore
		}else if (ce.getMessage().matches("Resource.*does not exist.")) {
			// ignore
		} else {
			new org.emftext.language.notes.resource.notes.util.NotesRuntimeUtil().logError("Error while removing markers from resource:", ce);
		}
	}
	
}
