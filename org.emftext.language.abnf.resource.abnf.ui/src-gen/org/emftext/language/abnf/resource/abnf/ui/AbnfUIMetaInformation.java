/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.abnf.resource.abnf.ui;

public class AbnfUIMetaInformation extends org.emftext.language.abnf.resource.abnf.mopp.AbnfMetaInformation {
	
	public org.emftext.language.abnf.resource.abnf.IAbnfHoverTextProvider getHoverTextProvider() {
		return new org.emftext.language.abnf.resource.abnf.ui.AbnfHoverTextProvider();
	}
	
	public org.emftext.language.abnf.resource.abnf.ui.AbnfColorManager createColorManager() {
		return new org.emftext.language.abnf.resource.abnf.ui.AbnfColorManager();
	}
	
	public org.emftext.language.abnf.resource.abnf.ui.AbnfTokenScanner createTokenScanner(org.emftext.language.abnf.resource.abnf.ui.AbnfColorManager colorManager) {
		return new org.emftext.language.abnf.resource.abnf.ui.AbnfTokenScanner(colorManager);
	}
	
	public org.emftext.language.abnf.resource.abnf.ui.AbnfCodeCompletionHelper createCodeCompletionHelper() {
		return new org.emftext.language.abnf.resource.abnf.ui.AbnfCodeCompletionHelper();
	}
	
}
