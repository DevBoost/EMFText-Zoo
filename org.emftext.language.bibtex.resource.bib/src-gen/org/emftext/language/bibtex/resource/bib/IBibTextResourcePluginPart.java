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

package org.emftext.language.bibtex.resource.bib;

/**
 * This interface is extended by some other generated classes. It provides access
 * to the plug-in meta information.
 */
public interface IBibTextResourcePluginPart {
	
	/**
	 * Returns a meta information object for the language plug-in that contains this
	 * part.
	 */
	public org.emftext.language.bibtex.resource.bib.IBibMetaInformation getMetaInformation();
	
}
