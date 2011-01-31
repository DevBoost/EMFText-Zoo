/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.ui;

public class BibHoverTextProvider implements org.emftext.language.bibtex.resource.bib.IBibHoverTextProvider {
	
	private org.emftext.language.bibtex.resource.bib.ui.BibDefaultHoverTextProvider defaultProvider = new org.emftext.language.bibtex.resource.bib.ui.BibDefaultHoverTextProvider();
	
	public String getHoverText(org.eclipse.emf.ecore.EObject object) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(object);
	}
	
}
