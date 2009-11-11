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

SYNTAXDEF csv
FOR <http://www.emftext.org/language/csv>
START CSVDocument

OPTIONS {
 	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	reloadGeneratorModel = "true";
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE LINEBREAK $ ('\r\n'|'\r'|'\n') $;
	DEFINE T_VALUE   $ (',')? (('"')(('\\''"')|('\\''\\')|~('"'|'\\'))*('"') | (~('"'|','|'\r\n'|'\r'|'\n')))+ | ',' $;
}

RULES {
	CSVDocument ::= rows (linebreaks[LINEBREAK] rows)* linebreaks[LINEBREAK]*;
	Row ::= values+;
	Value ::= text[T_VALUE];
}