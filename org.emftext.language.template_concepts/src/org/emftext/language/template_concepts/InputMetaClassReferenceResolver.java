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
package org.emftext.language.template_concepts;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

public class InputMetaClassReferenceResolver {
	
	public java.lang.String deResolve(org.eclipse.emf.ecore.EClass element, org.emftext.language.template_concepts.Template container, org.eclipse.emf.ecore.EReference reference) {
		EClass eClass = (EClass) element;
		return eClass.getEPackage().getNsURI() + "::" + eClass.getName();
	}
	
	public void resolve(java.lang.String identifier, org.emftext.language.template_concepts.Template container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.eclipse.emf.ecore.EClass> result) {
		String[] namespaceAndClassName = identifier.split("::");
		if (namespaceAndClassName.length == 2) {
			String namespace = namespaceAndClassName[0];
			String className = namespaceAndClassName[1];
			EClassifier classifier = findEClassifier(namespace, className);
			if (classifier == null) {
				return;
			}
			if (classifier instanceof EClass) {
				result.addMapping(identifier, (EClass) classifier);
			}
		}
	}
	
	private EClassifier findEClassifier(String nsURI, String eClassName) {
		EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(nsURI);
	    if (ePackage == null) {
	    	return null;
	    } else {
	    	return ePackage.getEClassifier(eClassName);
	    }
	}
}
