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

SYNTAXDEF fs
FOR <http://www.emftext.org/language/filesystem>
START Folder

OPTIONS {
 	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
}

RULES {
	Folder    ::= "Folder" name['"','"'] "{" contents* "}" ;
	PlainFile ::= "File" name['"','"'] ;
}