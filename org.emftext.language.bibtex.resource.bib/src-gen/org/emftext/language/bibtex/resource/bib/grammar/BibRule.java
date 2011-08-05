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

package org.emftext.language.bibtex.resource.bib.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class BibRule extends org.emftext.language.bibtex.resource.bib.grammar.BibSyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public BibRule(org.eclipse.emf.ecore.EClass metaclass, org.emftext.language.bibtex.resource.bib.grammar.BibChoice choice, org.emftext.language.bibtex.resource.bib.grammar.BibCardinality cardinality) {
		super(cardinality, new org.emftext.language.bibtex.resource.bib.grammar.BibSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public org.emftext.language.bibtex.resource.bib.grammar.BibChoice getDefinition() {
		return (org.emftext.language.bibtex.resource.bib.grammar.BibChoice) getChildren()[0];
	}
	
}

