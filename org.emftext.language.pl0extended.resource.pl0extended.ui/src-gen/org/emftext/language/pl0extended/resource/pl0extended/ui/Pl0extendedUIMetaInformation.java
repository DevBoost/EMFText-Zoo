/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0extended.resource.pl0extended.ui;

public class Pl0extendedUIMetaInformation extends org.emftext.language.pl0extended.resource.pl0extended.mopp.Pl0extendedMetaInformation {
	
	public org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedHoverTextProvider getHoverTextProvider() {
		return new org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedHoverTextProvider();
	}
	
	public org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedColorManager createColorManager() {
		return new org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedColorManager();
	}
	
	public org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedTokenScanner createTokenScanner(org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedColorManager colorManager) {
		return new org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedTokenScanner(colorManager);
	}
	
	public org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedCodeCompletionHelper createCodeCompletionHelper() {
		return new org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedCodeCompletionHelper();
	}
	
}
