/*******************************************************************************
 * Copyright (c) 2006-2012
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

package org.emftext.language.java.ejava.resource.ejava.mopp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.ejava.EOperationWrapper;
import org.emftext.language.java.ejava.EPackageWrapper;
import org.emftext.language.java.ejava.resource.ejava.EjavaEProblemType;
import org.emftext.language.java.ejava.resource.ejava.IEjavaBuilder;
import org.emftext.language.java.ejava.resource.ejava.IEjavaTextPrinter;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.statements.Statement;

public class EjavaBuilder implements IEjavaBuilder {

	public boolean isBuildingNeeded(URI uri) {
		// return true to enable building of all resources
		return true;
	}

	public IStatus build(EjavaResource resource, IProgressMonitor monitor) {
		EjavaMarkerHelper.unmark(resource, EjavaEProblemType.BUILDER_ERROR);

		if (!resource.getContents().isEmpty()) {
			createBodyAnnotations(resource);
		}
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}


	private void createBodyAnnotations(EjavaResource resource) {
		EPackageWrapper ePackageWrapper = null;
		if (resource.getContents().get(0) instanceof EPackageWrapper) {
			ePackageWrapper = (EPackageWrapper) resource.getContents().get(0);
		}
		else {
			return;
		}

		EcoreUtil.resolveAll(resource);

		if (!resource.getErrors().isEmpty()) {
			return;
		}

		for(Resource r : new ArrayList<Resource>(resource.getResourceSet().getResources())) {
			if(!r.getContents().isEmpty()) {
				if(r.getContents().get(0) instanceof EPackageWrapper) {
					setToRealJavaPackage((EPackageWrapper) r.getContents().get(0));
				}
			}
		}

		resource.getResourceSet().getLoadOptions().put(
				JavaClasspath.OPTION_ALWAYS_USE_FULLY_QUALIFIED_NAMES, Boolean.TRUE);

		for(ConcreteClassifier concreteClassifier : ePackageWrapper.getClassifiers()) {
			for (Member member : concreteClassifier.getMembers()) {
				if (member instanceof EOperationWrapper) {
					EOperationWrapper wrapper = (EOperationWrapper) member;
					// TODO this is a temporary fix for a bug that was introduced in revision 13360
					//
					// the original intent of the fix was to allow empty method bodies, but the fix
					// causes problems when multiple eJava files refer to the same metamodel. In this
					// case, saving one eJava file removes all the method bodies that are defined in
					// the other eJava files from the Ecore model. This is because there are wrapper
					// objects for related methods, but their actual body is not known when building
					// one eJava file.
					if (wrapper.getStatements().isEmpty()) {
						continue;
					}
					EOperation eOperation = wrapper.getEOperation();
					EAnnotation genModelAnnotation = eOperation.getEAnnotation(GenModelPackage.eNS_URI);
					if (genModelAnnotation == null) {
						genModelAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
						eOperation.getEAnnotations().add(genModelAnnotation);
					}
					genModelAnnotation.setSource(GenModelPackage.eNS_URI);
					genModelAnnotation.getDetails().put("body", printBody(wrapper, resource));
					String documentation = "";
					for(String s : wrapper.getComments()) {
						s = s.trim();
						if (s.startsWith("/**") && s.endsWith("*/")) {
							s = s.substring(3, s.length() - 1);
							s = s.replaceAll("\n.*\\*", "\n");
							documentation += s;
						}

					}
					genModelAnnotation.getDetails().put("documentation", documentation);
				}
			}
		}

		final Resource ecoreResource = ePackageWrapper.getEPackage().eResource();
		try {
			ecoreResource.save(ecoreResource.getResourceSet().getLoadOptions());
		} catch (IOException e) {
			EjavaPlugin.logError("Error saving Ecore model: " + ecoreResource.getURI(), e);
		}
	}

	private void setToRealJavaPackage(EPackageWrapper wrapper) {
		// the only way to find the base package is to go to the genmodel
		wrapper.getNamespaces().clear();
		String basePackage = wrapper.getGenPackage().getBasePackage();
		if (basePackage == null) {
			basePackage = "";
		}
		wrapper.getNamespaces().addAll(
				Arrays.asList(basePackage.split("\\.")));
		wrapper.getNamespaces().add(wrapper.getEPackage().getName());

	}

	private String printBody(EOperationWrapper wrapper, EjavaResource resource) {
		byte[] lineBreak = System.getProperty("line.separator").getBytes();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		// we use a custom printer, because object instantiations need to be printed
		// differently from what is defined in ejava.cs
		IEjavaTextPrinter printer = new PlainJavaEjavaPrinter(outputStream, resource);
		for (Statement statement : wrapper.getStatements()) {
			try {
				printer.print(statement);
				outputStream.write(lineBreak);
			} catch (IOException e) {
				EjavaPlugin.logError("Error while printing eJava method body.", e);
			}
		}
		return outputStream.toString();
	}

	public IStatus handleDeletion(URI uri, IProgressMonitor monitor) {
		return Status.OK_STATUS;
	}
}
