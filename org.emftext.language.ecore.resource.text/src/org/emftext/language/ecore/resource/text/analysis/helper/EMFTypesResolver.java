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
package org.emftext.language.ecore.resource.text.analysis.helper;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.runtime.resource.IReferenceResolveResult;

public class EMFTypesResolver {
	
	protected Resource resource = null;
	
	public void doResolve(java.lang.String identifier, 
			EObject container, 
			org.eclipse.emf.ecore.EReference reference, 
			int position, 
			boolean resolveFuzzy, 
			org.emftext.runtime.resource.IReferenceResolveResult<?> result) {
		
		EPackage ePackage = null;
		String eClassName = identifier;

		resource = container.eResource();

		if(eClassName.contains("::")) {
			//class resides in another package
			String[] namespaces = eClassName.split("::");
			eClassName = namespaces[namespaces.length - 1];
			String packagePrefix = namespaces[0];
			
			
			EObject rootContainer = EcoreUtil.getRootContainer(container);
			if (rootContainer instanceof EPackage && 
					((EPackage)rootContainer).getName().equals(packagePrefix)) {
				//this package?
				ePackage = (EPackage) rootContainer;
			}
			else {
				//import
				Map<String, EPackage> imports = new HashMap<String, EPackage>();
				collectImports(container, imports);

				ePackage = imports.get(packagePrefix);
				
				if(ePackage == null) {
					result.setErrorMessage("EPackage '" + packagePrefix + "' not found");
					return;
				}
			}

			//subpackages
			outer : for(int i = 1; i < namespaces.length - 1; i++) {
				for(EPackage subPackage : ePackage.getESubpackages()) {
					if(namespaces[i].equals(subPackage.getName())) {
						ePackage = subPackage;
						continue outer;
					}
				}
				result.setErrorMessage("Nested EPackage '" + namespaces[i] + "' not found");
				return;
			}
		}
		else {
			EObject parent = container;
			while (parent != null && !(parent instanceof EPackage)) {
				parent = parent.eContainer();
			}
			ePackage = (EPackage) parent;
		}
		
		addResults(identifier, eClassName, ePackage.getEClassifiers(), resolveFuzzy, result);
		if (!result.wasResolved() && !identifier.contains("::")) {
			//try the "default" package Ecore
			addResults(identifier, identifier, EcorePackage.eINSTANCE.getEClassifiers(), resolveFuzzy, result);
		}
	}

	private void addResults(String identifier, String className, EList<EClassifier> candidates,
			boolean resolveFuzzy, IReferenceResolveResult result) {
		for (EClassifier next : candidates) {
			if (next instanceof EClassifier) {
				EClassifier classifier = (EClassifier) next;
				
				if (resolveFuzzy) {			
					if (classifier.getName().startsWith(className)) {
						result.addMapping(classifier.getName(), classifier);
					}
				} else {
					if (classifier.getName().equals(className)) {
						result.addMapping(identifier, classifier);
						return;
					}
				}
				
				//type parameter?
				for(ETypeParameter typeParameter : classifier.getETypeParameters()) {
					if (typeParameter.getName().equals(className)) {
						result.addMapping(identifier, classifier);
						return;
					}
				}
			}
		}
	}
	
	private void collectImports(EObject element, Map<String, EPackage> imports) {
		EAnnotation importAnnotation = null;
		if (element instanceof EModelElement) {
			importAnnotation = ((EModelElement)element).getEAnnotation("import");
			if (importAnnotation != null) {
				for(String key : importAnnotation.getDetails().keySet()) {
					if (!imports.containsKey(key)) {
						EPackage importedEPackage = findEPackage(importAnnotation.getDetails().get(key));
						imports.put(key, importedEPackage);
					}
				}
			}
		}
		if (element.eContainer() != null) {
			collectImports(element.eContainer(), imports);
		}
	}
	
	private EPackage findEPackage(String uriString) {
		if(resource == null) {
			return null;
		}
		ResourceSet rs = resource.getResourceSet();
		if (rs == null) {
			return null;
		}
		Resource ePackageResource = null;
		URI uri = URI.createURI(uriString);
		uri = uri.resolve(resource.getURI()); //relative
		try {
			ePackageResource = rs.getResource(uri, true);
		} catch (Exception e) {}
		
		if (ePackageResource.getContents().isEmpty() || 
				!(ePackageResource.getContents().get(0) instanceof EPackage)) {
			return null;
		}
		return (EPackage) ePackageResource.getContents().get(0);
	}
	

	
}


	
