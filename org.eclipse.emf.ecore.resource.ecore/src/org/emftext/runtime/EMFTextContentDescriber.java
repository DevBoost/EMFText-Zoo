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
package org.emftext.runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.internal.content.TextContentDescriber;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.content.IContentDescriber;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.core.runtime.content.ITextContentDescriber;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.emf.ecore.resource.ecore.EcoreResourceFactory;
import org.eclipse.emf.common.util.URI;

public class EMFTextContentDescriber implements IContentDescriber, ITextContentDescriber {
	static {
		// TODO This is quite a hack, can we do this better?
		//
		// We remove the standard Ecore XMI factory from the extension map
		// It blocked the selection of content type based factories. This 
		// however was necessary to contribute the EMFText-based syntax
		// for ecore.
		// In this setting the standard ecore factory is still used for Ecore XMI files, since
		// it is also registered as a content type-based factory.
		Registry registry = Resource.Factory.Registry.INSTANCE;
		registry.getExtensionToFactoryMap().remove("ecore");
	}
	
	public int describe(Reader arg0, IContentDescription arg1)
	throws IOException {
		BufferedReader reader = new BufferedReader(arg0);
		return checkForSimpleTextFile(reader, arg1);
	}
	
	public int describe(InputStream arg0, IContentDescription arg1)
		throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(arg0));
		
		return checkForSimpleTextFile(reader, arg1);
	}

	private int checkForSimpleTextFile(BufferedReader reader, IContentDescription description) throws IOException {
		
		String line;
		while ((line = reader.readLine()) != null) {
			// skip empty lines
			if (line.trim().length() == 0) continue;
			// TODO should/can we distinguish xml syntaxes build with EmfText?
			// if xml found do not use EmfText
			if (line.trim().startsWith("<?xml")) {
				return INVALID;
			}
			else {
				return VALID;
			}
		}
		// empty files can not be described
		return INDETERMINATE;
	}

	public QualifiedName[] getSupportedOptions() {
		return new QualifiedName[]{};
	}

	


}
