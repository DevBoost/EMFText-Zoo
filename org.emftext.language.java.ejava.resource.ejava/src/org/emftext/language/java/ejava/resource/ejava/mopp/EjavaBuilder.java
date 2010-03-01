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

package org.emftext.language.java.ejava.resource.ejava.mopp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.ejava.EOperationWrapper;
import org.emftext.language.java.ejava.EPackageWrapper;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.statements.Statement;

public class EjavaBuilder implements org.emftext.language.java.ejava.resource.ejava.IEjavaBuilder {
	
	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri) {
		// change this to return true to enable building of all resources
		return true;
	}
	
	public org.eclipse.core.runtime.IStatus build(org.emftext.language.java.ejava.resource.ejava.mopp.EjavaResource resource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		if (!resource.getContents().isEmpty()) {
			createBodyAnnotations(resource);
		}
		// set option overrideBuilder to 'false' and then perform build here
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
			for(Member member : concreteClassifier.getMembers()) {
				if (member instanceof EOperationWrapper) {
					EOperationWrapper wrapper = (EOperationWrapper) member;
					if (!wrapper.getStatements().isEmpty()) {
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
		byte[] lineBreak = System.getProperty ("line.separator").getBytes();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		EjavaPrinter printer = new PlainJavaEjavaPrinter(outputStream, resource);
		for(Statement statement : wrapper.getStatements()) {
			printer.print(statement);
			try {
				outputStream.write(lineBreak);
			} catch (IOException e) {}
		}
		return outputStream.toString();
	}
	
}
