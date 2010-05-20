/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.abnf.resource.abnf.ui;

public class AbnfHoverTextProvider implements org.emftext.language.abnf.resource.abnf.IAbnfHoverTextProvider {
	
	private org.emftext.language.abnf.resource.abnf.ui.AbnfDefaultHoverTextProvider defaultProvider = new org.emftext.language.abnf.resource.abnf.ui.AbnfDefaultHoverTextProvider();
	
	public java.lang.String getHoverText(org.eclipse.emf.ecore.EObject object) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(object);
	}
	
}
