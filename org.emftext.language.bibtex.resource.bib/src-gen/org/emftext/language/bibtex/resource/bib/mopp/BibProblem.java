/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.mopp;

public class BibProblem implements org.emftext.language.bibtex.resource.bib.IBibProblem {
	
	private String message;
	private org.emftext.language.bibtex.resource.bib.BibEProblemType type;
	private org.emftext.language.bibtex.resource.bib.BibEProblemSeverity severity;
	private java.util.Collection<org.emftext.language.bibtex.resource.bib.IBibQuickFix> quickFixes;
	
	public BibProblem(String message, org.emftext.language.bibtex.resource.bib.BibEProblemType type, org.emftext.language.bibtex.resource.bib.BibEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<org.emftext.language.bibtex.resource.bib.IBibQuickFix>emptySet());
	}
	
	public BibProblem(String message, org.emftext.language.bibtex.resource.bib.BibEProblemType type, org.emftext.language.bibtex.resource.bib.BibEProblemSeverity severity, org.emftext.language.bibtex.resource.bib.IBibQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public BibProblem(String message, org.emftext.language.bibtex.resource.bib.BibEProblemType type, org.emftext.language.bibtex.resource.bib.BibEProblemSeverity severity, java.util.Collection<org.emftext.language.bibtex.resource.bib.IBibQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<org.emftext.language.bibtex.resource.bib.IBibQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public org.emftext.language.bibtex.resource.bib.BibEProblemType getType() {
		return type;
	}
	
	public org.emftext.language.bibtex.resource.bib.BibEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<org.emftext.language.bibtex.resource.bib.IBibQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
