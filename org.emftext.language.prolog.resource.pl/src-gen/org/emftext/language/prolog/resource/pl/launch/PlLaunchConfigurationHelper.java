/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.launch;

/**
 * A class that provides common methods that are required by launch configuration
 * delegates.
 */
public class PlLaunchConfigurationHelper {
	
	public static class SystemOutInterpreter extends org.emftext.language.prolog.resource.pl.util.AbstractPlInterpreter<Void,Void> {
		
		@Override		
		public Void interprete(org.eclipse.emf.ecore.EObject object, Void context) {
			System.out.println("Found " + object + ", but don't know what to do with it.");
			return null;
		}
	}
	
	/**
	 * Launch an example interpreter that prints object to System.out.
	 */
	public void launch(org.eclipse.debug.core.ILaunchConfiguration configuration, String mode, org.eclipse.debug.core.ILaunch launch, org.eclipse.core.runtime.IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException {
		org.eclipse.emf.ecore.EObject root = getModelRoot(configuration);
		// replace this delegate with your actual interpreter
		SystemOutInterpreter delegate = new SystemOutInterpreter();
		delegate.addObjectTreeToInterpreteTopDown(root);
		launchInterpreter(configuration, mode, launch, monitor, delegate, null);
	}
	
	public <ResultType, ContextType> void launchInterpreter(org.eclipse.debug.core.ILaunchConfiguration configuration, String mode, org.eclipse.debug.core.ILaunch launch, org.eclipse.core.runtime.IProgressMonitor monitor, org.emftext.language.prolog.resource.pl.util.AbstractPlInterpreter<ResultType, ContextType> delegate, final ContextType context) throws org.eclipse.core.runtime.CoreException {
		final boolean enableDebugger = mode.equals(org.eclipse.debug.core.ILaunchManager.DEBUG_MODE);
		// step 1: find two free ports we can use to communicate between the Eclipse and
		// the interpreter
		int requestPort = findFreePort();
		int eventPort = findFreePort();
		if (requestPort < 0 || eventPort < 0) {
			abort("Unable to find free port", null);
		}
		
		final org.emftext.language.prolog.resource.pl.debug.PlDebuggableInterpreter<ResultType, ContextType> interpreter = new org.emftext.language.prolog.resource.pl.debug.PlDebuggableInterpreter<ResultType, ContextType>(delegate, eventPort);
		
		// step 2: prepare and start interpreter in separate thread
		Thread interpreterThread = new Thread(new Runnable() {
			
			public void run() {
				// if we are in debug mode, the interpreter must wait for the debugger to attach
				interpreter.interprete(context, enableDebugger);
			}
		});
		interpreterThread.start();
		
		// step 3: start debugger listener (sends commands from Eclipse debug framework to
		// running process
		org.emftext.language.prolog.resource.pl.debug.PlDebuggerListener<ResultType, ContextType> debugListener = new org.emftext.language.prolog.resource.pl.debug.PlDebuggerListener<ResultType, ContextType>(requestPort);
		debugListener.setDebuggable(interpreter);
		new Thread(debugListener).start();
		
		// step 4: start debugger
		org.emftext.language.prolog.resource.pl.debug.PlDebugProcess process = new org.emftext.language.prolog.resource.pl.debug.PlDebugProcess(launch);
		launch.addDebugTarget(new org.emftext.language.prolog.resource.pl.debug.PlDebugTarget(process, launch, requestPort, eventPort));
	}
	
	public org.eclipse.emf.common.util.URI getURI(org.eclipse.debug.core.ILaunchConfiguration configuration) throws org.eclipse.core.runtime.CoreException {
		return org.eclipse.emf.common.util.URI.createURI(configuration.getAttribute(org.emftext.language.prolog.resource.pl.launch.PlLaunchConfigurationDelegate.ATTR_RESOURCE_URI, (String) null));
	}
	
	public org.eclipse.emf.ecore.EObject getModelRoot(org.eclipse.debug.core.ILaunchConfiguration configuration) throws org.eclipse.core.runtime.CoreException {
		return org.emftext.language.prolog.resource.pl.util.PlResourceUtil.getResourceContent(getURI(configuration));
	}
	
	/**
	 * Returns a free port number on localhost, or -1 if unable to find a free port.
	 */
	protected int findFreePort() {
		java.net.ServerSocket socket = null;
		try {
			socket = new java.net.ServerSocket(0);
			return socket.getLocalPort();
		} catch (java.io.IOException e) {
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (java.io.IOException e) {
				}
			}
		}
		return -1;
	}
	/**
	 * Throws an exception with a new status containing the given message and optional
	 * exception.
	 * 
	 * @param message error message
	 * @param e underlying exception
	 * 
	 * @throws CoreException
	 */
	protected void abort(String message, Throwable e) throws org.eclipse.core.runtime.CoreException {
		throw new org.eclipse.core.runtime.CoreException(new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, org.emftext.language.prolog.resource.pl.mopp.PlPlugin.DEBUG_MODEL_ID, 0, message, e));
	}
}
