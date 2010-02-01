/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0.mopp;

public class Pl0MetaInformation implements org.emftext.language.pl0.resource.pl0.IPl0MetaInformation {
	
	public java.lang.String getSyntaxName() {
		return "pl0";
	}
	
	public java.lang.String getURI() {
		return "http://www.emftext.org/language/pl0";
	}
	
	public org.emftext.language.pl0.resource.pl0.IPl0TextScanner createLexer() {
		return new org.emftext.language.pl0.resource.pl0.mopp.Pl0AntlrScanner(new org.emftext.language.pl0.resource.pl0.mopp.Pl0Lexer());
	}
	
	public org.emftext.language.pl0.resource.pl0.IPl0TextParser createParser(java.io.InputStream inputStream, java.lang.String encoding) {
		return new org.emftext.language.pl0.resource.pl0.mopp.Pl0Parser().createInstance(inputStream, encoding);
	}
	
	public org.emftext.language.pl0.resource.pl0.IPl0TextPrinter createPrinter(java.io.OutputStream outputStream, org.emftext.language.pl0.resource.pl0.IPl0TextResource resource) {
		return new org.emftext.language.pl0.resource.pl0.mopp.Pl0Printer(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.emftext.language.pl0.resource.pl0.mopp.Pl0SyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.emftext.language.pl0.resource.pl0.mopp.Pl0SyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public org.emftext.language.pl0.resource.pl0.IPl0ReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.emftext.language.pl0.resource.pl0.mopp.Pl0ReferenceResolverSwitch();
	}
	
	public org.emftext.language.pl0.resource.pl0.IPl0TokenResolverFactory getTokenResolverFactory() {
		return new org.emftext.language.pl0.resource.pl0.mopp.Pl0TokenResolverFactory();
	}
	
	public java.lang.String getPathToCSDefinition() {
		return "org.emftext.language.pl0/metamodel/pl0.cs";
	}
	
	public java.lang.String[] getTokenNames() {
		return new org.emftext.language.pl0.resource.pl0.mopp.Pl0Parser(null).getTokenNames();
	}
	
	public org.emftext.language.pl0.resource.pl0.IPl0TokenStyle getDefaultTokenStyle(java.lang.String tokenName) {
		return new org.emftext.language.pl0.resource.pl0.mopp.Pl0TokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<org.emftext.language.pl0.resource.pl0.IPl0BracketPair> getBracketPairs() {
		return new org.emftext.language.pl0.resource.pl0.mopp.Pl0BracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.emftext.language.pl0.resource.pl0.mopp.Pl0FoldingInformationProvider().getFoldableClasses();
	}
	
	public org.emftext.language.pl0.resource.pl0.IPl0HoverTextProvider getHoverTextProvider() {
		return new org.emftext.language.pl0.resource.pl0.mopp.Pl0HoverTextProvider();
	}
	
	public org.emftext.language.pl0.resource.pl0.ui.Pl0ColorManager createColorManager() {
		return new org.emftext.language.pl0.resource.pl0.ui.Pl0ColorManager();
	}
	
	public org.eclipse.jface.text.rules.ITokenScanner createTokenScanner(org.emftext.language.pl0.resource.pl0.ui.Pl0ColorManager colorManager) {
		return new org.emftext.language.pl0.resource.pl0.ui.Pl0TokenScanner(colorManager);
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new org.emftext.language.pl0.resource.pl0.mopp.Pl0ResourceFactory();
	}
	
	public org.emftext.language.pl0.resource.pl0.mopp.Pl0NewFileContentProvider getNewFileContentProvider() {
		return new org.emftext.language.pl0.resource.pl0.mopp.Pl0NewFileContentProvider();
	}
	
	public org.emftext.language.pl0.resource.pl0.mopp.Pl0CodeCompletionHelper createCodeCompletionHelper() {
		return new org.emftext.language.pl0.resource.pl0.mopp.Pl0CodeCompletionHelper();
	}
	
}
