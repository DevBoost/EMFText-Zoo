/**
* Copyright (C) 2012  
* Jan Reimann (TU Dresden, Software Technology Group)
* Mirko Seifert (DevBoost GmbH)
* 
* This program is free software; you can redistribute it and/or
* modify it under the terms of the GNU General Public License
* as published by the Free Software Foundation; either version 2
* of the License, or (at your option) any later version.
* 
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
* 
* You should have received a copy of the GNU General Public License
* along with this program; if not, write to the Free Software
* Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
*/
package org.devboost.stanford.language.resource.txt.mopp;

import java.util.List;

import org.devboost.stanford.language.NN;
import org.eclipse.emf.ecore.EObject;

public class TxtDynamicTokenStyler {
	
	/**
	 * This method is called to dynamically style tokens.
	 * 
	 * @param resource the TextResource that contains the token
	 * @param token the token to obtain a style for
	 * @param staticStyle the token style as set in the editor preferences (is
	 * <code>null</code> if syntax highlighting for the token is disabled)
	 */
	public org.devboost.stanford.language.resource.txt.ITxtTokenStyle getDynamicTokenStyle(org.devboost.stanford.language.resource.txt.ITxtTextResource resource, org.devboost.stanford.language.resource.txt.ITxtTextToken token, org.devboost.stanford.language.resource.txt.ITxtTokenStyle staticStyle) {
		// The default implementation returns the static style without any changes. To
		// implement dynamic token styling, set the overrideDynamicTokenStyler option to
		// <code>false</code> and customize this method.
		int offset = token.getOffset();
		int length = token.getLength();
		List<EObject> elements = resource.getLocationMap().getElementsBetween(offset, offset + length);
		for (EObject eObject : elements) {
			if (eObject instanceof NN) {
				NN nn = (NN) eObject;
				return new TxtTokenStyle(staticStyle.getColorAsRGB(), staticStyle.getBackgroundColorAsRGB(), true, false, false, false);
			}
		}
		return staticStyle;
	}
	
}
