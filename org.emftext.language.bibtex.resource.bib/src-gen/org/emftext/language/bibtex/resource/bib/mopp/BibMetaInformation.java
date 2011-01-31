/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.mopp;

public class BibMetaInformation implements org.emftext.language.bibtex.resource.bib.IBibMetaInformation {
	
	public String getSyntaxName() {
		return "bib";
	}
	
	public String getURI() {
		return "http://www.emftext.org/language/bibtex";
	}
	
	public org.emftext.language.bibtex.resource.bib.IBibTextScanner createLexer() {
		return new org.emftext.language.bibtex.resource.bib.mopp.BibAntlrScanner(new org.emftext.language.bibtex.resource.bib.mopp.BibLexer());
	}
	
	public org.emftext.language.bibtex.resource.bib.IBibTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new org.emftext.language.bibtex.resource.bib.mopp.BibParser().createInstance(inputStream, encoding);
	}
	
	public org.emftext.language.bibtex.resource.bib.IBibTextPrinter createPrinter(java.io.OutputStream outputStream, org.emftext.language.bibtex.resource.bib.IBibTextResource resource) {
		return new org.emftext.language.bibtex.resource.bib.mopp.BibPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.emftext.language.bibtex.resource.bib.mopp.BibSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.emftext.language.bibtex.resource.bib.mopp.BibSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public org.emftext.language.bibtex.resource.bib.IBibReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.emftext.language.bibtex.resource.bib.mopp.BibReferenceResolverSwitch();
	}
	
	public org.emftext.language.bibtex.resource.bib.IBibTokenResolverFactory getTokenResolverFactory() {
		return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "org.emftext.language.bibtex/metamodel/bibtex.cs";
	}
	
	public String[] getTokenNames() {
		return new org.emftext.language.bibtex.resource.bib.mopp.BibParser(null).getTokenNames();
	}
	
	public org.emftext.language.bibtex.resource.bib.IBibTokenStyle getDefaultTokenStyle(String tokenName) {
		return new org.emftext.language.bibtex.resource.bib.mopp.BibTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<org.emftext.language.bibtex.resource.bib.IBibBracketPair> getBracketPairs() {
		return new org.emftext.language.bibtex.resource.bib.mopp.BibBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.emftext.language.bibtex.resource.bib.mopp.BibFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new org.emftext.language.bibtex.resource.bib.mopp.BibResourceFactory();
	}
	
	public org.emftext.language.bibtex.resource.bib.mopp.BibNewFileContentProvider getNewFileContentProvider() {
		return new org.emftext.language.bibtex.resource.bib.mopp.BibNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new org.emftext.language.bibtex.resource.bib.mopp.BibResourceFactory());
	}
	
}
