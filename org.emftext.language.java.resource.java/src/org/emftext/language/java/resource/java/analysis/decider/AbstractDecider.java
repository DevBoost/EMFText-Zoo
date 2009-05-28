/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java.resource.java.analysis.decider;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * Default implementation of the interface that provides default behavior for some methods.
 *
 */
public abstract class AbstractDecider implements IResolutionTargetDecider {

	protected boolean active = true;
	
	/**
	 * @return true by default
	 */
	public boolean continueAfterReference() {
		return true;
	}
	
	/**
	 * @return false by default
	 */
	public boolean walkInto(EObject element) {
		return false;
	}

	/**
	 * @return null (corresponds to empty list) by default
	 */
	public EList<? extends EObject> getAdditionalCandidates(String identifier, EObject container)  {
		return null;
	}
	
	/**
	 * @return true by default
	 */
	public boolean isSure() {
		return true;
	}
	
	/**
	 * Implements the interface specification. Do not override.
	 */
	public void activate() {
		active = true;		
	}

	/**
	 * Implements the interface specification. Do not override.
	 */
	public void deactivate() {
		active = false;
	}

	/**
	 * Implements the interface specification. Do not override.
	 */
	public boolean isActive() {
		return active;
	}
}
