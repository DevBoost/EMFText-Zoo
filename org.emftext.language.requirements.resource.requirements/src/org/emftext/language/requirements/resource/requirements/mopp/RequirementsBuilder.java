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
package org.emftext.language.requirements.resource.requirements.mopp;

import java.security.acl.Owner;

import org.emftext.runtime.owltext.OWLTextValidationMarker;

public class RequirementsBuilder implements org.emftext.language.requirements.resource.requirements.IRequirementsBuilder {
	
	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri) {
		// change this to return true to enable building of all resources
		return true;
	}
	
	public org.eclipse.core.runtime.IStatus build(org.emftext.language.requirements.resource.requirements.mopp.RequirementsResource resource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		if (resource.getErrors().size() == 0) {
			OWLTextValidationMarker ovm = new OWLTextValidationMarker();
			ovm.annotateValidationResults(resource);
		}
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}
	
}
