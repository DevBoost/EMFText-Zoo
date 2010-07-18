/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.ecoredoc.resource.ecoredoc.analysis;

import java.util.Collection;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.emftext.language.ecoredoc.DocumentationElement;
import org.emftext.language.ecoredoc.resource.ecoredoc.IEcoredocReferenceResolveResult;
import org.emftext.language.ecoredoc.resource.ecoredoc.util.EcoredocEObjectUtil;

public class DocumentationElementDocumentedElementReferenceResolver implements org.emftext.language.ecoredoc.resource.ecoredoc.IEcoredocReferenceResolver<org.emftext.language.ecoredoc.DocumentationElement, org.eclipse.emf.ecore.EModelElement> {
	
	public void resolve(String identifier, DocumentationElement container, EReference reference, int position, boolean resolveFuzzy, final IEcoredocReferenceResolveResult<EModelElement> result) {
		EPackage documentedPackage = container.getDocumentation().getDocumentedPackage();
		Collection<EModelElement> elements = EcoredocEObjectUtil.getObjectsByType(documentedPackage.eAllContents(), EcorePackage.eINSTANCE.getEModelElement());
		for (EModelElement element : elements) {
			String path = getPath(element);
			if (path == null) {
				continue;
			}
			if (resolveFuzzy || identifier.equals(path)) {
				result.addMapping(path, element);
			}
		}
	}
	
	private String getPath(EObject element) {
		if (element instanceof EPackage) {
			return null;
		}
		if (element instanceof ENamedElement) {
			ENamedElement namedElement = (ENamedElement) element;
			String parentPath = getPath(namedElement.eContainer());
			if (parentPath == null) {
				return namedElement.getName();
			} else {
				return parentPath + "." + namedElement.getName();
			}
		}
		return getPath(element.eContainer());
	}

	public String deResolve(EModelElement element, DocumentationElement container, EReference reference) {
		return getPath(element);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
