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
package org.emftext.language.statemachine.resource.statemachine.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;
import org.emftext.language.statemachine.resource.statemachine.IStatemachineReferenceResolveResult;
import org.emftext.language.statemachine.resource.statemachine.IStatemachineReferenceResolver;

public class TransitionTargetReferenceResolver implements 
	IStatemachineReferenceResolver<Transition, Vertex> {

	public java.lang.String deResolve(Vertex element, org.eclipse.uml2.uml.Transition container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}

	public void resolve(String identifier, Transition container, EReference reference, int position, boolean resolveFuzzy, IStatemachineReferenceResolveResult<Vertex> result) {	
		for (Vertex targetCand: container.getContainer().getSubvertices()) {
			if (resolveFuzzy) {
				if (targetCand.getName().startsWith(identifier)) {
					result.addMapping(targetCand.getName(), targetCand);
				}
			} else {
				if (identifier.equals(targetCand.getName())) {
					result.addMapping(identifier, targetCand);
				}
			}
		}
	}

	public void setOptions(Map<?, ?> options) {
	}
}
