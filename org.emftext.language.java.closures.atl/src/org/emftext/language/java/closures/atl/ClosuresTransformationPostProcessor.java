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
package org.emftext.language.java.closures.atl;


import java.util.HashMap;
import java.util.Map;

import org.emftext.util.atl.ATLTransformationPostProcessor;

public class ClosuresTransformationPostProcessor extends ATLTransformationPostProcessor {
	
	@Override
	protected Map<String, String> getMetamodelURIs() {
		Map<String, String> metamodels = new HashMap<String, String>();
		metamodels.put("Closures",
				"http://emftext.org/language/closures");
		return metamodels;
	}

	@Override
	protected String getTransformationURI() {
		return "platform:/resource/org.emftext.language.java.closures.atl/transformations/assimilator.asm";
	}

	@Override
	protected String getInMetamodelName() {
		return "Closures";
	}

	@Override
	protected String getOutMetamodelName() {
		return "Java";
	}

	@Override
	protected String getOutputURI() {
		String fileExtension = currentResource.getURI().fileExtension();
		String currentUri = currentResource.getURI().toPlatformString(true);
		String newUri = currentUri.substring(0, currentUri.length() - fileExtension.length() - 1);
		newUri += ".java";
			return newUri;
		}

}
