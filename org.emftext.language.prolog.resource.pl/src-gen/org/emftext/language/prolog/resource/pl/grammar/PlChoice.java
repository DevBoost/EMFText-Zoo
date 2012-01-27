/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.grammar;

public class PlChoice extends org.emftext.language.prolog.resource.pl.grammar.PlSyntaxElement {
	
	public PlChoice(org.emftext.language.prolog.resource.pl.grammar.PlCardinality cardinality, org.emftext.language.prolog.resource.pl.grammar.PlSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return org.emftext.language.prolog.resource.pl.util.PlStringUtil.explode(getChildren(), "|");
	}
	
}
