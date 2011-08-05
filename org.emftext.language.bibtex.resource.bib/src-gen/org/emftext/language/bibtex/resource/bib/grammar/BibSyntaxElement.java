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
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class BibSyntaxElement {
	
	private BibSyntaxElement[] children;
	private BibSyntaxElement parent;
	private org.emftext.language.bibtex.resource.bib.grammar.BibCardinality cardinality;
	
	public BibSyntaxElement(org.emftext.language.bibtex.resource.bib.grammar.BibCardinality cardinality, BibSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (BibSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	public void setParent(BibSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	public BibSyntaxElement[] getChildren() {
		if (children == null) {
			return new BibSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public org.emftext.language.bibtex.resource.bib.grammar.BibCardinality getCardinality() {
		return cardinality;
	}
	
}
