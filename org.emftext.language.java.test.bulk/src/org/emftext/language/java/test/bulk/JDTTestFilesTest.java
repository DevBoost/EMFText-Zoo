package org.emftext.language.java.test.bulk;

import java.io.IOException;

import junit.framework.Test;

import org.eclipse.core.runtime.CoreException;

public class JDTTestFilesTest extends AbstractZipFileInputTest {

	public static final String TEST_FOLDER = "jdt_test_files";
	public static final String START_ENTRY = "4269/X.java";
	public static final int    THREAD_NO   = 1;
	
	public static Test suite() throws CoreException, IOException {
		return constructSuite(TEST_FOLDER, START_ENTRY, THREAD_NO);
	}
	
}
