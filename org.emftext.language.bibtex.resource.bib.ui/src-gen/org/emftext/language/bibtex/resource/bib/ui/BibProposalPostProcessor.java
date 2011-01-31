/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class BibProposalPostProcessor {
	
	public java.util.List<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal> process(java.util.List<org.emftext.language.bibtex.resource.bib.ui.BibCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
