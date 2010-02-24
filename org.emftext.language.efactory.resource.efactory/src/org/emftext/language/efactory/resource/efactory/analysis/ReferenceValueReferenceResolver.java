/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.efactory.resource.efactory.analysis;

import org.eclipse.emf.ecore.EReference;
import org.emftext.language.efactory.NewObject;
import org.emftext.language.efactory.Reference;
import org.emftext.language.efactory.resource.efactory.IEfactoryReferenceResolveResult;
import org.emftext.language.efactory.resource.efactory.IEfactoryReferenceResolver;

public class ReferenceValueReferenceResolver implements IEfactoryReferenceResolver<Reference, NewObject> {
	
	private EfactoryDefaultResolverDelegate<Reference, NewObject> delegate = new EfactoryDefaultResolverDelegate<Reference, NewObject>();
	
	public void resolve(String identifier, Reference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final IEfactoryReferenceResolveResult<NewObject> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(NewObject element, Reference container, EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
