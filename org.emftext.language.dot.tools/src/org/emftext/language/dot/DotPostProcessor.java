package org.emftext.language.dot;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.URI;
import org.emftext.language.dot.util.ExeUtil;
import org.emftext.language.dot.util.Pair;
import org.emftext.runtime.IResourcePostProcessor;
import org.emftext.runtime.resource.ITextResource;

import org.eclipse.core.runtime.Platform;

public class DotPostProcessor implements IResourcePostProcessor {

	private static final String dotExecutable = getDOTExecutable();
	private static final Logger logger = Logger
			.getLogger(DotPostProcessor.class.getName());

	public void process(ITextResource resource) {
		if (!testDOT()) {
			// TODO externalize
			logger.severe("can't run dot. please check your path!"); //$NON-NLS-1$
			return;
		}

		URI uri = resource.getURI();
		String message = runDOT(uri);
		if (message != null)
			// TODO externalize
			logger.severe("dot finished with: " + message); //$NON-NLS-1$
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

		private String stdout;
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
			stdout = pair.getLeft();
			stderr = pair.getRight();
		}

		public int getExit() {
			return exit;
		}

		public boolean isError() {
			return error;
		}

		public String getStdout() {
			return stdout;
		}

		public String getStderr() {
			return stderr;
		}

	}
}
