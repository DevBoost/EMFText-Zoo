package org.emftext.language.java.test.bulk;

import java.io.IOException;

import junit.framework.Test;

import org.eclipse.core.runtime.CoreException;

public class SunJDKTest extends AbstractZipFileInputTest {
	
	public static final String TEST_FOLDER = "sun_jdk_1.5.0_16";
	public static final String START_ENTRY = "BMPImageReader.java";
	public static final int    THREAD_NO   = 1;
	
	public static Test suite() throws CoreException, IOException {
		return constructSuite(TEST_FOLDER, START_ENTRY, THREAD_NO);
	}
}
