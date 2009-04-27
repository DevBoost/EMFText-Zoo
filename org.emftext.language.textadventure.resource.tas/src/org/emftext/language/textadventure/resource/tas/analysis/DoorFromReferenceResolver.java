package org.emftext.language.textadventure.resource.tas.analysis;

public class DoorFromReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.textadventure.Door, org.emftext.language.textadventure.Room> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.language.textadventure.Room element, org.emftext.language.textadventure.Door container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.textadventure.Door container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.textadventure.Room> result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
