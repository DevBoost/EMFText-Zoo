/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class PlProposalPostProcessor {
	
	public java.util.List<org.emftext.language.prolog.resource.pl.ui.PlCompletionProposal> process(java.util.List<org.emftext.language.prolog.resource.pl.ui.PlCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
