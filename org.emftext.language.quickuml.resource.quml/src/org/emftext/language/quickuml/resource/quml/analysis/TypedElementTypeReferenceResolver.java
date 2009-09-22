package org.emftext.language.quickuml.resource.quml.analysis;

import org.emftext.language.quickuml.resource.quml.IQumlReferenceResolveResult;
import org.emftext.language.quickuml.resource.quml.IQumlReferenceResolver;

public class TypedElementTypeReferenceResolver implements IQumlReferenceResolver<org.eclipse.uml2.uml.TypedElement, org.eclipse.uml2.uml.Type> {
	
	private org.emftext.language.quickuml.resource.quml.analysis.QumlDefaultResolverDelegate<org.eclipse.uml2.uml.TypedElement, org.eclipse.uml2.uml.Type> delegate = new org.emftext.language.quickuml.resource.quml.analysis.QumlDefaultResolverDelegate<org.eclipse.uml2.uml.TypedElement, org.eclipse.uml2.uml.Type>();
	
	public void resolve(java.lang.String identifier, org.eclipse.uml2.uml.TypedElement container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IQumlReferenceResolveResult<org.eclipse.uml2.uml.Type> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.eclipse.uml2.uml.Type element, org.eclipse.uml2.uml.TypedElement container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
