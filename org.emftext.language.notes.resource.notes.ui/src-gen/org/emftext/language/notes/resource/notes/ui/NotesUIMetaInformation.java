/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.ui;

public class NotesUIMetaInformation extends org.emftext.language.notes.resource.notes.mopp.NotesMetaInformation {
	
	public org.emftext.language.notes.resource.notes.INotesHoverTextProvider getHoverTextProvider() {
		return new org.emftext.language.notes.resource.notes.ui.NotesHoverTextProvider();
	}
	
	public org.emftext.language.notes.resource.notes.ui.NotesImageProvider getImageProvider() {
		return org.emftext.language.notes.resource.notes.ui.NotesImageProvider.INSTANCE;
	}
	
	public org.emftext.language.notes.resource.notes.ui.NotesColorManager createColorManager() {
		return new org.emftext.language.notes.resource.notes.ui.NotesColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(org.emftext.language.notes.resource.notes.INotesTextResource,
	 * org.emftext.language.notes.resource.notes.ui.NotesColorManager) instead.
	 */
	public org.emftext.language.notes.resource.notes.ui.NotesTokenScanner createTokenScanner(org.emftext.language.notes.resource.notes.ui.NotesColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public org.emftext.language.notes.resource.notes.ui.NotesTokenScanner createTokenScanner(org.emftext.language.notes.resource.notes.INotesTextResource resource, org.emftext.language.notes.resource.notes.ui.NotesColorManager colorManager) {
		return new org.emftext.language.notes.resource.notes.ui.NotesTokenScanner(resource, colorManager);
	}
	
	public org.emftext.language.notes.resource.notes.ui.NotesCodeCompletionHelper createCodeCompletionHelper() {
		return new org.emftext.language.notes.resource.notes.ui.NotesCodeCompletionHelper();
	}
	
}
