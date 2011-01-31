/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.mopp;

public class BibAntlrScanner implements org.emftext.language.bibtex.resource.bib.IBibTextScanner {
	
	private org.antlr.runtime3_2_0.Lexer antlrLexer;
	
	public BibAntlrScanner(org.antlr.runtime3_2_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public org.emftext.language.bibtex.resource.bib.IBibTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_2_0.Token current = antlrLexer.nextToken();
		org.emftext.language.bibtex.resource.bib.IBibTextToken result = new org.emftext.language.bibtex.resource.bib.mopp.BibTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_2_0.ANTLRStringStream(text));
	}
	
}
