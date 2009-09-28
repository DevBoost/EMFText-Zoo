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
package org.emftext.language.c.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.emftext.language.simple_c.CPackage;
import org.emftext.language.simple_c.resource.c.ICOptions;

public class AbstractCTestCase extends TestCase {
	
	protected EObject loadResource(InputStream inputStream,
			String fileIdentifier, EClass type) throws IOException {
		
		EObject fragment = tryToLoadResource(inputStream, fileIdentifier, type);
		assertNotNull(fragment);
		assertSuccessfulParsing(fragment.eResource());
		return fragment;
	}

	protected EObject tryToLoadResource(InputStream inputStream,
			String fileIdentifier, EClass type) throws IOException {
		CResourceImplTestWrapper resource = new CResourceImplTestWrapper();
		Map<String,EClass> options = new HashMap<String,EClass>();
		if (type != null) {
			options.put(ICOptions.RESOURCE_CONTENT_TYPE, type);
		}
		resource.load(inputStream,options);
		assertEquals("The resource should have one content element.", 1,
				resource.getContents().size());
		EObject content = resource.getContents().get(0);
		//if null, type should be selected appropriately in parser
		if (type == null) {
			type = CPackage.eINSTANCE.getCompilationUnit();
		}
		assertTrue("File '" + fileIdentifier
				+ "' was parsed to " + type.getName() + ".",
				content.eClass() == type);
		return content;
	}

	private void assertSuccessfulParsing(Resource resource) {
		print(resource.getErrors());
		print(resource.getWarnings());
		assertEquals(0, resource.getErrors().size());
		assertEquals(0, resource.getWarnings().size());
	}

	private void print(EList<Diagnostic> diagnostics) {
		for (Diagnostic diagnostic : diagnostics) {
			System.out.println(diagnostic.getMessage());
		}
	}
}
