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
package org.emftext.language.java.ejava.resource.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.java.ejava.resource.ejava.IEjavaOptionProvider;
import org.emftext.language.java.ejava.resource.ejava.IEjavaOptions;
import org.emftext.language.java.ejava.resource.ejava.IEjavaResourcePostProcessor;
import org.emftext.language.java.ejava.resource.ejava.IEjavaResourcePostProcessorProvider;
import org.emftext.language.java.ejava.resource.ejava.mopp.EjavaContextDependentURIFragmentFactory;
import org.emftext.language.java.ejava.resource.ejava.mopp.EjavaReferenceResolverSwitch;
import org.emftext.language.java.ejava.resource.ejava.mopp.EjavaResource;
import org.emftext.language.java.references.ElementReference;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.util.JavaModelCompletion;
import org.emftext.language.java.util.JavaModelRepairer;

/**
 * Post processor that performs 
 * <i>cast repair</i>,
 * <i>expression simplification</i> and 
 * <i>java model completion</i>
 * on a resource after parsing using the JavaModelRepairer.
 */
public class EJavaPostProcessor implements IEjavaOptionProvider, IEjavaResourcePostProcessor, IEjavaResourcePostProcessorProvider {
	
	public Map<?, ?> getOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IEjavaOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return map;
	}

	public void process(EjavaResource resource) {
		new JavaModelRepairer() {
			protected void registerContextDependentProxy(
					Resource resource,
					IdentifierReference mainIdReference, EReference targetReference,
					String id, EObject proxy) {
				((EjavaResource)resource).registerContextDependentProxy(
						new EjavaContextDependentURIFragmentFactory<ElementReference, ReferenceableElement>(new EjavaReferenceResolverSwitch().getElementReferenceTargetReferenceResolver()),
						mainIdReference,
						targetReference,
						id,
						proxy);
			}
		}.repair(resource);
		
		JavaModelCompletion.complete(resource);
		JavaModelCompletion.complete(resource);
	}

	public IEjavaResourcePostProcessor getResourcePostProcessor() {
		return this;
	}
}
