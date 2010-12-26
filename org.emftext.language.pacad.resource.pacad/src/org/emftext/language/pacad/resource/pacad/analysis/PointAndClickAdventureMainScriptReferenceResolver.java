/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pacad.resource.pacad.analysis;

public class PointAndClickAdventureMainScriptReferenceResolver implements org.emftext.language.pacad.resource.pacad.IPacadReferenceResolver<org.emftext.language.pacad.PointAndClickAdventure, org.emftext.language.pacad.PointAndClickAdventure> {
	
	private org.emftext.language.pacad.resource.pacad.analysis.PacadDefaultResolverDelegate<org.emftext.language.pacad.PointAndClickAdventure, org.emftext.language.pacad.PointAndClickAdventure> delegate = new org.emftext.language.pacad.resource.pacad.analysis.PacadDefaultResolverDelegate<org.emftext.language.pacad.PointAndClickAdventure, org.emftext.language.pacad.PointAndClickAdventure>();
	
	public void resolve(String identifier, org.emftext.language.pacad.PointAndClickAdventure container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.pacad.resource.pacad.IPacadReferenceResolveResult<org.emftext.language.pacad.PointAndClickAdventure> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.pacad.PointAndClickAdventure element, org.emftext.language.pacad.PointAndClickAdventure container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
