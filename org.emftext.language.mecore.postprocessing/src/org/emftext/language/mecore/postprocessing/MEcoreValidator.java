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
package org.emftext.language.mecore.postprocessing;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.mecore.MDataType;
import org.emftext.language.mecore.MFeature;
import org.emftext.language.mecore.MNamedElement;
import org.emftext.language.mecore.MecorePackage;
import org.emftext.language.mecore.resource.mecore.IMecoreOptionProvider;
import org.emftext.language.mecore.resource.mecore.IMecoreOptions;
import org.emftext.language.mecore.resource.mecore.IMecoreProblem;
import org.emftext.language.mecore.resource.mecore.IMecoreResourcePostProcessor;
import org.emftext.language.mecore.resource.mecore.IMecoreResourcePostProcessorProvider;
import org.emftext.language.mecore.resource.mecore.MecoreEProblemSeverity;
import org.emftext.language.mecore.resource.mecore.MecoreEProblemType;
import org.emftext.language.mecore.resource.mecore.mopp.MecoreProblem;
import org.emftext.language.mecore.resource.mecore.mopp.MecoreResource;
import org.emftext.language.mecore.resource.mecore.util.MecoreEObjectUtil;

/**
 * The MEcoreValidator checks some basic constraints that are not captured by 
 * the EMF EcoreValidator that is called by the builder to check all Ecore 
 * constraints.
 */
public class MEcoreValidator implements IMecoreOptionProvider, IMecoreResourcePostProcessorProvider, IMecoreResourcePostProcessor {

	public void process(MecoreResource resource) {
		List<EObject> internalContents = resource.getContentsInternal();
		for (EObject eObject : internalContents) {
			validateFeatureTypes(resource, eObject);
			validateUniqueNames(resource, eObject);
		}
	}

	private void validateFeatureTypes(MecoreResource resource, EObject eObject) {
		Collection<MFeature> features = MecoreEObjectUtil.getObjectsByType(eObject.eAllContents(), MecorePackage.eINSTANCE.getMFeature());
		for (MFeature feature : features) {
			if (feature.getType() instanceof MDataType &&
				feature.isReference()) {
				IMecoreProblem problem = new MecoreProblem(
						"Attributes cannot be tagged as non-containment. Remove the tilde.", 
						MecoreEProblemType.ANALYSIS_PROBLEM, 
						MecoreEProblemSeverity.ERROR
				);
				resource.addProblem(problem, feature);
			}
		}
	}

	private void validateUniqueNames(MecoreResource resource, EObject eObject) {
		List<EObject> children = eObject.eContents();
		Map<String, EObject> nameToObjectMap = new LinkedHashMap<String, EObject>();
		for (EObject child : children) {
			if (child instanceof MNamedElement) {
				MNamedElement namedChild = (MNamedElement) child;
				String name = namedChild.getName();
				if (nameToObjectMap.containsKey(name)) {
					// found duplicate child
					IMecoreProblem problem = new MecoreProblem(
							"Found element with duplicate name (" + name + ").", 
							MecoreEProblemType.ANALYSIS_PROBLEM,
							MecoreEProblemSeverity.ERROR
					);
					resource.addProblem(problem, namedChild);
				} else {
					nameToObjectMap.put(name, namedChild);
				}
			}
			validateUniqueNames(resource, child);
		}
	}

	public Map<?, ?> getOptions() {
		return Collections.singletonMap(IMecoreOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
	}

	public IMecoreResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public void terminate() {
		// do nothing
	}
}
