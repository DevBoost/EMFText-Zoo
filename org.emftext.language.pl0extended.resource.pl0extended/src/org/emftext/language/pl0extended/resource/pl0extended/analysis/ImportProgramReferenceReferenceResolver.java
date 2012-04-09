/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.pl0extended.resource.pl0extended.analysis;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.pl0.Program;

public class ImportProgramReferenceReferenceResolver implements org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedReferenceResolver<org.emftext.language.pl0extended.Import, org.emftext.language.pl0.Program> {

	public void resolve(java.lang.String identifier, org.emftext.language.pl0extended.Import container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedReferenceResolveResult<org.emftext.language.pl0.Program> result) {
		try{
			ResourceSet rs = container.eResource().getResourceSet();
			URI uri = URI.createURI(identifier);
			Resource importResource = rs.getResource(uri, true);
			EObject root = importResource.getContents().get(0);
			if(root instanceof Program || resolveFuzzy){
				result.addMapping(identifier, (Program) root);
			}
		} catch (Exception e) {
			result.setErrorMessage("Import '" + identifier + "' doesn't reference a valid PL/0 file.");
		}
	}

	public java.lang.String deResolve(org.emftext.language.pl0.Program element, org.emftext.language.pl0extended.Import container, org.eclipse.emf.ecore.EReference reference) {
		return element.eResource().getURI().toPlatformString(true);
	}

	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}

}
