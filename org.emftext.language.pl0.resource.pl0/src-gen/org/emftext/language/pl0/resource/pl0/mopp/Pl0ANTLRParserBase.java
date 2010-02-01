/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0.mopp;

public abstract class Pl0ANTLRParserBase extends org.antlr.runtime3_2_0.Parser implements org.emftext.language.pl0.resource.pl0.IPl0TextParser {
	
	public Pl0ANTLRParserBase(org.antlr.runtime3_2_0.TokenStream input) {
		super(input);
	}
	
	public Pl0ANTLRParserBase(org.antlr.runtime3_2_0.TokenStream input, org.antlr.runtime3_2_0.RecognizerSharedState state) {
		super(input, state);
	}
	
}
