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

package org.emftext.language.bibtex.resource.bib.util;

/**
 * Class BibTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * org.emftext.language.bibtex.resource.bib.util.BibResourceUtil.
 */
public class BibTextResourceUtil {
	
	@Deprecated	
	public static org.emftext.language.bibtex.resource.bib.mopp.BibResource getResource(org.eclipse.core.resources.IFile file) {
		return org.emftext.language.bibtex.resource.bib.util.BibResourceUtil.getResource(file);
	}
	
	@Deprecated	
	public static org.emftext.language.bibtex.resource.bib.mopp.BibResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return org.emftext.language.bibtex.resource.bib.util.BibResourceUtil.getResource(file, options);
	}
	
	@Deprecated	
	public static org.emftext.language.bibtex.resource.bib.mopp.BibResource getResource(org.eclipse.emf.common.util.URI uri) {
		return org.emftext.language.bibtex.resource.bib.util.BibResourceUtil.getResource(uri);
	}
	
	@Deprecated	
	public static org.emftext.language.bibtex.resource.bib.mopp.BibResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return org.emftext.language.bibtex.resource.bib.util.BibResourceUtil.getResource(uri, options);
	}
	
}
