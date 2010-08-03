package org.emftext.language.emfdoc.constraints;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.ecoredoc.DocumentationElement;
import org.emftext.language.ecoredoc.ecoredocPackage;
import org.emftext.language.ecoredoc.resource.ecoredoc.EcoredocEProblemType;
import org.emftext.language.ecoredoc.resource.ecoredoc.IEcoredocProblem;
import org.emftext.language.ecoredoc.resource.ecoredoc.IEcoredocQuickFix;
import org.emftext.language.ecoredoc.resource.ecoredoc.IEcoredocResourcePostProcessor;
import org.emftext.language.ecoredoc.resource.ecoredoc.mopp.EcoredocProblem;
import org.emftext.language.ecoredoc.resource.ecoredoc.mopp.EcoredocQuickFix;
import org.emftext.language.ecoredoc.resource.ecoredoc.mopp.EcoredocResource;
import org.emftext.language.ecoredoc.resource.ecoredoc.util.EcoredocEObjectUtil;

public class DuplicateDocumentationElementChecker implements IEcoredocResourcePostProcessor {

	public void process(EcoredocResource resource) {
		Set<EModelElement> documentedElements = new LinkedHashSet<EModelElement>();
		EList<EObject> contents = resource.getContents();
		for (EObject content : contents) {
			Collection<DocumentationElement> documentationElements = EcoredocEObjectUtil.getObjectsByType(content.eAllContents(), ecoredocPackage.eINSTANCE.getDocumentationElement());
			for (final DocumentationElement documentationElement : documentationElements) {
				EModelElement documentedElement = documentationElement.getDocumentedElement();
				if (documentedElements.contains(documentedElement)) {
					IEcoredocQuickFix quickFix = new EcoredocQuickFix("Remove documentation", "IMG_ELCL_REMOVE", documentationElement) {
						
						@Override
						public void applyChanges() {
							EcoreUtil.remove(documentationElement);
						}
					};
					IEcoredocProblem problem = new EcoredocProblem(
							"Found duplicate documentation", 
							EcoredocEProblemType.ERROR, 
							quickFix
					);
					resource.addProblem(
							problem, 
							documentationElement
					);
				} else {
					documentedElements.add(documentedElement);
				}
			}
		}
	}
}
