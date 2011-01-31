/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.ui;

public class BibUIMetaInformation extends org.emftext.language.bibtex.resource.bib.mopp.BibMetaInformation {
	
	public org.emftext.language.bibtex.resource.bib.IBibHoverTextProvider getHoverTextProvider() {
		return new org.emftext.language.bibtex.resource.bib.ui.BibHoverTextProvider();
	}
	
	public org.emftext.language.bibtex.resource.bib.ui.BibImageProvider getImageProvider() {
		return org.emftext.language.bibtex.resource.bib.ui.BibImageProvider.INSTANCE;
	}
	
	public org.emftext.language.bibtex.resource.bib.ui.BibColorManager createColorManager() {
		return new org.emftext.language.bibtex.resource.bib.ui.BibColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(org.emftext.language.bibtex.resource.bib.IBibTextResource,
	 * org.emftext.language.bibtex.resource.bib.ui.BibColorManager) instead.
	 */
	public org.emftext.language.bibtex.resource.bib.ui.BibTokenScanner createTokenScanner(org.emftext.language.bibtex.resource.bib.ui.BibColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public org.emftext.language.bibtex.resource.bib.ui.BibTokenScanner createTokenScanner(org.emftext.language.bibtex.resource.bib.IBibTextResource resource, org.emftext.language.bibtex.resource.bib.ui.BibColorManager colorManager) {
		return new org.emftext.language.bibtex.resource.bib.ui.BibTokenScanner(resource, colorManager);
	}
	
	public org.emftext.language.bibtex.resource.bib.ui.BibCodeCompletionHelper createCodeCompletionHelper() {
		return new org.emftext.language.bibtex.resource.bib.ui.BibCodeCompletionHelper();
	}
	
}
