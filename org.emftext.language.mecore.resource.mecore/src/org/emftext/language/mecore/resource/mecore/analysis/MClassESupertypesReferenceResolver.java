/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.language.mecore.resource.mecore.analysis;

import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.mecore.MClass;
import org.emftext.language.mecore.MImport;
import org.emftext.language.mecore.MPackage;
import org.emftext.language.mecore.resource.mecore.IMecoreReferenceResolveResult;
import org.emftext.language.mecore.resource.mecore.IMecoreReferenceResolver;

public class MClassESupertypesReferenceResolver implements IMecoreReferenceResolver<MClass, EClass> {
	
	private MecoreDefaultResolverDelegate<MClass, EClass> delegate = new MecoreDefaultResolverDelegate<MClass, EClass>();
	
	public void resolve(String identifier, MClass container, EReference reference, int position, boolean resolveFuzzy, final IMecoreReferenceResolveResult<EClass> result) {
		MPackage mPackage = findMPackage(container);
		if (mPackage != null) {
			List<MImport> imports = mPackage.getImports();
			for (MImport mImport : imports) {
				String currentPrefix = mImport.getPrefix();
				EPackage importedPackage = mImport.getImportedPackage();
				TreeIterator<EObject> eAllContents = importedPackage.eAllContents();
				while (eAllContents.hasNext()) {
					EObject eObject = (EObject) eAllContents.next();
					if (eObject instanceof EClass) {
						EClass eClass = (EClass) eObject;
						String name = currentPrefix + "." + eClass.getName();
						if (name.equals(identifier) || resolveFuzzy) {
							result.addMapping(name, eClass);
							if (!resolveFuzzy) {
								return;
							}
						}
					}
				}
			}
		}
	}
	
	public String deResolve(EClass element, MClass container, EReference reference) {
		// TODO fix this
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
	private MPackage findMPackage(MClass container) {
		EObject current = container;
		while (current != null) {
			if (current instanceof MPackage) {
				MPackage mPackage = (MPackage) current;
				return mPackage;
			}
			current = current.eContainer();
		}
		return null;
	}
}
