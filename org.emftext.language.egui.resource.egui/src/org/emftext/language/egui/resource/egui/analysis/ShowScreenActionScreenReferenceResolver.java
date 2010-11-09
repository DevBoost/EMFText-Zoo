/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.egui.resource.egui.analysis;

public class ShowScreenActionScreenReferenceResolver implements org.emftext.language.egui.resource.egui.IEguiReferenceResolver<org.emftext.language.egui.actions.ShowScreenAction, org.emftext.language.egui.screenmodel.Screen> {
	
	private org.emftext.language.egui.resource.egui.analysis.EguiDefaultResolverDelegate<org.emftext.language.egui.actions.ShowScreenAction, org.emftext.language.egui.screenmodel.Screen> delegate = new org.emftext.language.egui.resource.egui.analysis.EguiDefaultResolverDelegate<org.emftext.language.egui.actions.ShowScreenAction, org.emftext.language.egui.screenmodel.Screen>();
	
	public void resolve(String identifier, org.emftext.language.egui.actions.ShowScreenAction container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.egui.resource.egui.IEguiReferenceResolveResult<org.emftext.language.egui.screenmodel.Screen> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.egui.screenmodel.Screen element, org.emftext.language.egui.actions.ShowScreenAction container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
