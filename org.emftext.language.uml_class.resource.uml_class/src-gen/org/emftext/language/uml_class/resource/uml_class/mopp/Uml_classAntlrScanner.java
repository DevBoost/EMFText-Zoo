package org.emftext.language.uml_class.resource.uml_class.mopp;

public class Uml_classAntlrScanner implements org.emftext.language.uml_class.resource.uml_class.IUml_classTextScanner {
	
	private org.antlr.runtime.Lexer antlrLexer;
	
	public Uml_classAntlrScanner(org.antlr.runtime.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public org.emftext.language.uml_class.resource.uml_class.IUml_classTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime.Token current = antlrLexer.nextToken();
		org.emftext.language.uml_class.resource.uml_class.IUml_classTextToken result = new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classTextToken(current);
		return result;
	}
	
	public void setText(java.lang.String text) {
		antlrLexer.setCharStream(new org.antlr.runtime.ANTLRStringStream(text));
	}
	
}
