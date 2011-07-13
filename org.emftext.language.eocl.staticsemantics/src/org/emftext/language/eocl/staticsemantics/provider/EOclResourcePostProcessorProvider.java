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
package org.emftext.language.eocl.staticsemantics.provider;

import org.emftext.language.eocl.resource.eocl.IEoclResourcePostProcessor;
import org.emftext.language.eocl.resource.eocl.IEoclResourcePostProcessorProvider;

public class EOclResourcePostProcessorProvider implements
		IEoclResourcePostProcessorProvider {

	private IEoclResourcePostProcessor oclResourcePostProcessor;

	public EOclResourcePostProcessorProvider() {
		oclResourcePostProcessor = new EOclStaticSemanticsPostProcessor();
	}

	public IEoclResourcePostProcessor getResourcePostProcessor() {
		return oclResourcePostProcessor;
	}

}
