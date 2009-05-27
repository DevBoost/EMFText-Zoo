/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.language.ecore.resource.ecore.customized;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.emftext.language.ecore.resource.ecore.EcoreResource;

/**
 * This is an experimental subclass of EcoreResource. In contrast
 * to the original (generated) EcoreResource, this class can properly
 * detect whether changes were made to the contents of the resource 
 * or not. To do so, the resource is printed after loading and the 
 * result is stored. Later on, when this resource is asked to save
 * itself if changes were made, the resource prints its content 
 * again and compares the result with the initial print that was
 * obtained after loading.
 * 
 * This implementation was mainly motivated by the fact, that Ecore
 * models are used in conjunction with EMF generator models to generate
 * code. Unfortunately the EMF generator models must be reloaded after 
 * changes were made to the Ecore model. During this process of 
 * reloading the model, EMF asks the EcoreResource to save itself 
 * whenever changes were made. The default implementation of 
 * EcoreResource wrongly detects changes because it compares the
 * original text that was parsed with a print of the contents.
 * These two string can differ, even though the contents
 * of the resource are the same. This behavior is caused by additional
 * characters (whitespace or comments) that are not reflected in the
 * resources content. By using this custom EcoreResource the additional
 * characters are preserved when generator models are reloaded.
 */
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
		textPrintAfterLoading = getPrint(options);
	}

	protected void saveOnlyIfChangedWithMemoryBuffer(Map<?, ?> options) throws IOException {
		String currentPrint = getPrint(options);
		if (textPrintAfterLoading != null && textPrintAfterLoading.equals(currentPrint)) {
			return;
		} else {
			super.saveOnlyIfChangedWithFileBuffer(options);
		}
	}

	private String getPrint(Map<?, ?> options) throws IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		doSave(outputStream, options);
		return outputStream.toString();
	}
}
