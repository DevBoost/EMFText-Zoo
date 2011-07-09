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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreValidator;
import org.emftext.language.mecore.MModelElement;
import org.emftext.language.mecore.MPackage;
import org.emftext.language.mecore.resource.mecore.IMecoreBuilder;
import org.emftext.language.mecore.resource.mecore.MecoreEProblemType;

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
				existingEPackage = wrapper.wrapMPackage(mPackage, existingEPackage);
				ecoreContents.add(existingEPackage);
			}
		}
		try {
			ecoreResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
			return org.eclipse.core.runtime.Status.CANCEL_STATUS;
		}
		// TODO reload generator model (if it exists)
		
		// run Ecore validation and map result back to .mecore file
		Map<Object, Object> context = new LinkedHashMap<Object, Object>();
		TreeIterator<EObject> allContents = ecoreResource.getAllContents();
		while (allContents.hasNext()) {
			EObject next = (EObject) allContents.next();
			BasicDiagnostic diagnostics = new BasicDiagnostic();
			boolean result = EcoreValidator.INSTANCE.validate(next, diagnostics, context);
			if (!result) {
				processDiagnostics(resource, wrapper, diagnostics);
			}
		}
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}

	private void processDiagnostics(MecoreResource resource, MecoreWrapper wrapper, Diagnostic diagnostics) {
		String message = diagnostics.getMessage();
		List<?> data = diagnostics.getData();
		if (data != null) {
			for (Object object : data) {
				if (object instanceof EObject) {
					// find element in .mecore file that caused the problem
					EObject causingEObject = (EObject) object;
					EObject causingMObject = findKey(wrapper.getMapping(), causingEObject);
					if (causingMObject != null) {
						// attach a problem marker
						if (diagnostics.getSeverity() == Diagnostic.ERROR) {
							resource.addError(message, MecoreEProblemType.BUILDER_ERROR, causingMObject);
						} else if (diagnostics.getSeverity() == Diagnostic.WARNING) {
							resource.addWarning(message, MecoreEProblemType.BUILDER_ERROR, causingMObject);
						}
					}
				}
			}
		}
		for (Diagnostic child : diagnostics.getChildren()) {
			processDiagnostics(resource, wrapper, child);
		}
	}

	private EObject findKey(Map<MModelElement, EModelElement> mapping, EObject value) {
		for (MModelElement mElement : mapping.keySet()) {
			EModelElement eElement = mapping.get(mElement);
			if (value == eElement) {
				return mElement;
			}
		}
		return null;
	}
}
