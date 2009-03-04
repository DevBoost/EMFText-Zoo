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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;

public class EMFTypesResolver {
	
	protected void doResolve(java.lang.String identifier, 
			Resource container, 
			org.eclipse.emf.ecore.EReference reference, 
			int position, 
			boolean resolveFuzzy, 
			org.emftext.runtime.resource.IReferenceResolveResult result) {
		
		EList<EObject> pkgs = container.getContents();

		for (EObject pkgCandidate : pkgs) {
			if (pkgCandidate instanceof EPackage) {
				EList<EClassifier> allClassifiers  = ((EPackage) pkgCandidate).getEClassifiers();
				addResults(identifier, allClassifiers, resolveFuzzy, result);
			}
		}	
		addResults(identifier, EcorePackage.eINSTANCE.getEClassifiers(), resolveFuzzy, result);
		
	}


	private void addResults(java.lang.String identifier, EList<EClassifier> allClassifiers, boolean resolveFuzzy,
			org.emftext.runtime.resource.IReferenceResolveResult result) {
		if (resolveFuzzy) {			
			for (EClassifier classifier : allClassifiers) {
				if (classifier.getName().startsWith(identifier)) {
					result.addMapping(classifier.getName(), classifier);
				}
			}
		} else {
			for (EClassifier classifier : allClassifiers) {
				if (classifier.getName().equals(identifier)) {
					result.addMapping(identifier, classifier);
				}
			}
		}
	}
}


	
