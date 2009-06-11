package org.emftext.language.textadventure.resource.tas.analysis;

public class RoomConnectorFromReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.textadventure.RoomConnector, org.emftext.language.textadventure.Room> {
	
	private org.emftext.language.textadventure.resource.tas.analysis.TasDefaultResolverDelegate<org.emftext.language.textadventure.RoomConnector, org.emftext.language.textadventure.Room> delegate = new org.emftext.language.textadventure.resource.tas.analysis.TasDefaultResolverDelegate<org.emftext.language.textadventure.RoomConnector, org.emftext.language.textadventure.Room>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.textadventure.RoomConnector container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.textadventure.Room> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.textadventure.Room element, org.emftext.language.textadventure.RoomConnector container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
