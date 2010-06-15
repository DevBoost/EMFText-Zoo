/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0extended.resource.pl0extended.analysis;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.pl0.Program;
import org.emftext.language.pl0extended.Import;
import org.emftext.language.pl0extended.ProgramWithImports;

public class ExternalIdentReferenceImportReferenceReferenceResolver implements org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedReferenceResolver<org.emftext.language.pl0extended.ExternalIdentReference, org.emftext.language.pl0extended.Import> {

	private org.emftext.language.pl0extended.resource.pl0extended.analysis.Pl0extendedDefaultResolverDelegate<org.emftext.language.pl0extended.ExternalIdentReference, org.emftext.language.pl0extended.Import> delegate = new org.emftext.language.pl0extended.resource.pl0extended.analysis.Pl0extendedDefaultResolverDelegate<org.emftext.language.pl0extended.ExternalIdentReference, org.emftext.language.pl0extended.Import>();

	public void resolve(java.lang.String identifier, org.emftext.language.pl0extended.ExternalIdentReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedReferenceResolveResult<org.emftext.language.pl0extended.Import> result) {
		try{
			EObject root = EcoreUtil.getRootContainer(container);
			if(root instanceof ProgramWithImports){
				ProgramWithImports program = (ProgramWithImports) root;
				List<Import> imports = program.getImports();
				for (Import import1 : imports) {
					Program referencedProgram = import1.getProgramReference();
					if(referencedProgram.getName().equals(identifier) || resolveFuzzy){
						result.addMapping(identifier, import1);
					}
				}
			}
		} catch (Exception e) {
			result.setErrorMessage("'" + identifier + "' doesn't reference an imported PL/0 file.");
		}
	}

	public java.lang.String deResolve(org.emftext.language.pl0extended.Import element, org.emftext.language.pl0extended.ExternalIdentReference container, org.eclipse.emf.ecore.EReference reference) {
		return element.getProgramReference().getName();
	}

	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}

}
