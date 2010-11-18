/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.egui.resource.egui.analysis;

public class ButtonEventReferenceResolver implements org.emftext.language.egui.resource.egui.IEguiReferenceResolver<org.emftext.language.egui.widgets.Button, org.emftext.language.egui.statemodel.Event> {
	
	private org.emftext.language.egui.resource.egui.analysis.EguiDefaultResolverDelegate<org.emftext.language.egui.widgets.Button, org.emftext.language.egui.statemodel.Event> delegate = new org.emftext.language.egui.resource.egui.analysis.EguiDefaultResolverDelegate<org.emftext.language.egui.widgets.Button, org.emftext.language.egui.statemodel.Event>();
	
	public void resolve(String identifier, org.emftext.language.egui.widgets.Button container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.egui.resource.egui.IEguiReferenceResolveResult<org.emftext.language.egui.statemodel.Event> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.egui.statemodel.Event element, org.emftext.language.egui.widgets.Button container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
