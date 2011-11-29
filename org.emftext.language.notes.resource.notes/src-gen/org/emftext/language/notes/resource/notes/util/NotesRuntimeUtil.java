/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.util;

/**
 * This utility class provides methods to obtain information about the current
 * runtime, for example whether Eclipse is available or not.
 */
public class NotesRuntimeUtil {
	
	/**
	 * Checks whether the class org.eclipse.core.runtime.Platformis available on the
	 * classpath. This can be used to determine if Eclipse is available in the current
	 * runtime environment.
	 */
	public boolean isEclipsePlatformAvailable() {
		try {
			Class.forName("org.eclipse.core.runtime.Platform");
			return true;
		} catch (ClassNotFoundException cnfe) {
		}
		return false;
	}
	
	/**
	 * Logs the given error. If Eclipse is running, the error is added to the error
	 * log otherwise the message is printed to System.err.
	 */
	public void logError(String message, Throwable exception) {
		if (isEclipsePlatformAvailable()) {
			org.emftext.language.notes.resource.notes.mopp.NotesPlugin.logError(message, exception);
			return;
		}
		System.err.println(message);
		if (exception != null) {
			exception.printStackTrace();
		}
	}
	
	/**
	 * Checks whether the Eclipse platform is running.
	 */
	public boolean isEclipsePlatformRunning() {
		if (!isEclipsePlatformAvailable()) {
			return false;
		}
		return org.eclipse.core.runtime.Platform.isRunning();
	}
	
}
