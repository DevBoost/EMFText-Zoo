/*******************************************************************************
 * Copyright (c) 2006-2009 
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
package org.emftext.language.formular.resource.formular.custom;

import java.util.HashMap;
import java.util.Map;

import org.emftext.language.formular.resource.formular.IFormularOptionProvider;
import org.emftext.language.formular.resource.formular.IFormularOptions;

public class FormularLanguageOptionProvider implements IFormularOptionProvider {

	public FormularLanguageOptionProvider() {
	}

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(IFormularOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new GeneratingResourceProcessor());
		return options;
	}

}
