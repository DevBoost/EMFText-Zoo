/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0extended.resource.pl0extended.analysis;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.pl0.Program;

public class ImportProgramReferenceReferenceResolver implements org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedReferenceResolver<org.emftext.language.pl0extended.Import, org.emftext.language.pl0.Program> {

	private org.emftext.language.pl0extended.resource.pl0extended.analysis.Pl0extendedDefaultResolverDelegate<org.emftext.language.pl0extended.Import, org.emftext.language.pl0.Program> delegate = new org.emftext.language.pl0extended.resource.pl0extended.analysis.Pl0extendedDefaultResolverDelegate<org.emftext.language.pl0extended.Import, org.emftext.language.pl0.Program>();

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
