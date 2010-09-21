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
package org.emftext.language.formsembedded.resource;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.formsembedded.resource.formsembedded.IFormsembeddedOptionProvider;
import org.emftext.language.formsembedded.resource.formsembedded.IFormsembeddedOptions;
import org.emftext.language.formsembedded.resource.formsembedded.IFormsembeddedResourcePostProcessor;
import org.emftext.language.formsembedded.resource.formsembedded.IFormsembeddedResourcePostProcessorProvider;
import org.emftext.language.formsembedded.resource.formsembedded.mopp.FormsembeddedContextDependentURIFragmentFactory;
import org.emftext.language.formsembedded.resource.formsembedded.mopp.FormsembeddedReferenceResolverSwitch;
import org.emftext.language.formsembedded.resource.formsembedded.mopp.FormsembeddedResource;
import org.emftext.language.java.references.ElementReference;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.resource.util.JDTConnector;
import org.emftext.language.java.util.JavaModelCompletion;
import org.emftext.language.java.util.JavaModelRepairer;

/**
 * Post processor that performs 
 * <i>cast repair</i>,
 * <i>expression simplification</i> and 
 * <i>java model completion</i>
 * on a resource after parsing using the JavaModelRepairer.
 */
public class FormsembeddedPostProcessor implements IFormsembeddedOptionProvider, IFormsembeddedResourcePostProcessor, IFormsembeddedResourcePostProcessorProvider {
	
	public void process(FormsembeddedResource resource) {
		JDTConnector.getInstance().initializeResourceSet(resource.getResourceSet(), resource.getURI());
		new JavaModelRepairer() {
			protected void registerContextDependentProxy(
					Resource resource,
					IdentifierReference mainIdReference, EReference targetReference,
					String id, EObject proxy) {
				((FormsembeddedResource)resource).registerContextDependentProxy(
						new FormsembeddedContextDependentURIFragmentFactory<ElementReference, ReferenceableElement>(new FormsembeddedReferenceResolverSwitch().getElementReferenceTargetReferenceResolver()),
						mainIdReference,
						targetReference,
						id,
						proxy);
			}
		}.repair(resource);
		
		JavaModelCompletion.complete(resource);
	}

	public Map<?, ?> getOptions() {
		return Collections.singletonMap(IFormsembeddedOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
	}
	
	public IFormsembeddedResourcePostProcessor getResourcePostProcessor() {
		return this;
	}
}
