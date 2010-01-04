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

package org.emftext.language.formular.resource.formular.mopp;

import org.eclipse.emf.common.util.URI;
import org.emftext.language.formular.resource.formular.custom.GeneratingResourceProcessor;

public class FormularBuilder implements org.emftext.language.formular.resource.formular.IFormularBuilder {
	
	public org.eclipse.core.runtime.IStatus build(org.emftext.language.formular.resource.formular.mopp.FormularResource resource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		new GeneratingResourceProcessor().process(resource.getContents());
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}

	public boolean isBuildingNeeded(URI uri) {
		return true;
	}
	
}
