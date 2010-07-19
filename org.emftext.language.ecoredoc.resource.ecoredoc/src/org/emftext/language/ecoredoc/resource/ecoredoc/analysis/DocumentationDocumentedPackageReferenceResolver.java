/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.ecoredoc.resource.ecoredoc.analysis;

public class DocumentationDocumentedPackageReferenceResolver implements org.emftext.language.ecoredoc.resource.ecoredoc.IEcoredocReferenceResolver<org.emftext.language.ecoredoc.Documentation, org.eclipse.emf.ecore.EPackage> {
	
	private org.emftext.language.ecoredoc.resource.ecoredoc.analysis.EcoredocDefaultResolverDelegate<org.emftext.language.ecoredoc.Documentation, org.eclipse.emf.ecore.EPackage> delegate = new org.emftext.language.ecoredoc.resource.ecoredoc.analysis.EcoredocDefaultResolverDelegate<org.emftext.language.ecoredoc.Documentation, org.eclipse.emf.ecore.EPackage>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.ecoredoc.Documentation container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.ecoredoc.resource.ecoredoc.IEcoredocReferenceResolveResult<org.eclipse.emf.ecore.EPackage> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.eclipse.emf.ecore.EPackage element, org.emftext.language.ecoredoc.Documentation container, org.eclipse.emf.ecore.EReference reference) {
		return element.eResource().getURI().toString();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
