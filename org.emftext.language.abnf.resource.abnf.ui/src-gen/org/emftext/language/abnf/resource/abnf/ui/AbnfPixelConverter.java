/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.abnf.resource.abnf.ui;

/**
 * A utility class for pixel conversion.
 */
public class AbnfPixelConverter {
	
	private org.eclipse.swt.graphics.FontMetrics fFontMetrics;
	
	public AbnfPixelConverter(org.eclipse.swt.widgets.Control control) {
		org.eclipse.swt.graphics.GC gc = new org.eclipse.swt.graphics.GC(control);
		gc.setFont(control.getFont());
		fFontMetrics= gc.getFontMetrics();
		gc.dispose();
	}
	
	public int convertHeightInCharsToPixels(int chars) {
		return org.eclipse.jface.dialogs.Dialog.convertHeightInCharsToPixels(fFontMetrics, chars);
	}
	
	public int convertHorizontalDLUsToPixels(int dlus) {
		return org.eclipse.jface.dialogs.Dialog.convertHorizontalDLUsToPixels(fFontMetrics, dlus);
	}
	
	public int convertVerticalDLUsToPixels(int dlus) {
		return org.eclipse.jface.dialogs.Dialog.convertVerticalDLUsToPixels(fFontMetrics, dlus);
	}
	
	public int convertWidthInCharsToPixels(int chars) {
		return org.eclipse.jface.dialogs.Dialog.convertWidthInCharsToPixels(fFontMetrics, chars);
	}
	
}
