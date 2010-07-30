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
package org.emftext.language.java.ejava.resource;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.commons.NamespaceAwareElement;
import org.emftext.language.java.ejava.EClassifierWrapper;
import org.emftext.language.java.ejava.EOperationWrapper;
import org.emftext.language.java.ejava.EPackageWrapper;
import org.emftext.language.java.ejava.resource.ejava.EjavaEProblemType;
import org.emftext.language.java.ejava.resource.ejava.IEjavaOptionProvider;
import org.emftext.language.java.ejava.resource.ejava.IEjavaOptions;
import org.emftext.language.java.ejava.resource.ejava.IEjavaProblem;
import org.emftext.language.java.ejava.resource.ejava.IEjavaQuickFix;
import org.emftext.language.java.ejava.resource.ejava.IEjavaResourcePostProcessor;
import org.emftext.language.java.ejava.resource.ejava.IEjavaResourcePostProcessorProvider;
import org.emftext.language.java.ejava.resource.ejava.mopp.EjavaResource;
import org.emftext.language.java.ejava.util.EcoreWrapper;
import org.emftext.language.java.members.Member;

/**
 * Post processor that wraps the Ecore model for the eJava specification.
 */
public class EJavaPostProcessor implements IEjavaOptionProvider, IEjavaResourcePostProcessor, IEjavaResourcePostProcessorProvider {

	public Map<?, ?> getOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IEjavaOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new EJavaPostProcessor());
		return map;
	}

	public void process(EjavaResource resource) {
		EjavaResource eJavaResource = (EjavaResource) resource;
		EList<EObject> contents = resource.getContents();
		if (!contents.isEmpty()) {
			try {
				JavaClasspath cp = JavaClasspath.get(resource);
				File emfEcoreJarLocation  = FileLocator.getBundleFile(Platform.getBundle("org.eclipse.emf.ecore"));
				File emfCommonJarLocation = FileLocator.getBundleFile(Platform.getBundle("org.eclipse.emf.common"));
				URI emfEcoreJarURI  = URI.createFileURI(emfEcoreJarLocation.getCanonicalPath());
				URI emfCommonJarURI = URI.createFileURI(emfCommonJarLocation.getCanonicalPath());
				cp.registerClassifierJar(emfEcoreJarURI);
				cp.registerClassifierJar(emfCommonJarURI);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			EPackageWrapper ePackageWrapper = (EPackageWrapper) contents.get(0);
			EcoreWrapper.wrap(ePackageWrapper);
			validate(ePackageWrapper, eJavaResource);
		}
	}

	public IEjavaResourcePostProcessor getResourcePostProcessor() {
		return new EJavaPostProcessor();
	}
	
	
	private void validate(EPackageWrapper ePackageWrapper, EjavaResource resource) {
		if (ePackageWrapper.getEPackage() == null) {
			attachError(ePackageWrapper, resource);
		}
		
		
		for(ConcreteClassifier concreteClassifier : ePackageWrapper.getClassifiers()) {
			if (concreteClassifier instanceof EClassifierWrapper &&
					((EClassifierWrapper)concreteClassifier).getEClassifier() == null) {
				attachError(concreteClassifier, resource);
			}
			else {
				for(Member member : concreteClassifier.getMembers()) {
					if (member instanceof EOperationWrapper && 
							((EOperationWrapper)member).getEOperation() == null) {
						attachError(member, resource);
					}
				}
			}
		}
	}
	
	private void attachError(final NamedElement element, final EjavaResource resource) {
		resource.addProblem(new IEjavaProblem() {			
			public EjavaEProblemType getType() {
				return EjavaEProblemType.ERROR;
			}
			
			public String getMessage() {
				if (element instanceof NamespaceAwareElement) {
					return "Not declared in Ecore model: " + ((NamespaceAwareElement)element).getNamespaces();
				}
				return "Not declared in Ecore model: " + element.getName();
			}

			public IEjavaQuickFix getQuickFix() {
				return null;
			}
		}, element);
	}

}
