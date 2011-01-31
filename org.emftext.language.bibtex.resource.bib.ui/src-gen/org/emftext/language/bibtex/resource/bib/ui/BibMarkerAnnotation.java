/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.ui;

public class BibMarkerAnnotation extends org.eclipse.ui.texteditor.MarkerAnnotation implements org.eclipse.jface.text.quickassist.IQuickFixableAnnotation {
	
	boolean quickFixableState;
	boolean isQuickFixable;
	
	public BibMarkerAnnotation(org.eclipse.core.resources.IMarker marker) {
		super(marker);
	}
	
	public void setQuickFixable(boolean state) {
		isQuickFixable = state;
		quickFixableState = true;
	}
	
	public boolean isQuickFixableStateSet() {
		return true;
		//return quickFixableState;
	}
	
	public boolean isQuickFixable() {
		try {
			return getMarker().getAttribute(org.eclipse.core.resources.IMarker.SOURCE_ID) != null;
		} catch (org.eclipse.core.runtime.CoreException e) {
			// ignore
		}
		return false;
	}
	
}
