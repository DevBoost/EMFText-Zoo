/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib;

public interface IBibProblem {
	public String getMessage();
	public org.emftext.language.bibtex.resource.bib.BibEProblemSeverity getSeverity();
	public org.emftext.language.bibtex.resource.bib.BibEProblemType getType();
	public java.util.Collection<org.emftext.language.bibtex.resource.bib.IBibQuickFix> getQuickFixes();
}
