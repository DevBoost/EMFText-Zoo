/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.grammar;

public class PlSequence extends org.emftext.language.prolog.resource.pl.grammar.PlSyntaxElement {
	
	public PlSequence(org.emftext.language.prolog.resource.pl.grammar.PlCardinality cardinality, org.emftext.language.prolog.resource.pl.grammar.PlSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return org.emftext.language.prolog.resource.pl.util.PlStringUtil.explode(getChildren(), " ");
	}
	
}
