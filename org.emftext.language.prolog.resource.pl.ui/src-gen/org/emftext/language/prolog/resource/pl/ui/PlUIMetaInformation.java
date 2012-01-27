/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.ui;

public class PlUIMetaInformation extends org.emftext.language.prolog.resource.pl.mopp.PlMetaInformation {
	
	public org.emftext.language.prolog.resource.pl.IPlHoverTextProvider getHoverTextProvider() {
		return new org.emftext.language.prolog.resource.pl.ui.PlHoverTextProvider();
	}
	
	public org.emftext.language.prolog.resource.pl.ui.PlImageProvider getImageProvider() {
		return org.emftext.language.prolog.resource.pl.ui.PlImageProvider.INSTANCE;
	}
	
	public org.emftext.language.prolog.resource.pl.ui.PlColorManager createColorManager() {
		return new org.emftext.language.prolog.resource.pl.ui.PlColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(org.emftext.language.prolog.resource.pl.IPlTextResource,
	 * org.emftext.language.prolog.resource.pl.ui.PlColorManager) instead.
	 */
	public org.emftext.language.prolog.resource.pl.ui.PlTokenScanner createTokenScanner(org.emftext.language.prolog.resource.pl.ui.PlColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public org.emftext.language.prolog.resource.pl.ui.PlTokenScanner createTokenScanner(org.emftext.language.prolog.resource.pl.IPlTextResource resource, org.emftext.language.prolog.resource.pl.ui.PlColorManager colorManager) {
		return new org.emftext.language.prolog.resource.pl.ui.PlTokenScanner(resource, colorManager);
	}
	
	public org.emftext.language.prolog.resource.pl.ui.PlCodeCompletionHelper createCodeCompletionHelper() {
		return new org.emftext.language.prolog.resource.pl.ui.PlCodeCompletionHelper();
	}
	
}
