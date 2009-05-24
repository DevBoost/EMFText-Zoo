package org.emftext.language.java.test.bulk;

import java.io.IOException;

import junit.framework.Test;

import org.eclipse.core.runtime.CoreException;

public class Eclipse341Test extends AbstractZipFileInputTest {
	
	public static final String TEST_FOLDER = "eclipse-3.4.1";
	public static final String START_ENTRY = "/ClassFileEditor.java";
	public static final int    THREAD_NO   = 1;
	
	public static Test suite() throws CoreException, IOException {
		return constructSuite(TEST_FOLDER, START_ENTRY, THREAD_NO);
	}
}
