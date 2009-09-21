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
package org.emftext.language.ecore.resource.text.analysis;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.ecore.resource.text.ITextEcoreReferenceResolveResult;
import org.emftext.language.ecore.resource.text.ITextEcoreReferenceResolver;

public class EReferenceEOppositeReferenceResolver implements ITextEcoreReferenceResolver<org.eclipse.emf.ecore.EReference, org.eclipse.emf.ecore.EReference> {
	
	public java.lang.String deResolve(org.eclipse.emf.ecore.EReference element, org.eclipse.emf.ecore.EReference container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void resolve(java.lang.String identifier, org.eclipse.emf.ecore.EReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, ITextEcoreReferenceResolveResult<org.eclipse.emf.ecore.EReference> result) {
		EClass oppositeType = container.getEReferenceType();
		if (!resolveFuzzy) {
			EStructuralFeature opposite = oppositeType.getEStructuralFeature(identifier);
			result.addMapping(identifier, (EReference) opposite);
		} else {
			EList<EReference> references = oppositeType.getEReferences();
			for (EReference structuralFeature : references) {
				if (structuralFeature.getName().startsWith(identifier)) {
					result.addMapping(structuralFeature.getName(), structuralFeature);
				}
			}
		}
		
	}

	public void setOptions(Map<?, ?> options) {
	}
}
