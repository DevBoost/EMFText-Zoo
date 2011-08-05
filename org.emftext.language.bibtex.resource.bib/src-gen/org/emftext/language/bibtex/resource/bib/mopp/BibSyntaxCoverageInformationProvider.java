/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.language.bibtex.resource.bib.mopp;

public class BibSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getBibliography(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getBibtexKeyField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getAuthorField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getAuthor(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getEditorField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getEditor(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getKeywordField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getKeyword(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getTitleField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getBookTitleField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getSeriesField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getAddressField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getMonthField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getOrganizationField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getPublisherField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getJournalField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getNoteField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getEidField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getAbstractField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getReviewField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getUrlField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getYearField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getVolumeField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getPartField(),
			org.emftext.language.bibtex.BibtexPackage.eINSTANCE.getNumberField(),
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
