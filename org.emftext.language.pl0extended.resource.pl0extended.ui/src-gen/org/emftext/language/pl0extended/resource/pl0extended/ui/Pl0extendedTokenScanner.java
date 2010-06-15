/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0extended.resource.pl0extended.ui;

/**
 * An adapter from the Eclipse
 * <code>org.eclipse.jface.text.rules.ITokenScanner</code> interface to the
 * generated lexer.
 */
public class Pl0extendedTokenScanner implements org.eclipse.jface.text.rules.ITokenScanner {
	
	private org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedTextScanner lexer;
	private org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedTextToken currentToken;
	private int offset;
	private String languageId;
	private org.eclipse.jface.preference.IPreferenceStore store;
	private org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedColorManager colorManager;
	
	/**
	 * 
	 * @param colorManager A manager to obtain color objects
	 */
	public Pl0extendedTokenScanner(org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedColorManager colorManager) {
		this.lexer = new org.emftext.language.pl0extended.resource.pl0extended.mopp.Pl0extendedMetaInformation().createLexer();
		this.languageId = new org.emftext.language.pl0extended.resource.pl0extended.mopp.Pl0extendedMetaInformation().getSyntaxName();
		this.store = org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedUIPlugin.getDefault().getPreferenceStore();
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
			String enableKey = org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedSyntaxColoringHelper.StyleProperty.ENABLE);
			if (store.getBoolean(enableKey)) {
				String colorKey = org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedSyntaxColoringHelper.StyleProperty.COLOR);
				org.eclipse.swt.graphics.Color color = colorManager.getColor(org.eclipse.jface.preference.PreferenceConverter.getColor(store, colorKey));
				int style = org.eclipse.swt.SWT.NORMAL;
				if (store.getBoolean(org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedSyntaxColoringHelper.StyleProperty.BOLD))) {
					style = style | org.eclipse.swt.SWT.BOLD;
				}
				if (store.getBoolean(org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedSyntaxColoringHelper.StyleProperty.ITALIC))) {
					style = style | org.eclipse.swt.SWT.ITALIC;
				}
				if (store.getBoolean(org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedSyntaxColoringHelper.StyleProperty.STRIKETHROUGH))) {
					style = style | org.eclipse.jface.text.TextAttribute.STRIKETHROUGH;
				}
				if (store.getBoolean(org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedSyntaxColoringHelper.StyleProperty.UNDERLINE))) {
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
			// ignore this error. It might occur during editing when locations are outdated
			// quickly.
		}
	}
	
	public String getTokenText() {
		return currentToken.getText();
	}
}
