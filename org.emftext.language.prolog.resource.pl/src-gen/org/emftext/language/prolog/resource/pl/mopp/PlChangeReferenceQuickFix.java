/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.mopp;

/**
 * A quick fix that replaces the target of a reference with another EObject. This
 * class is used to implement default quick fixes for references that could not be
 * resolved, but can also be used by custom reference resolvers.
 */
public class PlChangeReferenceQuickFix extends org.emftext.language.prolog.resource.pl.mopp.PlQuickFix {
	
	private org.eclipse.emf.ecore.EObject container;
	private org.eclipse.emf.ecore.EReference reference;
	private org.eclipse.emf.ecore.EObject oldTarget;
	private org.eclipse.emf.ecore.EObject newTarget;
	
	public PlChangeReferenceQuickFix(String displayString, String imageKey, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, org.eclipse.emf.ecore.EObject oldTarget, org.eclipse.emf.ecore.EObject newTarget) {
		super(displayString, imageKey, java.util.Arrays.asList(container, reference, oldTarget));
		this.container = container;
		this.reference = reference;
		this.oldTarget = oldTarget;
		this.newTarget = newTarget;
	}
	
	@Override	
	public void applyChanges() {
		org.eclipse.emf.ecore.util.EcoreUtil.replace(container, reference, oldTarget, newTarget);
	}
	
}
