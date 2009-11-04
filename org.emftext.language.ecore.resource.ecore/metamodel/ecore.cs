//*******************************************************************************
// Copyright (c) 2006-2009 
// Software Technology Group, Dresden University of Technology
// 
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0 
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
// 
// Contributors:
//   Software Technology Group - TU Dresden, Germany 
//      - initial API and implementation
// ******************************************************************************/

//This is a dummy CS used to generate a ResourceFactoryDelegator and a 'additional_extension_parser' EP for 'ecore'.
//Since the default syntax for ecore is XMI, the generated parser etc. are not used.
//The generated ResourceFactory is replaced by the default EcoreResourceFactoryImpl using the extension point in another plugin.

SYNTAXDEF ecore
FOR <http://www.eclipse.org/emf/2002/Ecore>
START EPackage

OPTIONS {
	usePredefinedTokens = "false";
	resourcePluginID = "org.emftext.language.ecore.resource.ecore";
	basePackage = "org.emftext.language.ecore.resource.ecore";
}

TOKENS {
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
}

RULES {	
	EPackage ::= "DUMMY";
}