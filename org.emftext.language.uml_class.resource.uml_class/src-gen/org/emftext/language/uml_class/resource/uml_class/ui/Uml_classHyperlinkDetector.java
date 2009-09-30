package org.emftext.language.uml_class.resource.uml_class.ui;

// A hyperlink detector returns hyperlink if the token, where the mouse cursor
// hovers, is a proxy.
public class Uml_classHyperlinkDetector implements org.eclipse.jface.text.hyperlink.IHyperlinkDetector {
	
	private org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource textResource;
	
	// Creates a hyperlink detector.
	// @param resource the resource for calculating the locations.
	public Uml_classHyperlinkDetector(org.eclipse.emf.ecore.resource.Resource resource) {
		textResource = (org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource) resource;
	}
	
	public org.eclipse.jface.text.hyperlink.IHyperlink[] detectHyperlinks(org.eclipse.jface.text.ITextViewer textViewer, org.eclipse.jface.text.IRegion region, boolean canShowMultipleHyperlinks) {
		org.emftext.language.uml_class.resource.uml_class.IUml_classLocationMap locationMap = textResource.getLocationMap();
		String resourceFileExtension = textResource.getURI().fileExtension();
		java.util.List<org.eclipse.emf.ecore.EObject> elementsAtOffset = locationMap.getElementsAt(region.getOffset());
		org.eclipse.emf.ecore.EObject resolvedEObject = null;
		for (org.eclipse.emf.ecore.EObject eObject : elementsAtOffset) {
			if (eObject.eIsProxy()) {
				resolvedEObject = org.eclipse.emf.ecore.util.EcoreUtil.resolve(eObject, textResource);
				if (resolvedEObject == eObject || (resolvedEObject.eResource() != null && !resourceFileExtension.equals(resolvedEObject.eResource().getURI().fileExtension()))) {
					continue;
				}
				int offset = locationMap.getCharStart(eObject);
				int length = locationMap.getCharEnd(eObject) - offset + 1;
				String text = null;
				try {
					text = textViewer.getDocument().get(offset, length);
				} catch (org.eclipse.jface.text.BadLocationException e) {
				}
				org.eclipse.jface.text.hyperlink.IHyperlink hyperlink = new org.emftext.language.uml_class.resource.uml_class.ui.Uml_classHyperlink(new org.eclipse.jface.text.Region(offset, length), resolvedEObject, text);
				return new org.eclipse.jface.text.hyperlink.IHyperlink[] { hyperlink };
			}
		}
		return null;
	}
}
