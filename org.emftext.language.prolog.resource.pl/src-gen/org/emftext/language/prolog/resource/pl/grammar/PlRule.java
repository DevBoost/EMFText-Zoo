/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class PlRule extends org.emftext.language.prolog.resource.pl.grammar.PlSyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public PlRule(org.eclipse.emf.ecore.EClass metaclass, org.emftext.language.prolog.resource.pl.grammar.PlChoice choice, org.emftext.language.prolog.resource.pl.grammar.PlCardinality cardinality) {
		super(cardinality, new org.emftext.language.prolog.resource.pl.grammar.PlSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public org.emftext.language.prolog.resource.pl.grammar.PlChoice getDefinition() {
		return (org.emftext.language.prolog.resource.pl.grammar.PlChoice) getChildren()[0];
	}
	
}

