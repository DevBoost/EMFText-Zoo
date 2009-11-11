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

SYNTAXDEF template_call
FOR  <http://www.emftext.org/language/template_concepts/call>
START TemplateCall

OPTIONS {	
	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	usePredefinedTokens = "false";
	generateCodeFromGeneratorModel = "true";
}

TOKENS {
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
}

RULES {
	TemplateCall ::= "CALL" target['"','"'] "USING" parameterModel['"','"'];
}