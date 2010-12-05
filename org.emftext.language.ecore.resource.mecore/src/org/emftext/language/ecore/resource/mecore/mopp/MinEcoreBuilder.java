/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.ecore.resource.mecore.mopp;

import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.ecore.resource.mecore.IMinEcoreBuilder;
import org.emftext.language.mecore.MPackage;

public class MinEcoreBuilder implements IMinEcoreBuilder {
	
	public boolean isBuildingNeeded(URI uri) {
		return true;
	}
	
	public IStatus build(MinEcoreResource resource, IProgressMonitor monitor) {
		// set option overrideBuilder to 'false' and then perform build here
		EList<EObject> contents = resource.getContents();
		URI ecoreURI = resource.getURI().trimFileExtension().trimFileExtension().appendFileExtension("ecore");
		Resource ecoreResource = resource.getResourceSet().createResource(ecoreURI);
		MinEcoreWrapper wrapper = new MinEcoreWrapper();
		for (EObject eObject : contents) {
			if (eObject instanceof MPackage) {
				MPackage mPackage = (MPackage) eObject;
				ecoreResource.getContents().add(wrapper.wrapMPackage(mPackage));
			}
		}
		try {
			ecoreResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
			return org.eclipse.core.runtime.Status.CANCEL_STATUS;
		}
		
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}
	
}
