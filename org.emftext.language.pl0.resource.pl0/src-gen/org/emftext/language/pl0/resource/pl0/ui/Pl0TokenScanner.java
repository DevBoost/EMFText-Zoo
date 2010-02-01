/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0.ui;

// An adapter from the Eclipse <code>org.eclipse.jface.text.rules.ITokenScanner</code> interface
// to the generated lexer.
//
public class Pl0TokenScanner implements org.eclipse.jface.text.rules.ITokenScanner {
	
	private org.emftext.language.pl0.resource.pl0.IPl0TextScanner lexer;
	private org.emftext.language.pl0.resource.pl0.IPl0TextToken currentToken;
	private int offset;
	private String languageId;
	private org.eclipse.jface.preference.IPreferenceStore store;
	private org.emftext.language.pl0.resource.pl0.ui.Pl0ColorManager colorManager;
	
	// @param colorManager A manager to obtain color objects
	public Pl0TokenScanner(org.emftext.language.pl0.resource.pl0.ui.Pl0ColorManager colorManager) {
		this.lexer = new org.emftext.language.pl0.resource.pl0.mopp.Pl0MetaInformation().createLexer();
		this.languageId = new org.emftext.language.pl0.resource.pl0.mopp.Pl0MetaInformation().getSyntaxName();
		this.store = org.emftext.language.pl0.resource.pl0.mopp.Pl0Plugin.getDefault().getPreferenceStore();
		this.colorManager = colorManager;
	}
	
	public int getTokenLength() {
		return currentToken.getLength();
	}
	
	public int getTokenOffset() {
		return offset + currentToken.getOffset();
	}
	
	public org.eclipse.jface.text.rules.IToken nextToken() {
		currentToken = lexer.getNextToken();
		if (currentToken == null || !currentToken.canBeUsedForSyntaxHighlighting()) {
			return org.eclipse.jface.text.rules.Token.EOF;
		}
		org.eclipse.jface.text.TextAttribute ta = null;
		String tokenName = currentToken.getName();
		if (tokenName != null) {
			String enableKey = org.emftext.language.pl0.resource.pl0.ui.Pl0SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.language.pl0.resource.pl0.ui.Pl0SyntaxColoringHelper.StyleProperty.ENABLE);
			if (store.getBoolean(enableKey)) {
				String colorKey = org.emftext.language.pl0.resource.pl0.ui.Pl0SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.language.pl0.resource.pl0.ui.Pl0SyntaxColoringHelper.StyleProperty.COLOR);
				org.eclipse.swt.graphics.Color color = colorManager.getColor(org.eclipse.jface.preference.PreferenceConverter.getColor(store, colorKey));
				int style = org.eclipse.swt.SWT.NORMAL;
				if (store.getBoolean(org.emftext.language.pl0.resource.pl0.ui.Pl0SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.language.pl0.resource.pl0.ui.Pl0SyntaxColoringHelper.StyleProperty.BOLD))) {
					style = style | org.eclipse.swt.SWT.BOLD;
				}
				if (store.getBoolean(org.emftext.language.pl0.resource.pl0.ui.Pl0SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.language.pl0.resource.pl0.ui.Pl0SyntaxColoringHelper.StyleProperty.ITALIC))) {
					style = style | org.eclipse.swt.SWT.ITALIC;
				}
				if (store.getBoolean(org.emftext.language.pl0.resource.pl0.ui.Pl0SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.language.pl0.resource.pl0.ui.Pl0SyntaxColoringHelper.StyleProperty.STRIKETHROUGH))) {
					style = style | org.eclipse.jface.text.TextAttribute.STRIKETHROUGH;
				}
				if (store.getBoolean(org.emftext.language.pl0.resource.pl0.ui.Pl0SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.language.pl0.resource.pl0.ui.Pl0SyntaxColoringHelper.StyleProperty.UNDERLINE))) {
					style = style | org.eclipse.jface.text.TextAttribute.UNDERLINE;
				}
				ta = new org.eclipse.jface.text.TextAttribute(color, null, style);
			}
		}
		return new org.eclipse.jface.text.rules.Token(ta);
	}
	
	public void setRange(org.eclipse.jface.text.IDocument document, int offset, int length) {
		this.offset = offset;
		try {
			lexer.setText(document.get(offset, length));
		} catch (org.eclipse.jface.text.BadLocationException e) {
			//ignore this error. It might occur during editing when locations are outdated quickly.
		}
	}
	
	public String getTokenText() {
		return currentToken.getText();
	}
}
