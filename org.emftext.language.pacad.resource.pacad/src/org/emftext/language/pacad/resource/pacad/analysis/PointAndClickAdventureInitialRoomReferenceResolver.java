
package org.emftext.language.pacad.resource.pacad.analysis;

import org.emftext.language.pacad.resource.pacad.analysis.helper.ObjectResolver;

public class PointAndClickAdventureInitialRoomReferenceResolver implements org.emftext.language.pacad.resource.pacad.IPacadReferenceResolver<org.emftext.language.pacad.PointAndClickAdventure, org.emftext.language.pacad.Room> {
	
	private ObjectResolver delegate = new ObjectResolver();
	
	public void resolve(String identifier, org.emftext.language.pacad.PointAndClickAdventure container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.pacad.resource.pacad.IPacadReferenceResolveResult<org.emftext.language.pacad.Room> result) {
		//System.out.println("Trying to resolve " + identifier);
		try {
			delegate.resolveRoom(identifier, container, reference, position, resolveFuzzy, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		if (!result.wasResolved()) {
			System.out.println("Can't resolve " + identifier);
		} else {
			System.out.println("Resolved " + identifier);
		}
		*/
	}
	
	public String deResolve(org.emftext.language.pacad.Room element, org.emftext.language.pacad.PointAndClickAdventure container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
