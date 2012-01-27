/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class PlSyntaxElement {
	
	private PlSyntaxElement[] children;
	private PlSyntaxElement parent;
	private org.emftext.language.prolog.resource.pl.grammar.PlCardinality cardinality;
	
	public PlSyntaxElement(org.emftext.language.prolog.resource.pl.grammar.PlCardinality cardinality, PlSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (PlSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	public void setParent(PlSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	public PlSyntaxElement[] getChildren() {
		if (children == null) {
			return new PlSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public org.emftext.language.prolog.resource.pl.grammar.PlCardinality getCardinality() {
		return cardinality;
	}
	
}
