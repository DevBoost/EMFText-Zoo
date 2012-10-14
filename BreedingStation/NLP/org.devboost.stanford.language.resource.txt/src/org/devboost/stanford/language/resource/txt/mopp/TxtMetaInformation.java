/**
* Copyright (C) 2012  
* Jan Reimann (TU Dresden, Software Technology Group)
* Mirko Seifert (DevBoost GmbH)
* 
* This program is free software; you can redistribute it and/or
* modify it under the terms of the GNU General Public License
* as published by the Free Software Foundation; either version 2
* of the License, or (at your option) any later version.
* 
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
* 
* You should have received a copy of the GNU General Public License
* along with this program; if not, write to the Free Software
* Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
*/
package org.devboost.stanford.language.resource.txt.mopp;

import org.devboost.stanford.language.resource.txt.StanfordParser;

public class TxtMetaInformation implements org.devboost.stanford.language.resource.txt.ITxtMetaInformation {
	
	public String getSyntaxName() {
		return "txt";
	}
	
	public String getURI() {
		return "http://www.devboost.org/stanford/language";
	}
	
	public org.devboost.stanford.language.resource.txt.ITxtTextScanner createLexer() {
		return new org.devboost.stanford.language.resource.txt.mopp.TxtAntlrScanner(new org.devboost.stanford.language.resource.txt.mopp.TxtLexer());
	}
	
	public org.devboost.stanford.language.resource.txt.ITxtTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new StanfordParser(inputStream, encoding);
	}
	
	public org.devboost.stanford.language.resource.txt.ITxtTextPrinter createPrinter(java.io.OutputStream outputStream, org.devboost.stanford.language.resource.txt.ITxtTextResource resource) {
		return new org.devboost.stanford.language.resource.txt.mopp.TxtPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.devboost.stanford.language.resource.txt.mopp.TxtSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.devboost.stanford.language.resource.txt.mopp.TxtSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public org.devboost.stanford.language.resource.txt.ITxtReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.devboost.stanford.language.resource.txt.mopp.TxtReferenceResolverSwitch();
	}
	
	public org.devboost.stanford.language.resource.txt.ITxtTokenResolverFactory getTokenResolverFactory() {
		return new org.devboost.stanford.language.resource.txt.mopp.TxtTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "org.devboost.stanford.language/metamodel/language.cs";
	}
	
	public String[] getTokenNames() {
		return org.devboost.stanford.language.resource.txt.mopp.TxtParser.tokenNames;
	}
	
	public org.devboost.stanford.language.resource.txt.ITxtTokenStyle getDefaultTokenStyle(String tokenName) {
		return new org.devboost.stanford.language.resource.txt.mopp.TxtTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<org.devboost.stanford.language.resource.txt.ITxtBracketPair> getBracketPairs() {
		return new org.devboost.stanford.language.resource.txt.mopp.TxtBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.devboost.stanford.language.resource.txt.mopp.TxtFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new org.devboost.stanford.language.resource.txt.mopp.TxtResourceFactory();
	}
	
	public org.devboost.stanford.language.resource.txt.mopp.TxtNewFileContentProvider getNewFileContentProvider() {
		return new org.devboost.stanford.language.resource.txt.mopp.TxtNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		// if no resource factory registered, register delegator
		if (org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(getSyntaxName()) == null) {
			org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new org.devboost.stanford.language.resource.txt.mopp.TxtResourceFactoryDelegator());
		}
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
		return "org.devboost.stanford.language.resource.txt.ui.launchConfigurationType";
	}
	
	public org.devboost.stanford.language.resource.txt.ITxtNameProvider createNameProvider() {
		return new org.devboost.stanford.language.resource.txt.analysis.TxtDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		org.devboost.stanford.language.resource.txt.mopp.TxtAntlrTokenHelper tokenHelper = new org.devboost.stanford.language.resource.txt.mopp.TxtAntlrTokenHelper();
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
		highlightableTokens.add(org.devboost.stanford.language.resource.txt.mopp.TxtTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
