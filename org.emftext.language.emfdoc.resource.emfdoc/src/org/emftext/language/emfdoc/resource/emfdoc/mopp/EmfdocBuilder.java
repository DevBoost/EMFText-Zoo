/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.emfdoc.resource.emfdoc.mopp;

import java.io.IOException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.ecoredoc.Documentation;
import org.emftext.language.ecoredoc.DocumentationElement;

public class EmfdocBuilder implements org.emftext.language.ecoredoc.resource.ecoredoc.IEcoredocBuilder {
	
	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri) {
		return true;
	}
	public org.eclipse.core.runtime.IStatus build(org.emftext.language.ecoredoc.resource.ecoredoc.mopp.EcoredocResource resource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		EList<EObject> contents = resource.getContents();
		if (contents.isEmpty()) {
			return org.eclipse.core.runtime.Status.OK_STATUS;
		}
		EObject root = contents.get(0);
		Documentation documentation = (Documentation) root;
		// transfer documentation to Ecore model
		for (DocumentationElement element : documentation.getDocumentationElements()) {
			EModelElement documentedElement = element.getDocumentedElement();
			EcoreUtil.setDocumentation(documentedElement, element.getText());
		}
		// save Ecore model
		EPackage documentedPackage = documentation.getDocumentedPackage();
		if (documentedPackage == null) {
			return org.eclipse.core.runtime.Status.OK_STATUS;
		}
		try {
			Resource eResource = documentedPackage.eResource();
			if (eResource == null) {
				return org.eclipse.core.runtime.Status.OK_STATUS;
			}
			eResource.save(null);
			return org.eclipse.core.runtime.Status.OK_STATUS;
		} catch (IOException e) {
			return new Status(IStatus.ERROR, EcoredocPlugin.PLUGIN_ID, "Exception while adding documentation to Ecore model.");
		}
	}
}
