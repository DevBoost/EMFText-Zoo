package org.eclipse.emf.ecore.resource.ecore.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class EReferenceEOppositeReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.eclipse.emf.ecore.EReference, org.eclipse.emf.ecore.EReference> {
	
	@Override	
	protected java.lang.String doDeResolve(org.eclipse.emf.ecore.EReference element, org.eclipse.emf.ecore.EReference container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.eclipse.emf.ecore.EReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult result) {
		EClass oppositeType = container.getEReferenceType();
		if (!resolveFuzzy) {
			EStructuralFeature opposite = oppositeType.getEStructuralFeature(identifier);
			result.addMapping(identifier, opposite);
		} else {
			EList<EReference> references = oppositeType.getEReferences();
			for (EReference structuralFeature : references) {
				if (structuralFeature.getName().startsWith(identifier)) {
					result.addMapping(structuralFeature.getName(), structuralFeature);
				}
			}
		}
		
	}
}
