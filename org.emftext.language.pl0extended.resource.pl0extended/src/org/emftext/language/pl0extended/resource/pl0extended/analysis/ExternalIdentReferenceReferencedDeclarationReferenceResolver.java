/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0extended.resource.pl0extended.analysis;

import java.util.LinkedList;
import java.util.List;

import org.emftext.language.pl0.ConstDeclaration;

public class ExternalIdentReferenceReferencedDeclarationReferenceResolver implements org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedReferenceResolver<org.emftext.language.pl0extended.ExternalIdentReference, org.emftext.language.pl0.ConstDeclaration> {
	
	private org.emftext.language.pl0extended.resource.pl0extended.analysis.Pl0extendedDefaultResolverDelegate<org.emftext.language.pl0extended.ExternalIdentReference, org.emftext.language.pl0.ConstDeclaration> delegate = new org.emftext.language.pl0extended.resource.pl0extended.analysis.Pl0extendedDefaultResolverDelegate<org.emftext.language.pl0extended.ExternalIdentReference, org.emftext.language.pl0.ConstDeclaration>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.pl0extended.ExternalIdentReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedReferenceResolveResult<org.emftext.language.pl0.ConstDeclaration> result) {
		try {
			List<ConstDeclaration> declarations = new LinkedList<ConstDeclaration>();
			declarations.addAll(container.getImportReference().getProgramReference().getBlock().getConstants());
			for (ConstDeclaration declaration : declarations) {
				if(declaration.getName().equals(identifier) || resolveFuzzy){
					container.setIdent(declaration);
					result.addMapping(identifier, declaration);
				}
			}
		} catch (Exception e) {
			result.setErrorMessage("Import '" + container.getImportReference().getProgramReference().getName() + "' doesn't contain a declaration with identifier '" + identifier + "'");
		}
	}
	
	public java.lang.String deResolve(org.emftext.language.pl0.ConstDeclaration element, org.emftext.language.pl0extended.ExternalIdentReference container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
