package org.emftext.language.uml_class.resource.uml_class.ui;

// Class used to initialize default preference values.
public class Uml_classPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	// TODO this should not be used here!
	private final static org.emftext.language.uml_class.resource.uml_class.ui.Uml_classAntlrTokenHelper tokenHelper = new org.emftext.language.uml_class.resource.uml_class.ui.Uml_classAntlrTokenHelper();
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classPlugin.getDefault().getPreferenceStore();
		//Set default value for matching brackets
		store.setDefault(org.emftext.language.uml_class.resource.uml_class.ui.Uml_classPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(org.emftext.language.uml_class.resource.uml_class.ui.Uml_classPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
		//Set default value for occurrences
		store.setDefault(org.emftext.language.uml_class.resource.uml_class.ui.Uml_classPreferenceConstants.EDITOR_OCCURRENCE_CHECKBOX, true);
		store.setDefault(org.emftext.language.uml_class.resource.uml_class.ui.Uml_classPreferenceConstants.EDITOR_DEFINITION_COLOR, "240,216,168");
		store.setDefault(org.emftext.language.uml_class.resource.uml_class.ui.Uml_classPreferenceConstants.EDITOR_PROXY_COLOR, "212,212,212");
		
		//store.setDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_OVERVIEW_RULER, true);
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classMetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classMetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, org.emftext.language.uml_class.resource.uml_class.IUml_classMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		org.emftext.language.uml_class.resource.uml_class.ui.Uml_classBracketSet bracketSet = new org.emftext.language.uml_class.resource.uml_class.ui.Uml_classBracketSet(null, languageId);
		final java.util.Collection<org.emftext.language.uml_class.resource.uml_class.IUml_classBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (org.emftext.language.uml_class.resource.uml_class.IUml_classBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + org.emftext.language.uml_class.resource.uml_class.ui.Uml_classPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, org.emftext.language.uml_class.resource.uml_class.IUml_classMetaInformation metaInformation) {
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
			org.emftext.language.uml_class.resource.uml_class.IUml_classTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(org.emftext.language.uml_class.resource.uml_class.ui.Uml_classSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.uml_class.resource.uml_class.ui.Uml_classSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(org.emftext.language.uml_class.resource.uml_class.ui.Uml_classSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.uml_class.resource.uml_class.ui.Uml_classSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(org.emftext.language.uml_class.resource.uml_class.ui.Uml_classSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.uml_class.resource.uml_class.ui.Uml_classSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(org.emftext.language.uml_class.resource.uml_class.ui.Uml_classSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.uml_class.resource.uml_class.ui.Uml_classSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(org.emftext.language.uml_class.resource.uml_class.ui.Uml_classSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.uml_class.resource.uml_class.ui.Uml_classSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(org.emftext.language.uml_class.resource.uml_class.ui.Uml_classSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.language.uml_class.resource.uml_class.ui.Uml_classSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
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
