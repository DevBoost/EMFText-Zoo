/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0extended.resource.pl0extended.ui;

public class Pl0extendedHoverTextProvider implements org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedHoverTextProvider {
	
	private org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedDefaultHoverTextProvider defaultProvider = new org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedDefaultHoverTextProvider();
	
	public java.lang.String getHoverText(org.eclipse.emf.ecore.EObject object) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(object);
	}
	
}
