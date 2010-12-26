/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pacad.resource.pacad.analysis;

import org.emftext.language.pacad.resource.pacad.analysis.helper.ObjectResolver;

public class MoveAbsoluteSubjectReferenceResolver implements org.emftext.language.pacad.resource.pacad.IPacadReferenceResolver<org.emftext.language.pacad.MoveAbsolute, org.emftext.language.pacad.Object> {
	
	private ObjectResolver delegate = new ObjectResolver();
	
	public void resolve(String identifier, org.emftext.language.pacad.MoveAbsolute container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.pacad.resource.pacad.IPacadReferenceResolveResult<org.emftext.language.pacad.Object> result) {
		delegate.resolveObject(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.pacad.Object element, org.emftext.language.pacad.MoveAbsolute container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
