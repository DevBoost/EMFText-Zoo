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

SYNTAXDEF closure
FOR <http://emftext.org/language/closures>
START java.Containers.CompilationUnit, java.Containers.EmptyModel
 
IMPORTS {
	java : <http://www.emftext.org/java> WITH SYNTAX java <../../org.emftext.language.java/metamodel/java.cs>
}

OPTIONS {	
	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	defaultTokenName = "IDENTIFIER";
	usePredefinedTokens = "false";
	srcFolder = "src-gen";
	overrideManifest = "false";
	overridePluginXML = "false";
	overrideClasspath = "false";
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel="true";
}

TOKENS{
}

TOKENSTYLES{
}



RULES{
	
	Closure::= "{" (parameters ("," parameters)*)? "=>" statements+  "}";
	
	
	
}

