package org.emftext.language.java.javabehavior4uml.resource.javabehavior.analysis;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Type;

public class BehaviorSpecificationReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.eclipse.uml2.uml.Behavior, org.eclipse.uml2.uml.BehavioralFeature> {
	
	@Override	
	protected java.lang.String doDeResolve(org.eclipse.uml2.uml.BehavioralFeature element, org.eclipse.uml2.uml.Behavior container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.eclipse.uml2.uml.Behavior container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.eclipse.uml2.uml.BehavioralFeature> result) {
		URI uri = container.eResource().getURI();
		
		//If there is a parent UML Model ensure that it is loaded
		while(!uri.fileExtension().equals("uml") && uri.fileExtension() != null) {
			uri = uri.trimFileExtension();
		}
		
		if(uri.fileExtension() != null) {
			//ensure resource is loaded and contaiment proxies are resolved
			Resource umlResource = container.eResource().getResourceSet().getResource(uri, true);
			EcoreUtil.resolveAll(umlResource);
		}
		
		if(container.eContainer() instanceof BehavioredClassifier) {
			Operation operation = ((BehavioredClassifier)container.eContainer()).getOperation(
					identifier,
					ECollections.<String>emptyEList(), 
					ECollections.<Type>emptyEList());
			if (operation != null) {
				result.addMapping(identifier, operation);
			}
		}
	}
}
