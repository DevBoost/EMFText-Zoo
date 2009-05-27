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
package org.emftext.language.simple_template.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.simple_template.interpreter.SimpleTemplateInterpreter;
import org.emftext.language.simple_template.interpreter.SimpleTemplateInterpreterImpl;
import org.junit.Test;
import org.emftext.language.simple_template.Template;
import org.emftext.language.simple_template.resource.simpletemplate.SimpletemplateResource;

public class TemplateInterpreterTest {
	
	@Test
	public void testInterpreter() {
		String templateFile = "input" + File.separator + "example.simpletemplate";
		Resource resource = null;
		try {
			resource = load(templateFile);
		} catch (IOException e) {
			// if the file can not be found, the working directory of
			// the test is probably wrong
			fail(e.getMessage());
		}
		assertEquals("The resource should have one content element.", 1,
				resource.getContents().size());
		EObject content = resource.getContents().get(0);
		assertNotNull(content);
		assertTrue("File '" + templateFile + "' was parsed to Template.",
				content instanceof Template);
		Template template = (Template) content;
		assertNotNull(template);
		// pass template to interpreter
		SimpleTemplateInterpreter interpreter = new SimpleTemplateInterpreterImpl();
		EObject result = interpreter.interprete(template, null);
		// TODO mboehme: check whether the template was instantiated correctly
	}

	private Resource load(String templateFile) throws IOException {
		Map<?, ?> options = Collections.EMPTY_MAP;
		InputStream inputStream = new FileInputStream(templateFile);
		SimpletemplateResource resource = new SimpletemplateResource();
		resource.load(inputStream, options);
		inputStream.close();
		return resource;
	}
}
