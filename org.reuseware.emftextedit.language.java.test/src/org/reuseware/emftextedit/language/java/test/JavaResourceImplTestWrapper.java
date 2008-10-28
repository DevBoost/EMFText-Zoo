/**
 * 
 */
package org.reuseware.emftextedit.language.java.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Map;

import org.reuseware.emftextedit.language.java.resource.java.JavaResourceImpl;

public class JavaResourceImplTestWrapper extends JavaResourceImpl {
	
	public void load(File javaFile) throws IOException {
		Map<?, ?> options = Collections.EMPTY_MAP;
		InputStream inputStream = new FileInputStream(javaFile);
		load(inputStream, options);
		inputStream.close();
	}
	
	public void save(File javaFile) throws IOException {
		Map<?, ?> options = Collections.EMPTY_MAP;
		OutputStream outputStream = new FileOutputStream(javaFile);
		save(outputStream, options);
		outputStream.close();
	}
}