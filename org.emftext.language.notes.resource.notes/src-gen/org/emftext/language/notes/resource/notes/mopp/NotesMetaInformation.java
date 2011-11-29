/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.mopp;

public class NotesMetaInformation implements org.emftext.language.notes.resource.notes.INotesMetaInformation {
	
	public String getSyntaxName() {
		return "notes";
	}
	
	public String getURI() {
		return "http://org.emftext/notes";
	}
	
	public org.emftext.language.notes.resource.notes.INotesTextScanner createLexer() {
		return new org.emftext.language.notes.resource.notes.mopp.NotesAntlrScanner(new org.emftext.language.notes.resource.notes.mopp.NotesLexer());
	}
	
	public org.emftext.language.notes.resource.notes.INotesTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new org.emftext.language.notes.resource.notes.mopp.NotesParser().createInstance(inputStream, encoding);
	}
	
	public org.emftext.language.notes.resource.notes.INotesTextPrinter createPrinter(java.io.OutputStream outputStream, org.emftext.language.notes.resource.notes.INotesTextResource resource) {
		return new org.emftext.language.notes.resource.notes.mopp.NotesPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.emftext.language.notes.resource.notes.mopp.NotesSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.emftext.language.notes.resource.notes.mopp.NotesSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public org.emftext.language.notes.resource.notes.INotesReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.emftext.language.notes.resource.notes.mopp.NotesReferenceResolverSwitch();
	}
	
	public org.emftext.language.notes.resource.notes.INotesTokenResolverFactory getTokenResolverFactory() {
		return new org.emftext.language.notes.resource.notes.mopp.NotesTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "org.emftext.language.notes/metamodel/notes.cs";
	}
	
	public String[] getTokenNames() {
		return new org.emftext.language.notes.resource.notes.mopp.NotesParser(null).getTokenNames();
	}
	
	public org.emftext.language.notes.resource.notes.INotesTokenStyle getDefaultTokenStyle(String tokenName) {
		return new org.emftext.language.notes.resource.notes.mopp.NotesTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<org.emftext.language.notes.resource.notes.INotesBracketPair> getBracketPairs() {
		return new org.emftext.language.notes.resource.notes.mopp.NotesBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.emftext.language.notes.resource.notes.mopp.NotesFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new org.emftext.language.notes.resource.notes.mopp.NotesResourceFactory();
	}
	
	public org.emftext.language.notes.resource.notes.mopp.NotesNewFileContentProvider getNewFileContentProvider() {
		return new org.emftext.language.notes.resource.notes.mopp.NotesNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new org.emftext.language.notes.resource.notes.mopp.NotesResourceFactory());
	}
	
	/**
	 * Returns the key of the option that can be used to register a preprocessor that
	 * is used as a pipe when loading resources. This key is language-specific. To
	 * register one preprocessor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getInputStreamPreprocessorProviderOptionKey() {
		return getSyntaxName() + "_" + "INPUT_STREAM_PREPROCESSOR_PROVIDER";
	}
	
	/**
	 * Returns the key of the option that can be used to register a post-processors
	 * that are invoked after loading resources. This key is language-specific. To
	 * register one post-processor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getResourcePostProcessorProviderOptionKey() {
		return getSyntaxName() + "_" + "RESOURCE_POSTPROCESSOR_PROVIDER";
	}
	
	public String getLaunchConfigurationType() {
		return "org.emftext.language.notes.resource.notes.ui.launchConfigurationType";
	}
	
	public org.emftext.language.notes.resource.notes.INotesNameProvider createNameProvider() {
		return new org.emftext.language.notes.resource.notes.analysis.NotesDefaultNameProvider();
	}
	
}
