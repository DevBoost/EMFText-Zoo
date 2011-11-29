/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class NotesProposalPostProcessor {
	
	public java.util.List<org.emftext.language.notes.resource.notes.ui.NotesCompletionProposal> process(java.util.List<org.emftext.language.notes.resource.notes.ui.NotesCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
