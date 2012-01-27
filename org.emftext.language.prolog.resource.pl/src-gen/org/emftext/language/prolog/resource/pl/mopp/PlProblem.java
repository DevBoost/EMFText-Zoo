/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.mopp;

public class PlProblem implements org.emftext.language.prolog.resource.pl.IPlProblem {
	
	private String message;
	private org.emftext.language.prolog.resource.pl.PlEProblemType type;
	private org.emftext.language.prolog.resource.pl.PlEProblemSeverity severity;
	private java.util.Collection<org.emftext.language.prolog.resource.pl.IPlQuickFix> quickFixes;
	
	public PlProblem(String message, org.emftext.language.prolog.resource.pl.PlEProblemType type, org.emftext.language.prolog.resource.pl.PlEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<org.emftext.language.prolog.resource.pl.IPlQuickFix>emptySet());
	}
	
	public PlProblem(String message, org.emftext.language.prolog.resource.pl.PlEProblemType type, org.emftext.language.prolog.resource.pl.PlEProblemSeverity severity, org.emftext.language.prolog.resource.pl.IPlQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public PlProblem(String message, org.emftext.language.prolog.resource.pl.PlEProblemType type, org.emftext.language.prolog.resource.pl.PlEProblemSeverity severity, java.util.Collection<org.emftext.language.prolog.resource.pl.IPlQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<org.emftext.language.prolog.resource.pl.IPlQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public org.emftext.language.prolog.resource.pl.PlEProblemType getType() {
		return type;
	}
	
	public org.emftext.language.prolog.resource.pl.PlEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<org.emftext.language.prolog.resource.pl.IPlQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
