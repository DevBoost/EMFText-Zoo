package org.eclipse.emf.ecore.resource.ecore.customized;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ecore.EcoreResource;

public class CustomizedEcoreResource extends EcoreResource {

	private Object textPrintAfterLoading;

	public CustomizedEcoreResource() {
		super();
	}
	
	public CustomizedEcoreResource(URI uri) {
		super(uri);
	}

	protected void doLoad(InputStream inputStream, Map<?,?> options) throws java.io.IOException {
		super.doLoad(inputStream, options);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		doSave(outputStream, options);
		textPrintAfterLoading = outputStream.toString();
	}
	
	protected void saveOnlyIfChangedWithMemoryBuffer(Map<?, ?> options) throws IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		doSave(outputStream, options);
		String currentPrint = outputStream.toString();
		if (textPrintAfterLoading != null && textPrintAfterLoading.equals(currentPrint)) {
			return;
		} else {
			super.saveOnlyIfChangedWithFileBuffer(options);
		}
	}
}
