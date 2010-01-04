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
package org.emftext.language.dot;

import java.util.HashMap;
import java.util.Map;

import org.emftext.language.dot.resource.dot.IDotOptionProvider;
import org.emftext.language.dot.resource.dot.IDotOptions;

public class DotToolsOptionProvider implements IDotOptionProvider {

	public Map<?, ?> getOptions() {
		Map<Object, Object> options = new HashMap<Object, Object>();
		options.put(IDotOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new DotToolsProvider());
		return options;
	}

}
