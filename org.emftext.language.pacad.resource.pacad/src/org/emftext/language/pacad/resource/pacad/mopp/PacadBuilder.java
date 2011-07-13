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
package org.emftext.language.pacad.resource.pacad.mopp;

import org.emftext.language.pacad.resource.pacad.PacadConstraintChecker;

public class PacadBuilder implements org.emftext.language.pacad.resource.pacad.IPacadBuilder {
	
	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri) {
		return true;
	}
	
	public org.eclipse.core.runtime.IStatus build(org.emftext.language.pacad.resource.pacad.mopp.PacadResource resource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		new PacadConstraintChecker().check(resource);
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}
}
