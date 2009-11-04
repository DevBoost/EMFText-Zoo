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
package org.emftext.language.forms.resource.forms.custom;

import java.util.HashMap;
import java.util.Map;

import org.emftext.language.forms.resource.forms.IFormsOptionProvider;
import org.emftext.language.forms.resource.forms.IFormsOptions;

public class FormsLanguageOptionProvider implements IFormsOptionProvider {

	public FormsLanguageOptionProvider() {
	}

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(IFormsOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new GeneratingResourceProcessor());
		return options;
	}

}
