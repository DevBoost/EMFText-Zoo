/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.mopp;

public class BibSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getBibliography(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getBibtexKeyField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getTitleField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getBookTitleField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getYearField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getAuthorField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getAuthor(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getJournalField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getVolumeField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getPageField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getPage(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getInProceedingsEntry(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getArticleEntry(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getBibliography(),
		};
	}
	
}
