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
