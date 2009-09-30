package org.emftext.language.uml_class.resource.uml_class.mopp;
public class Uml_classTextToken implements org.emftext.language.uml_class.resource.uml_class.IUml_classTextToken {
	
	private final org.emftext.language.uml_class.resource.uml_class.IUml_classMetaInformation metaInformation = new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classMetaInformation();
	private final org.antlr.runtime.Token antlrToken;
	
	public Uml_classTextToken(org.antlr.runtime.Token antlrToken) {
		super();
		this.antlrToken = antlrToken;
	}
	
	public java.lang.String getName() {
		return getTokenName(metaInformation.getTokenNames(), antlrToken.getType());
	}
	
	public int getOffset() {
		return ((org.antlr.runtime.CommonToken) antlrToken).getStartIndex();
	}
	
	public int getLength() {
		return ((org.antlr.runtime.CommonToken) antlrToken).getStopIndex() - ((org.antlr.runtime.CommonToken) antlrToken).getStartIndex() + 1;
	}
	
	public boolean canBeUsedForSyntaxHighlighting() {
		int tokenType = antlrToken.getType();
		if (tokenType == org.antlr.runtime.Token.EOF) {
			return false;
		}
		if (tokenType == org.antlr.runtime.Token.UP) {
			return false;
		}
		if (tokenType == org.antlr.runtime.Token.DOWN) {
			return false;
		}
		if (tokenType == org.antlr.runtime.Token.EOR_TOKEN_TYPE) {
			return false;
		}
		if (tokenType == org.antlr.runtime.Token.INVALID_TOKEN_TYPE) {
			return false;
		}
		return true;
	}
	
	public java.lang.String getText() {
		return antlrToken.getText();
	}
	
	public java.lang.String getTokenName(java.lang.String[] tokenNames, int index) {
		if (tokenNames == null) {
			return null;
		}
		java.lang.String tokenName = tokenNames[index];
		if (tokenName != null && tokenName.startsWith("'")) {
			tokenName = tokenName.substring(1, tokenName.length() - 1).trim();
		}
		return tokenName;
	}
	
}
