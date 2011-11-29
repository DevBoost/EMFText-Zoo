/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.mopp;

public class NotesSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.notes.NotesPackage.eINSTANCE.getNoteDocument(),
			org.emftext.language.notes.NotesPackage.eINSTANCE.getSection(),
			org.emftext.language.notes.NotesPackage.eINSTANCE.getBulletPoint(),
			org.emftext.language.notes.NotesPackage.eINSTANCE.getSimpleText(),
			org.emftext.language.notes.NotesPackage.eINSTANCE.getBold(),
			org.emftext.language.notes.NotesPackage.eINSTANCE.getItalic(),
			org.emftext.language.notes.NotesPackage.eINSTANCE.getTypeWriter(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.notes.NotesPackage.eINSTANCE.getNoteDocument(),
		};
	}
	
}
