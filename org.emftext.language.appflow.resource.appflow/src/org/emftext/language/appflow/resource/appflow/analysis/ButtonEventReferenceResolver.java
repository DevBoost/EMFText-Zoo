/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.appflow.resource.appflow.analysis;

public class ButtonEventReferenceResolver implements org.emftext.language.appflow.resource.appflow.IAppflowReferenceResolver<org.emftext.language.appflow.widgets.Button, org.emftext.language.appflow.statemodel.Event> {
	
	private org.emftext.language.appflow.resource.appflow.analysis.AppflowDefaultResolverDelegate<org.emftext.language.appflow.widgets.Button, org.emftext.language.appflow.statemodel.Event> delegate = new org.emftext.language.appflow.resource.appflow.analysis.AppflowDefaultResolverDelegate<org.emftext.language.appflow.widgets.Button, org.emftext.language.appflow.statemodel.Event>();
	
	public void resolve(String identifier, org.emftext.language.appflow.widgets.Button container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.appflow.resource.appflow.IAppflowReferenceResolveResult<org.emftext.language.appflow.statemodel.Event> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.appflow.statemodel.Event element, org.emftext.language.appflow.widgets.Button container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
