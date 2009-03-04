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
package org.eclipse.emf.ecore.resource.ecore.analysis;

public class EClassESuperTypesReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.eclipse.emf.ecore.EClass, org.eclipse.emf.ecore.EClass> {
	
	@Override	
	protected java.lang.String doDeResolve(org.eclipse.emf.ecore.EClass element, org.eclipse.emf.ecore.EClass container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.eclipse.emf.ecore.EClass container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult result) {
		new EMFTypesResolver().doResolve(identifier, container.eResource(), reference, position, resolveFuzzy, result);
	}
}
