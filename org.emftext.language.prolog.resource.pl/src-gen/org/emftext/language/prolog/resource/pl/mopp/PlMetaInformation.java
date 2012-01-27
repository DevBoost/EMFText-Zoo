/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.mopp;

public class PlMetaInformation implements org.emftext.language.prolog.resource.pl.IPlMetaInformation {
	
	public String getSyntaxName() {
		return "pl";
	}
	
	public String getURI() {
		return "http://www.emftext.org/language/prolog";
	}
	
	public org.emftext.language.prolog.resource.pl.IPlTextScanner createLexer() {
		return new org.emftext.language.prolog.resource.pl.mopp.PlAntlrScanner(new org.emftext.language.prolog.resource.pl.mopp.PlLexer());
	}
	
	public org.emftext.language.prolog.resource.pl.IPlTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new org.emftext.language.prolog.resource.pl.mopp.PlParser().createInstance(inputStream, encoding);
	}
	
	public org.emftext.language.prolog.resource.pl.IPlTextPrinter createPrinter(java.io.OutputStream outputStream, org.emftext.language.prolog.resource.pl.IPlTextResource resource) {
		return new org.emftext.language.prolog.resource.pl.mopp.PlPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.emftext.language.prolog.resource.pl.mopp.PlSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.emftext.language.prolog.resource.pl.mopp.PlSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public org.emftext.language.prolog.resource.pl.IPlReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.emftext.language.prolog.resource.pl.mopp.PlReferenceResolverSwitch();
	}
	
	public org.emftext.language.prolog.resource.pl.IPlTokenResolverFactory getTokenResolverFactory() {
		return new org.emftext.language.prolog.resource.pl.mopp.PlTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "org.emftext.language.prolog/metamodel/prolog.cs";
	}
	
	public String[] getTokenNames() {
		return new org.emftext.language.prolog.resource.pl.mopp.PlParser(null).getTokenNames();
	}
	
	public org.emftext.language.prolog.resource.pl.IPlTokenStyle getDefaultTokenStyle(String tokenName) {
		return new org.emftext.language.prolog.resource.pl.mopp.PlTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<org.emftext.language.prolog.resource.pl.IPlBracketPair> getBracketPairs() {
		return new org.emftext.language.prolog.resource.pl.mopp.PlBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.emftext.language.prolog.resource.pl.mopp.PlFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new org.emftext.language.prolog.resource.pl.mopp.PlResourceFactory();
	}
	
	public org.emftext.language.prolog.resource.pl.mopp.PlNewFileContentProvider getNewFileContentProvider() {
		return new org.emftext.language.prolog.resource.pl.mopp.PlNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new org.emftext.language.prolog.resource.pl.mopp.PlResourceFactory());
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
		return "org.emftext.language.prolog.resource.pl.ui.launchConfigurationType";
	}
	
	public org.emftext.language.prolog.resource.pl.IPlNameProvider createNameProvider() {
		return new org.emftext.language.prolog.resource.pl.analysis.PlDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		org.emftext.language.prolog.resource.pl.mopp.PlAntlrTokenHelper tokenHelper = new org.emftext.language.prolog.resource.pl.mopp.PlAntlrTokenHelper();
		java.util.List<String> highlightableTokens = new java.util.ArrayList<String>();
		String[] parserTokenNames = getTokenNames();
		for (int i = 0; i < parserTokenNames.length; i++) {
			// If ANTLR is used we need to normalize the token names
			if (!tokenHelper.canBeUsedForSyntaxHighlighting(i)) {
				continue;
			}
			String tokenName = tokenHelper.getTokenName(parserTokenNames, i);
			if (tokenName == null) {
				continue;
			}
			highlightableTokens.add(tokenName);
		}
		highlightableTokens.add(org.emftext.language.prolog.resource.pl.mopp.PlTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
