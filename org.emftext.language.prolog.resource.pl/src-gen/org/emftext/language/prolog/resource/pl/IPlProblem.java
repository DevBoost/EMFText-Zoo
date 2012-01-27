/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl;

public interface IPlProblem {
	public String getMessage();
	public org.emftext.language.prolog.resource.pl.PlEProblemSeverity getSeverity();
	public org.emftext.language.prolog.resource.pl.PlEProblemType getType();
	public java.util.Collection<org.emftext.language.prolog.resource.pl.IPlQuickFix> getQuickFixes();
}
