/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.grammar;

public class PlCompound extends org.emftext.language.prolog.resource.pl.grammar.PlSyntaxElement {
	
	public PlCompound(org.emftext.language.prolog.resource.pl.grammar.PlChoice choice, org.emftext.language.prolog.resource.pl.grammar.PlCardinality cardinality) {
		super(cardinality, new org.emftext.language.prolog.resource.pl.grammar.PlSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
