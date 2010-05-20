/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.abnf.resource.abnf.ui;

public class AbnfCompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {
	
	private org.emftext.language.abnf.resource.abnf.ui.AbnfEditor editor;
	
	public AbnfCompletionProcessor(org.emftext.language.abnf.resource.abnf.ui.AbnfEditor editor) {
		this.editor = editor;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		
		org.eclipse.emf.ecore.resource.Resource resource = editor.getResource();
		org.emftext.language.abnf.resource.abnf.IAbnfTextResource textResource = (org.emftext.language.abnf.resource.abnf.IAbnfTextResource) resource;
		String content = viewer.getDocument().get();
		org.emftext.language.abnf.resource.abnf.ui.AbnfCodeCompletionHelper helper = new org.emftext.language.abnf.resource.abnf.ui.AbnfCodeCompletionHelper();
		org.emftext.language.abnf.resource.abnf.ui.AbnfCompletionProposal[] proposals = helper.computeCompletionProposals(textResource, content, offset);
		
		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[proposals.length];
		int i = 0;
		for (org.emftext.language.abnf.resource.abnf.ui.AbnfCompletionProposal proposal : proposals) {
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
