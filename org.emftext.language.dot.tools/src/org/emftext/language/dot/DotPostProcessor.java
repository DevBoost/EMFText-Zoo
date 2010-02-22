/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.dot;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.emftext.language.dot.resource.dot.IDotResourcePostProcessor;
import org.emftext.language.dot.resource.dot.mopp.DotResource;
import org.emftext.language.dot.util.ExeUtil;
import org.emftext.language.dot.util.Pair;

public class DotPostProcessor implements IDotResourcePostProcessor {

	private static final String dotExecutable = getDOTExecutable();

	public void process(DotResource resource) {
		if (!testDOT()) {
			String path = System.getenv("PATH"); //$NON-NLS-1$
			resource.addError("Cannot run DOT execuatble. Please make sure that it is contained in your PATH variable (" + path +").", null); //$NON-NLS-1$
			return;
		}

		URI uri = resource.getURI();
		String message = runDOT(uri);
		if (message != null) {
			resource.addError("DOT finished with \"" + message + "\"", null); //$NON-NLS-1$
		} else {
			final IProject project = WorkspaceSynchronizer.getFile(resource).getProject();
			try {
				project.refreshLocal(IProject.DEPTH_INFINITE, new NullProgressMonitor());
			} catch (CoreException e) {
				// Do nothing
			}
		}
	}

	private String runDOT(URI uri) {
		List<String> arguments = new ArrayList<String>();
		String file = uri.toPlatformString(false);
		if (file.startsWith("/")) //$NON-NLS-1$
			file = file.substring(1);

		arguments.add(dotExecutable);
		arguments.add("-Tpdf");//$NON-NLS-1$
		arguments.add("-O");//$NON-NLS-1$
		arguments.add(file);

		File workingDir = Platform.getLocation().toFile();

		RunCallback callback = new RunCallback();
		ExeUtil.runExe(arguments, callback, workingDir, true);

		if (callback.getExit() != 0)
			return callback.getStderr();

		return null;
	}

	private static String getDOTExecutable() {
		String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH); //$NON-NLS-1$
		if (os.startsWith("windows")) //$NON-NLS-1$
			return "dot.exe"; //$NON-NLS-1$
		return "dot"; //$NON-NLS-1$
	}

	private boolean testDOT() {
		List<String> arguments = new ArrayList<String>();

		arguments.add(dotExecutable);
		arguments.add("-V");//$NON-NLS-1$

		RunCallback callback = new RunCallback();
		ExeUtil.runExe(arguments, callback, true);

		return !callback.isError();
	}

	private class RunCallback implements
			org.emftext.language.dot.util.RunCallback {

		private int exit;
		private boolean error = false;

		private String stderr;

		public void exit(int exitCode) {
			exit = exitCode;
		}

		public void interrupted(InterruptedException ie) {
			error = true;
		}

		public void ioError(IOException ioe) {
			error = true;
		}

		public void result(Pair<String, String> pair) {
			stderr = pair.getRight();
		}

		public int getExit() {
			return exit;
		}

		public boolean isError() {
			return error;
		}

		public String getStderr() {
			return stderr;
		}

	}
}
