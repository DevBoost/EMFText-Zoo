/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class PlKeyword extends org.emftext.language.prolog.resource.pl.grammar.PlSyntaxElement {
	
	private final String value;
	
	public PlKeyword(String value, org.emftext.language.prolog.resource.pl.grammar.PlCardinality cardinality) {
		super(cardinality, null);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
}
