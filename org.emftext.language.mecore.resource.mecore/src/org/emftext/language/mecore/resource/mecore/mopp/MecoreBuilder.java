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

package org.emftext.language.mecore.resource.mecore.mopp;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.mecore.MPackage;
import org.emftext.language.mecore.resource.mecore.IMecoreBuilder;

public class MecoreBuilder implements IMecoreBuilder {
	
	public boolean isBuildingNeeded(URI uri) {
		return true;
	}
	
	public IStatus build(MecoreResource resource, IProgressMonitor monitor) {
		List<EObject> contents = resource.getContents();

		// read existing .ecore file (if there is one)
		EPackage existingEPackage = null;
		URI ecoreURI = resource.getURI().trimFileExtension().trimFileExtension().appendFileExtension("ecore");
		Resource ecoreResource;
		try {
			ecoreResource = resource.getResourceSet().getResource(ecoreURI, true);
		} catch (WrappedException e) {
			// can't load resource, probably it does not exist
			ecoreResource = resource.getResourceSet().createResource(ecoreURI);
		}
		if (!ecoreResource.getErrors().isEmpty()) {
			// if the .ecore file has errors, we do not run the build, because it will
			// override the existing file
			return org.eclipse.core.runtime.Status.CANCEL_STATUS;
		}
		
		List<EObject> ecoreContents = ecoreResource.getContents();
		if (!ecoreContents.isEmpty()) {
			EObject root = ecoreContents.get(0);
			if (root instanceof EPackage) {
				existingEPackage = (EPackage) root;
			}
		}
		
		MecoreWrapper wrapper = new MecoreWrapper();
		for (EObject eObject : contents) {
			if (eObject instanceof MPackage) {
				MPackage mPackage = (MPackage) eObject;
				ecoreContents.add(wrapper.wrapMPackage(mPackage, existingEPackage));
			}
		}
		try {
			ecoreResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
			return org.eclipse.core.runtime.Status.CANCEL_STATUS;
		}
		// TODO reload generator model (if it exists)
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}
	
}
