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
package org.emftext.language.bibtex.resource.bib.analysis;

public class EntryBibtexKeyReferenceResolver implements org.emftext.language.bibtex.resource.bib.IBibReferenceResolver<org.emftext.language.bibtex.Entry, org.emftext.language.bibtex.BibtexKeyField> {
	
	private org.emftext.language.bibtex.resource.bib.analysis.BibDefaultResolverDelegate<org.emftext.language.bibtex.Entry, org.emftext.language.bibtex.BibtexKeyField> delegate = new org.emftext.language.bibtex.resource.bib.analysis.BibDefaultResolverDelegate<org.emftext.language.bibtex.Entry, org.emftext.language.bibtex.BibtexKeyField>();
	
	public void resolve(String identifier, org.emftext.language.bibtex.Entry container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.bibtex.resource.bib.IBibReferenceResolveResult<org.emftext.language.bibtex.BibtexKeyField> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.bibtex.BibtexKeyField element, org.emftext.language.bibtex.Entry container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
