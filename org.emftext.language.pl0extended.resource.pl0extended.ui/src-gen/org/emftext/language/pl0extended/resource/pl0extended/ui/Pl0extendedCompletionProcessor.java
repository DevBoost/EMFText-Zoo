/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0extended.resource.pl0extended.ui;

public class Pl0extendedCompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {
	
	private org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedEditor editor;
	
	public Pl0extendedCompletionProcessor(org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedEditor editor) {
		this.editor = editor;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		
		org.eclipse.emf.ecore.resource.Resource resource = editor.getResource();
		org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedTextResource textResource = (org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedTextResource) resource;
		String content = viewer.getDocument().get();
		org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedCodeCompletionHelper helper = new org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedCodeCompletionHelper();
		org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedCompletionProposal[] proposals = helper.computeCompletionProposals(textResource, content, offset);
		
		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[proposals.length];
		int i = 0;
		for (org.emftext.language.pl0extended.resource.pl0extended.ui.Pl0extendedCompletionProposal proposal : proposals) {
			java.lang.String proposalString = proposal.getInsertString();
			java.lang.String prefix = proposal.getPrefix();
			org.eclipse.swt.graphics.Image image = proposal.getImage();
			org.eclipse.jface.text.contentassist.IContextInformation info;
			info = new org.eclipse.jface.text.contentassist.ContextInformation(image, proposalString, proposalString);
			int begin = offset - prefix.length();
			result[i++] = new org.eclipse.jface.text.contentassist.CompletionProposal(proposalString, begin, prefix.length(), proposalString.length(), image, proposalString, info, proposalString);
		}
		return result;
	}
	
	public org.eclipse.jface.text.contentassist.IContextInformation[] computeContextInformation(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		return null;
	}
	
	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}
	
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}
	
	public org.eclipse.jface.text.contentassist.IContextInformationValidator getContextInformationValidator() {
		return null;
	}
	
	public String getErrorMessage() {
		return null;
	}
}
