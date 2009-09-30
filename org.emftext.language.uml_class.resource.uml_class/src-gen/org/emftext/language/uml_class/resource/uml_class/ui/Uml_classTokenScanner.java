package org.emftext.language.uml_class.resource.uml_class.ui;

// An adapter from the Eclipse <code>org.eclipse.jface.text.rules.ITokenScanner</code> interface
// to the EMFText <code>ITextLexer</code> interface.
//
public class Uml_classTokenScanner implements org.eclipse.jface.text.rules.ITokenScanner {
	
	private org.emftext.language.uml_class.resource.uml_class.IUml_classTextScanner lexer;
	private org.emftext.language.uml_class.resource.uml_class.IUml_classTextToken currentToken;
	private int offset;
	private String languageId;
	private org.eclipse.jface.preference.IPreferenceStore store;
	private org.emftext.language.uml_class.resource.uml_class.ui.Uml_classColorManager colorManager;
	
	// @param resource The <code>org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource</code> from which the <code>Lexer</code> can be determined.
	// @param colorManager A manager to obtain color objects
	public Uml_classTokenScanner(org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource resource, org.emftext.language.uml_class.resource.uml_class.ui.Uml_classColorManager colorManager) {
		this.lexer = new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classMetaInformation().createLexer();
		this.languageId = new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classMetaInformation().getSyntaxName();
		this.store = org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classPlugin.getDefault().getPreferenceStore();
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
			String enableKey = org.emftext.language.uml_class.resource.uml_class.ui.Uml_classSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.language.uml_class.resource.uml_class.ui.Uml_classSyntaxColoringHelper.StyleProperty.ENABLE);
			if (store.getBoolean(enableKey)) {
				String colorKey = org.emftext.language.uml_class.resource.uml_class.ui.Uml_classSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.language.uml_class.resource.uml_class.ui.Uml_classSyntaxColoringHelper.StyleProperty.COLOR);
				org.eclipse.swt.graphics.Color color = colorManager.getColor(org.eclipse.jface.preference.PreferenceConverter.getColor(store, colorKey));
				int style = org.eclipse.swt.SWT.NORMAL;
				if (store.getBoolean(org.emftext.language.uml_class.resource.uml_class.ui.Uml_classSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.language.uml_class.resource.uml_class.ui.Uml_classSyntaxColoringHelper.StyleProperty.BOLD))) {
					style = style | org.eclipse.swt.SWT.BOLD;
				}
				if (store.getBoolean(org.emftext.language.uml_class.resource.uml_class.ui.Uml_classSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.language.uml_class.resource.uml_class.ui.Uml_classSyntaxColoringHelper.StyleProperty.ITALIC))) {
					style = style | org.eclipse.swt.SWT.ITALIC;
				}
				if (store.getBoolean(org.emftext.language.uml_class.resource.uml_class.ui.Uml_classSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.language.uml_class.resource.uml_class.ui.Uml_classSyntaxColoringHelper.StyleProperty.STRIKETHROUGH))) {
					style = style | org.eclipse.jface.text.TextAttribute.STRIKETHROUGH;
				}
				if (store.getBoolean(org.emftext.language.uml_class.resource.uml_class.ui.Uml_classSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, org.emftext.language.uml_class.resource.uml_class.ui.Uml_classSyntaxColoringHelper.StyleProperty.UNDERLINE))) {
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
			org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classPlugin.logError("Unexpected error:", e);
		}
	}
	
	public String getTokenText() {
		return currentToken.getText();
	}
}
