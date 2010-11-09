/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.egui.resource.egui.analysis;

public class ActionBindingStateReferenceResolver implements org.emftext.language.egui.resource.egui.IEguiReferenceResolver<org.emftext.language.egui.actions.ActionBinding, org.emftext.language.egui.statemodel.State> {
	
	private org.emftext.language.egui.resource.egui.analysis.EguiDefaultResolverDelegate<org.emftext.language.egui.actions.ActionBinding, org.emftext.language.egui.statemodel.State> delegate = new org.emftext.language.egui.resource.egui.analysis.EguiDefaultResolverDelegate<org.emftext.language.egui.actions.ActionBinding, org.emftext.language.egui.statemodel.State>();
	
	public void resolve(String identifier, org.emftext.language.egui.actions.ActionBinding container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.egui.resource.egui.IEguiReferenceResolveResult<org.emftext.language.egui.statemodel.State> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.egui.statemodel.State element, org.emftext.language.egui.actions.ActionBinding container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
