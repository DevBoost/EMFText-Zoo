package org.emftext.language.uml_class.resource.uml_class.ui;

public class Uml_classCompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {
	
	private org.emftext.language.uml_class.resource.uml_class.ui.Uml_classEditor editor;
	
	public Uml_classCompletionProcessor(org.emftext.language.uml_class.resource.uml_class.ui.Uml_classEditor editor) {
		this.editor = editor;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		
		org.eclipse.emf.ecore.resource.Resource resource = editor.getResource();
		org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource textResource = (org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource) resource;
		String content = viewer.getDocument().get();
		org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classCodeCompletionHelper helper = new org.emftext.language.uml_class.resource.uml_class.mopp.Uml_classCodeCompletionHelper();
		java.util.Collection<String> proposals = helper.computeCompletionProposals(textResource.getMetaInformation(), content, offset);
		
		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[proposals.size()];
		int i = 0;
		for (String proposal : proposals) {
			org.eclipse.jface.text.contentassist.IContextInformation info = new org.eclipse.jface.text.contentassist.ContextInformation(proposal, proposal);
			String contentBefore = content.substring(0, offset);
			String insertString = org.emftext.language.uml_class.resource.uml_class.util.Uml_classStringUtil.getMissingTail(contentBefore, proposal);
			result[i++] = new org.eclipse.jface.text.contentassist.CompletionProposal(insertString, offset, 0, insertString.length(), null, proposal, info, proposal);
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
