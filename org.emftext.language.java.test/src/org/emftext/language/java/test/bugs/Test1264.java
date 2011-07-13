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
package org.emftext.language.java.test.bugs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.commons.Commentable;
import org.emftext.language.java.containers.ContainersFactory;
import org.junit.Test;

public class Test1264 extends AbstractTest {

	public Test1264() {
		super();
	}
	
	@Test
	public void testGetConcreteClassifierProxy() {
		ResourceSet rs = getResourceSet();
		Commentable commentable = ContainersFactory.eINSTANCE.createCompilationUnit();
		Resource r = rs.createResource(URI.createURI("test.java"));
		r.getContents().add(commentable);
		
		ConcreteClassifier result = commentable.getConcreteClassifierProxy("java.lang.Object");
		assertTrue(result.eIsProxy());
	}
	
	@Test
	public void testGetConcreteClassifierProxies() {
		ResourceSet rs = getResourceSet();
		Commentable commentable = ContainersFactory.eINSTANCE.createCompilationUnit();
		Resource r = rs.createResource(URI.createURI("test.java"));
		r.getContents().add(commentable);
		
		EList<ConcreteClassifier> result = 
			commentable.getConcreteClassifierProxies("java.lang","Object");
		assertEquals(1, result.size());
		assertTrue(result.get(0).eIsProxy());
	}
	
	@Test
	public void testGetConcreteClassifier() {
		ResourceSet rs = getResourceSet();
		Commentable commentable = ContainersFactory.eINSTANCE.createCompilationUnit();
		Resource r = rs.createResource(URI.createURI("test.java"));
		r.getContents().add(commentable);
		
		ConcreteClassifier result = commentable.getConcreteClassifier("java.lang.Object");
		assertTrue(!result.eIsProxy());
		assertEquals("Object", result.getName());
		assertEquals(14, result.getMembers().size());	
	}
	
	@Test
	public void testGetConcreteClassifiers() {
		ResourceSet rs = getResourceSet();
		Commentable commentable = ContainersFactory.eINSTANCE.createCompilationUnit();
		Resource r = rs.createResource(URI.createURI("test.java"));
		r.getContents().add(commentable);
		
		EList<ConcreteClassifier> result = 
			commentable.getConcreteClassifiers("java.lang","Object");
		assertEquals(1, result.size());
		assertTrue(!result.get(0).eIsProxy());
		assertEquals("Object", result.get(0).getName());
		assertEquals(14, result.get(0).getMembers().size());	
	}

}
