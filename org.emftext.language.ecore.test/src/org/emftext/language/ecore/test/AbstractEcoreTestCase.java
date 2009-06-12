/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.language.ecore.test;

import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class AbstractEcoreTestCase extends TestCase {
		
	protected EPackage loadResource(String path,
			String fileIdentifier) throws IOException {
		
		Resource resource = tryToLoadResource(path, fileIdentifier);
		assertEquals("The resource should have one content element.", 1,
				resource.getContents().size());
		EObject content = resource.getContents().get(0);
		assertTrue("File '" + fileIdentifier
				+ "' was parsed to EPackage.",
				content instanceof EPackage);
		EPackage ePackage = (EPackage) content;
		assertNotNull(ePackage);
		assertSuccessfulParsing(ePackage.eResource());
		return ePackage;
	}

	protected Resource tryToLoadResource(String path,
			String fileIdentifier) throws IOException {
		
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(URI.createURI(path), true);
		return resource;
	}

	private void assertSuccessfulParsing(Resource resource) {
		print(resource.getErrors());
		print(resource.getWarnings());
		assertEquals(0, resource.getErrors().size());
		assertEquals(0, resource.getWarnings().size());
	}

	private void print(EList<Diagnostic> diagnostics) {
		for (Diagnostic diagnostic : diagnostics) {
			System.out.println(diagnostic.getMessage() + " at " + diagnostic.getLine() + ":" + diagnostic.getColumn());
		}
	}
}
