/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0.mopp;

public class Pl0AntlrScanner implements org.emftext.language.pl0.resource.pl0.IPl0TextScanner {
	
	private org.antlr.runtime3_2_0.Lexer antlrLexer;
	
	public Pl0AntlrScanner(org.antlr.runtime3_2_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public org.emftext.language.pl0.resource.pl0.IPl0TextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_2_0.Token current = antlrLexer.nextToken();
		org.emftext.language.pl0.resource.pl0.IPl0TextToken result = new org.emftext.language.pl0.resource.pl0.mopp.Pl0TextToken(current);
		return result;
	}
	
	public void setText(java.lang.String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_2_0.ANTLRStringStream(text));
	}
	
}
