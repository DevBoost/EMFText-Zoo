package org.emftext.language.uml_class.resource.uml_class.ui;

// This class provides the configuration for all EMFText editors. It registers
// content assistance and syntax highlighting.
public class Uml_classEditorConfiguration extends org.eclipse.jface.text.source.SourceViewerConfiguration {
	
	private org.emftext.language.uml_class.resource.uml_class.ui.Uml_classColorManager colorManager;
	private org.emftext.language.uml_class.resource.uml_class.ui.Uml_classEditor theEditor;
	
	// Create a new editor configuration.
	//
	// @param editor
	// @param colorManager
	///
	public Uml_classEditorConfiguration(org.emftext.language.uml_class.resource.uml_class.ui.Uml_classEditor editor, org.emftext.language.uml_class.resource.uml_class.ui.Uml_classColorManager colorManager) {
		this.theEditor = editor;
		this.colorManager = colorManager;
	}
	
	public org.eclipse.jface.text.contentassist.IContentAssistant getContentAssistant(org.eclipse.jface.text.source.ISourceViewer sourceViewer) {
		
		org.eclipse.jface.text.contentassist.ContentAssistant assistant = new org.eclipse.jface.text.contentassist.ContentAssistant();
		assistant.setContentAssistProcessor(new org.emftext.language.uml_class.resource.uml_class.ui.Uml_classCompletionProcessor(theEditor), org.eclipse.jface.text.IDocument.DEFAULT_CONTENT_TYPE);
		assistant.enableAutoActivation(true);
		assistant.setAutoActivationDelay(500);
		assistant.setProposalPopupOrientation(org.eclipse.jface.text.contentassist.IContentAssistant.PROPOSAL_OVERLAY);
		assistant.setContextInformationPopupOrientation(org.eclipse.jface.text.contentassist.IContentAssistant.CONTEXT_INFO_ABOVE);
		
		return assistant;
	}
	
	public String[] getConfiguredContentTypes(org.eclipse.jface.text.source.ISourceViewer sourceViewer) {
		return new String[] {
			org.eclipse.jface.text.IDocument.DEFAULT_CONTENT_TYPE,
		};
	}
	
	// @param fileExtension
	// @return
	///
	protected org.eclipse.jface.text.rules.ITokenScanner getScanner(String fileName) {
		org.eclipse.ui.part.FileEditorInput input = (org.eclipse.ui.part.FileEditorInput) theEditor.getEditorInput();
		String path = input.getFile().getFullPath().toString();
		org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource thisResource = (org.emftext.language.uml_class.resource.uml_class.IUml_classTextResource) theEditor.getResourceSet().getResource(org.eclipse.emf.common.util.URI.createPlatformResourceURI(path, true), true);
		
		return new org.emftext.language.uml_class.resource.uml_class.ui.Uml_classTokenScanner(thisResource, colorManager);
	}
	
	public org.eclipse.jface.text.presentation.IPresentationReconciler getPresentationReconciler(org.eclipse.jface.text.source.ISourceViewer sourceViewer) {
		
		org.eclipse.jface.text.presentation.PresentationReconciler reconciler = new org.eclipse.jface.text.presentation.PresentationReconciler();
		String fileName = theEditor.getEditorInput().getName();
		
		org.eclipse.jface.text.rules.DefaultDamagerRepairer repairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(getScanner(fileName));
		reconciler.setDamager(repairer, org.eclipse.jface.text.IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(repairer, org.eclipse.jface.text.IDocument.DEFAULT_CONTENT_TYPE);
		
		return reconciler;
	}
	
	public org.eclipse.jface.text.source.IAnnotationHover getAnnotationHover(org.eclipse.jface.text.source.ISourceViewer sourceViewer) {
		return new org.eclipse.jface.text.source.DefaultAnnotationHover();
	}
	
	public org.eclipse.jface.text.ITextHover getTextHover(org.eclipse.jface.text.source.ISourceViewer sourceViewer, String contentType) {
		return new org.emftext.language.uml_class.resource.uml_class.ui.Uml_classTextHover(theEditor);
	}
	
	public org.eclipse.jface.text.hyperlink.IHyperlinkDetector[] getHyperlinkDetectors(org.eclipse.jface.text.source.ISourceViewer sourceViewer) {
		if (sourceViewer == null) {
			return null;
		}
		return new org.eclipse.jface.text.hyperlink.IHyperlinkDetector[] { new org.emftext.language.uml_class.resource.uml_class.ui.Uml_classHyperlinkDetector(theEditor.getResource()) };
	}
	
}
