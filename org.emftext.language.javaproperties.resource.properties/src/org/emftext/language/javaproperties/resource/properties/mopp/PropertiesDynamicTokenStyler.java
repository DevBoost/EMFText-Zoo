/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.javaproperties.resource.properties.mopp;

public class PropertiesDynamicTokenStyler {
	
	/**
	 * This method is called to dynamically style tokens.
	 * 
	 * @param resource the TextResource that contains the token
	 * @param tokenName the name of the token
	 * @param tokenText the text of the token
	 * @param staticStyle the token style as set in the editor preferences (is
	 * <code>null</code> if syntax highlighting for the token is disabled)
	 */
	public org.emftext.language.javaproperties.resource.properties.IPropertiesTokenStyle getDynamicTokenStyle(org.emftext.language.javaproperties.resource.properties.IPropertiesTextResource resource, String tokenName, String tokenText, org.emftext.language.javaproperties.resource.properties.IPropertiesTokenStyle staticStyle) {
		// The default implementation returns the static style without any changes. To
		// implement dynamic token styling, set the overrideDynamicTokenStyler option to
		// <code>false</code> and customize this method.
		if ("VALUE".equals(tokenName) && tokenText.startsWith(" ")) {
			System.out.println("PropertiesDynamicTokenStyler.getDynamicTokenStyle() " + tokenText);
		}
		return staticStyle;
	}
	
}
