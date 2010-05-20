/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.abnf.resource.abnf.ui;

/**
 * A class used to initialize default preference values.
 */
public class AbnfPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	private final static org.emftext.language.abnf.resource.abnf.ui.AbnfAntlrTokenHelper tokenHelper = new org.emftext.language.abnf.resource.abnf.ui.AbnfAntlrTokenHelper();
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = org.emftext.language.abnf.resource.abnf.ui.AbnfUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(org.emftext.language.abnf.resource.abnf.ui.AbnfPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(org.emftext.language.abnf.resource.abnf.ui.AbnfPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
		// Set default value for occurrences
		store.setDefault(org.emftext.language.abnf.resource.abnf.ui.AbnfPreferenceConstants.EDITOR_OCCURRENCE_CHECKBOX, true);
		store.setDefault(org.emftext.language.abnf.resource.abnf.ui.AbnfPreferenceConstants.EDITOR_DEFINITION_COLOR, "240,216,168");
		store.setDefault(org.emftext.language.abnf.resource.abnf.ui.AbnfPreferenceConstants.EDITOR_PROXY_COLOR, "212,212,212");
		
		// store.setDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_OVERVIEW_
		// RULER, true);
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = org.emftext.language.abnf.resource.abnf.ui.AbnfUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new org.emftext.language.abnf.resource.abnf.mopp.AbnfMetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = org.emftext.language.abnf.resource.abnf.ui.AbnfUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new org.emftext.language.abnf.resource.abnf.mopp.AbnfMetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, org.emftext.language.abnf.resource.abnf.IAbnfMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		org.emftext.language.abnf.resource.abnf.ui.AbnfBracketSet bracketSet = new org.emftext.language.abnf.resource.abnf.ui.AbnfBracketSet(null);
		final java.util.Collection<org.emftext.language.abnf.resource.abnf.IAbnfBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (org.emftext.language.abnf.resource.abnf.IAbnfBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + org.emftext.language.abnf.resource.abnf.ui.AbnfPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, org.emftext.language.abnf.resource.abnf.IAbnfMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			if (!tokenHelper.canBeUsedForSyntaxColoring(i)) {
				continue;
			}
			
			String tokenName = tokenHelper.getTokenName(tokenNames, i);
			if (tokenName == null) {
				continue;
			}
			org.emftext.language.abnf.resource.abnf.IAbnfTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(org.emftext.language.abnf.resource.abnf.ui.AbnfSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.abnf.resource.abnf.ui.AbnfSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(org.emftext.language.abnf.resource.abnf.ui.AbnfSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.abnf.resource.abnf.ui.AbnfSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(org.emftext.language.abnf.resource.abnf.ui.AbnfSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.abnf.resource.abnf.ui.AbnfSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(org.emftext.language.abnf.resource.abnf.ui.AbnfSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.abnf.resource.abnf.ui.AbnfSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(org.emftext.language.abnf.resource.abnf.ui.AbnfSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.abnf.resource.abnf.ui.AbnfSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(org.emftext.language.abnf.resource.abnf.ui.AbnfSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.abnf.resource.abnf.ui.AbnfSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
	}
	
	private String getColorString(int[] colorAsRGB) {
		if (colorAsRGB == null) {
			return "0,0,0";
		}
		if (colorAsRGB.length != 3) {
			return "0,0,0";
		}
		return colorAsRGB[0] + "," +colorAsRGB[1] + ","+ colorAsRGB[2];
	}
}
