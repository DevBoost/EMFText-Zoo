package org.emftext.language.c_sharp.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.emftext.language.c_sharp.resource.csharp.CsharpResource;

public class CSharpResourceImplTestWrapper extends CsharpResource {
	
	public CSharpResourceImplTestWrapper(URI uri){
		super(uri);
	}
	
	public void load(File cFile) throws IOException {
		Map<?, ?> options = Collections.EMPTY_MAP;
		InputStream inputStream = new FileInputStream(cFile);
		load(inputStream, options);
		inputStream.close();
	}
	
	public void save(File cFile) throws IOException {
		Map<?, ?> options = Collections.EMPTY_MAP;
		OutputStream outputStream = new FileOutputStream(cFile);
		save(outputStream, options);
		outputStream.close();
	}
}