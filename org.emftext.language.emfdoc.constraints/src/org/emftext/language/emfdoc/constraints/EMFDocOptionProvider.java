/*******************************************************************************
 * Copyright (c) 2006-2011
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
package org.emftext.language.emfdoc.constraints;

import java.util.Collections;
import java.util.Map;

import org.emftext.language.emfdoc.resource.emfdoc.IEmfdocOptionProvider;
import org.emftext.language.emfdoc.resource.emfdoc.IEmfdocOptions;
import org.emftext.language.emfdoc.resource.emfdoc.IEmfdocResourcePostProcessor;
import org.emftext.language.emfdoc.resource.emfdoc.IEmfdocResourcePostProcessorProvider;

public class EMFDocOptionProvider implements IEmfdocOptionProvider, IEmfdocResourcePostProcessorProvider {

	public Map<?, ?> getOptions() {
		return Collections.singletonMap(IEmfdocOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
	}

	public IEmfdocResourcePostProcessor getResourcePostProcessor() {
		return new EMFDocConstraintChecker();
	}
}
