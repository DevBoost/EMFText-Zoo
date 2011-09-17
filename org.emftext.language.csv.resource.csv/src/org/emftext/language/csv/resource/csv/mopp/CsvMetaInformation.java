/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.language.csv.resource.csv.mopp;

import org.emftext.language.csv.resource.csv.ICsvNameProvider;
import org.emftext.language.csv.resource.csv.analysis.CsvDefaultNameProvider;

public class CsvMetaInformation implements org.emftext.language.csv.resource.csv.ICsvMetaInformation {
	
	public String getSyntaxName() {
		return "csv";
	}
	
	public String getURI() {
		return "http://www.emftext.org/language/csv";
	}
	
	public org.emftext.language.csv.resource.csv.ICsvTextScanner createLexer() {
		return new org.emftext.language.csv.resource.csv.mopp.CsvAntlrScanner(new org.emftext.language.csv.resource.csv.mopp.CsvLexer());
	}
	
	public org.emftext.language.csv.resource.csv.ICsvTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new org.emftext.language.csv.resource.csv.mopp.CsvParser().createInstance(inputStream, encoding);
	}
	
	public org.emftext.language.csv.resource.csv.ICsvTextPrinter createPrinter(java.io.OutputStream outputStream, org.emftext.language.csv.resource.csv.ICsvTextResource resource) {
		return new org.emftext.language.csv.resource.csv.mopp.CustomCsvPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.emftext.language.csv.resource.csv.mopp.CsvSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.emftext.language.csv.resource.csv.mopp.CsvSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public org.emftext.language.csv.resource.csv.ICsvReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.emftext.language.csv.resource.csv.mopp.CsvReferenceResolverSwitch();
	}
	
	public org.emftext.language.csv.resource.csv.ICsvTokenResolverFactory getTokenResolverFactory() {
		return new org.emftext.language.csv.resource.csv.mopp.CsvTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "org.emftext.language.csv/metamodel/csv.cs";
	}
	
	public String[] getTokenNames() {
		return new org.emftext.language.csv.resource.csv.mopp.CsvParser(null).getTokenNames();
	}
	
	public org.emftext.language.csv.resource.csv.ICsvTokenStyle getDefaultTokenStyle(String tokenName) {
		return new org.emftext.language.csv.resource.csv.mopp.CsvTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<org.emftext.language.csv.resource.csv.ICsvBracketPair> getBracketPairs() {
		return new org.emftext.language.csv.resource.csv.mopp.CsvBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.emftext.language.csv.resource.csv.mopp.CsvFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new org.emftext.language.csv.resource.csv.mopp.CsvResourceFactory();
	}
	
	public org.emftext.language.csv.resource.csv.mopp.CsvNewFileContentProvider getNewFileContentProvider() {
		return new org.emftext.language.csv.resource.csv.mopp.CsvNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new org.emftext.language.csv.resource.csv.mopp.CsvResourceFactory());
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
		return "org.emftext.language.csv.resource.csv.ui.launchConfigurationType";
	}

	public ICsvNameProvider createNameProvider() {
		return new CsvDefaultNameProvider();
	}
	
}
