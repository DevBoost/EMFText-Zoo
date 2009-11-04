/*******************************************************************************
 * Copyright (c) 2006-2009 
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

import java.io.OutputStream;

import org.emftext.language.java.ejava.EClassifierWrapper;
import org.emftext.language.java.ejava.EPackageWrapper;
import org.emftext.language.java.ejava.resource.ejava.IEjavaTextResource;
import org.emftext.language.java.ejava.resource.ejava.mopp.EjavaPrinter;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.types.TypeReference;

/**
 * A printer that prints EJava specific elements to corresponding
 * Java code by using information from the GenModel.
 *
 */
public class PlainJavaEjavaPrinter extends EjavaPrinter {

	public PlainJavaEjavaPrinter(OutputStream o, IEjavaTextResource resource) {
		super(o, resource);
	}
	
	public void print_org_emftext_language_java_ejava_EObjectInstantiation(org.emftext.language.java.ejava.EObjectInstantiation element, java.lang.String outertab, java.io.PrintWriter out) {
		TypeReference typeReference = element.getTypeReference();
		if(typeReference == null) {
			return;
		}
		Type type = typeReference.getTarget();
		
		if(!(type instanceof EClassifierWrapper)) {
			out.print("/* Can only instantiate EObjects */");
			return;
		}
		
		EClassifierWrapper classifierWrapper = (EClassifierWrapper) type;
		EPackageWrapper packageWrapper = (EPackageWrapper) classifierWrapper.eContainer();
		
		out.print(packageWrapper.getGenPackage().getBasePackage());
		out.print(".");
		out.print(packageWrapper.getEPackage().getName());
		out.print(".");
		out.print(packageWrapper.getGenPackage().getFactoryName());
		out.print(".eINSTANCE.create");
		out.print(classifierWrapper.getEClassifier().getName());
		out.print("()");
	}

}
