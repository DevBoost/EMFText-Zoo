/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.ui;

public class PlCompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {
	
	private org.emftext.language.prolog.resource.pl.IPlResourceProvider resourceProvider;
	private org.emftext.language.prolog.resource.pl.ui.IPlBracketHandlerProvider bracketHandlerProvider;
	
	public PlCompletionProcessor(org.emftext.language.prolog.resource.pl.IPlResourceProvider resourceProvider, org.emftext.language.prolog.resource.pl.ui.IPlBracketHandlerProvider bracketHandlerProvider) {
		this.resourceProvider = resourceProvider;
		this.bracketHandlerProvider = bracketHandlerProvider;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		org.emftext.language.prolog.resource.pl.IPlTextResource textResource = resourceProvider.getResource();
		String content = viewer.getDocument().get();
		org.emftext.language.prolog.resource.pl.ui.PlCodeCompletionHelper helper = new org.emftext.language.prolog.resource.pl.ui.PlCodeCompletionHelper();
		org.emftext.language.prolog.resource.pl.ui.PlCompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, content, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		org.emftext.language.prolog.resource.pl.ui.PlProposalPostProcessor proposalPostProcessor = new org.emftext.language.prolog.resource.pl.ui.PlProposalPostProcessor();
		java.util.List<org.emftext.language.prolog.resource.pl.ui.PlCompletionProposal> computedProposalList = java.util.Arrays.asList(computedProposals);
		java.util.List<org.emftext.language.prolog.resource.pl.ui.PlCompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = java.util.Collections.emptyList();
		}
		java.util.List<org.emftext.language.prolog.resource.pl.ui.PlCompletionProposal> finalProposalList = new java.util.ArrayList<org.emftext.language.prolog.resource.pl.ui.PlCompletionProposal>();
		for (org.emftext.language.prolog.resource.pl.ui.PlCompletionProposal proposal : extendedProposalList) {
			if (proposal.getMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (org.emftext.language.prolog.resource.pl.ui.PlCompletionProposal proposal : finalProposalList) {
			String proposalString = proposal.getInsertString();
			String displayString = proposal.getDisplayString();
			String prefix = proposal.getPrefix();
			org.eclipse.swt.graphics.Image image = proposal.getImage();
			org.eclipse.jface.text.contentassist.IContextInformation info;
			info = new org.eclipse.jface.text.contentassist.ContextInformation(image, proposalString, proposalString);
			int begin = offset - prefix.length();
			int replacementLength = prefix.length();
			// if a closing bracket was automatically inserted right before, we enlarge the
			// replacement length in order to overwrite the bracket.
			org.emftext.language.prolog.resource.pl.ui.IPlBracketHandler bracketHandler = bracketHandlerProvider.getBracketHandler();
			String closingBracket = bracketHandler.getClosingBracket();
			if (bracketHandler.addedClosingBracket() && proposalString.endsWith(closingBracket)) {
				replacementLength += closingBracket.length();
			}
			result[i++] = new org.eclipse.jface.text.contentassist.CompletionProposal(proposalString, begin, replacementLength, proposalString.length(), image, displayString, info, proposalString);
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
