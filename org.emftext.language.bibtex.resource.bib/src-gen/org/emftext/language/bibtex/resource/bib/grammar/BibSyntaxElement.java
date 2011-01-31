/**
 * <copyright>
 * </copyright>
 *
 * 
 */
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
