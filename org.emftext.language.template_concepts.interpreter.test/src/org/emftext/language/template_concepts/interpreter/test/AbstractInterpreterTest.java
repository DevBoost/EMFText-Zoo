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
package org.emftext.language.template_concepts.interpreter.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.template_concepts.Template;
import org.emftext.language.template_concepts.interpreter.InterpreterWithState;
import org.emftext.language.template_concepts.interpreter.exceptions.InterpreterException;

import junit.framework.TestCase;

public abstract class AbstractInterpreterTest extends TestCase {
	
	public void setUp() {
		registerResourceFactories();
	}

	protected void testInterpretation(String templateFileName, String customerFileName, String expectedResult) {
		try {
			ResourceSetImpl resourceSet = new ResourceSetImpl();
	
			String path = getInputFolder() + File.separator + customerFileName;
			Resource resource = resourceSet.createResource(URI.createFileURI(path));
			assertNotNull("Can't create resource for '" + path + "'- probably there is no suitable registered factory.", resource);
			resource.load(null);
			EObject customer = (EObject) resource.getContents().get(0);
			
			Resource templateResource = resourceSet.createResource(URI.createFileURI(getInputFolder() + File.separator + templateFileName));
			templateResource.load(null);
			Template template = (Template) templateResource.getContents().get(0);
			
			InterpreterWithState interpreterWithState;
			try {
				interpreterWithState = new InterpreterWithState(template, customer);
			} catch (InterpreterException e1) {
				fail(e1.getMessage());
				return;
			}
			EObject templateInstanceAST = interpreterWithState.getTemplateInstanceRoot();
			
			// pretty print templateInstanceAST
			String outputPath = "output." + getOutputFileExtension();
			Resource instance = resourceSet.createResource(URI.createURI(outputPath));
			assertNotNull("Can't create resource for '" + outputPath + "'- probably there is no suitable registered factory.", resource);
			instance.getContents().add(templateInstanceAST);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			instance.save(outputStream, null);
			
			// normalize output
			String result = new String(outputStream.toByteArray());
			result = result.replace("\n", "");
			result = result.replace("\r", "");
			result = result.replace("\t", "");
			result = result.replace("  ", " ");
			result = result.trim();
			
			System.out.println("AbstractInterpreterTest.testInterpretation() expected:\n" + expectedResult);
			System.out.println("AbstractInterpreterTest.testInterpretation() actual:\n" + result);
			// compare output with expected result
			assertEquals(expectedResult, result);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	protected abstract String getOutputFileExtension();
	protected abstract String getInputFolder();
	protected abstract void registerResourceFactories();
}
