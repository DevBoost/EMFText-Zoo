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
package org.emftext.language.sparql.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.emftext.language.sparql.resource.sparql.mopp.SparqlResource;

public class ForceEOFTest extends AbstractSparqlTestCase {
	
	private static final String TEST_INPUT_FROM_MEMORY = "int x;;";

	public void testForceEOF() {
		try {
			SparqlResource resource = load(new ByteArrayInputStream(TEST_INPUT_FROM_MEMORY.getBytes()));
			assertTrue("Additional semicolon at the end should prevent successful parsing", resource.getErrors().size() > 0);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	@Override
	public String getTestInputFolder() {
		return null;
	}
}
