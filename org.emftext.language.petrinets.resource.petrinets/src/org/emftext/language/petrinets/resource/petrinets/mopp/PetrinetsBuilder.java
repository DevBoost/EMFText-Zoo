/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.petrinets.resource.petrinets.mopp;

import org.emftext.language.petrinets.resource.petrinets.PetrinetsEProblemType;
import org.emftext.runtime.owltext.OWLTextValidationMarker;


public class PetrinetsBuilder implements
		org.emftext.language.petrinets.resource.petrinets.IPetrinetsBuilder {

	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri) {
		return true;
	}

	public org.eclipse.core.runtime.IStatus build(
			org.emftext.language.petrinets.resource.petrinets.mopp.PetrinetsResource resource,
			org.eclipse.core.runtime.IProgressMonitor monitor) {
//		if (resource.getErrors().isEmpty()) {
////					OWLTextValidationMarker ovm = new OWLTextValidationMarker();
////					ovm.annotateValidationResults(resource);
//		}
//		else {
//			resource.addError("The petrinet was not build due to errors in the resource",PetrinetsEProblemType.BUILDER_ERROR, resource.getContents().get(0));
//		}
		if (resource.getErrors().isEmpty()) {
			PetriNetsCodeGenerator pcg = new PetriNetsCodeGenerator();
			pcg.generateJavaCode(resource);
		}
		else {
			resource.addWarning("The petrinet may not be build correctly due to errors in the resource",PetrinetsEProblemType.BUILDER_ERROR, resource.getContents().get(0));
			PetriNetsCodeGenerator pcg = new PetriNetsCodeGenerator();
			pcg.generateJavaCode(resource);
		}
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}

}
