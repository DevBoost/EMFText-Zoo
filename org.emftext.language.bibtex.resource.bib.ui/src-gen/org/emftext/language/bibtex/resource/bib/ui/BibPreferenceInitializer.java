/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.ui;

/**
 * A class used to initialize default preference values.
 */
public class BibPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	private final static org.emftext.language.bibtex.resource.bib.ui.BibAntlrTokenHelper tokenHelper = new org.emftext.language.bibtex.resource.bib.ui.BibAntlrTokenHelper();
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = org.emftext.language.bibtex.resource.bib.ui.BibUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(org.emftext.language.bibtex.resource.bib.ui.BibPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(org.emftext.language.bibtex.resource.bib.ui.BibPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = org.emftext.language.bibtex.resource.bib.ui.BibUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new org.emftext.language.bibtex.resource.bib.mopp.BibMetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = org.emftext.language.bibtex.resource.bib.ui.BibUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new org.emftext.language.bibtex.resource.bib.mopp.BibMetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, org.emftext.language.bibtex.resource.bib.IBibMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		org.emftext.language.bibtex.resource.bib.ui.BibBracketSet bracketSet = new org.emftext.language.bibtex.resource.bib.ui.BibBracketSet(null, null);
		final java.util.Collection<org.emftext.language.bibtex.resource.bib.IBibBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (org.emftext.language.bibtex.resource.bib.IBibBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + org.emftext.language.bibtex.resource.bib.ui.BibPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, org.emftext.language.bibtex.resource.bib.IBibMetaInformation metaInformation) {
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
			org.emftext.language.bibtex.resource.bib.IBibTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(org.emftext.language.bibtex.resource.bib.ui.BibSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.bibtex.resource.bib.ui.BibSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(org.emftext.language.bibtex.resource.bib.ui.BibSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.bibtex.resource.bib.ui.BibSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(org.emftext.language.bibtex.resource.bib.ui.BibSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.bibtex.resource.bib.ui.BibSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(org.emftext.language.bibtex.resource.bib.ui.BibSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.bibtex.resource.bib.ui.BibSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(org.emftext.language.bibtex.resource.bib.ui.BibSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.bibtex.resource.bib.ui.BibSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(org.emftext.language.bibtex.resource.bib.ui.BibSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.bibtex.resource.bib.ui.BibSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
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
