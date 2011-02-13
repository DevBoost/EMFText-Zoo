//*******************************************************************************
// Copyright (c) 2006-2010 
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
	//disableTokenSorting = "true";
	tokenspace = "0";
}

TOKENS {
	DEFINE LINEBREAK $('\r\n'|'\r'|'\n')$;
	
	DEFINE FRAGMENT QUOTED_VALUE   $('"')(('\\''"')|('\\''\\')|~('"'|'\\'))*('"')$;
	DEFINE FRAGMENT UNQUOTED_VALUE $(~('"'|','|'\r\n'|'\r'|'\n'))+$;
	
	// TODO known problem: CSV files must either end with a linebreak or a comma
	// because we cannot match the EOF signal here. A possible workaround is to
	// add a stream preprocessor that add a linebreak if it is missing.
	DEFINE T_VALUE_WITH_COMMA      $($ + QUOTED_VALUE + $ | $ + UNQUOTED_VALUE + $) ',' $;
	DEFINE T_VALUE_WITHOUT_COMMA   $($ + QUOTED_VALUE + $ | $ + UNQUOTED_VALUE + $) $ + LINEBREAK;
}

RULES {
	CSVDocument ::= rows* linebreaks[LINEBREAK]*;
	// this is a awkward trick to parse CSV files:
	//
	// all values except the last one use the ValueWithComma class to allow only
	// the T_VALUE_WITH_COMMA token. For the last value we use the ValueWithoutComma
	// class to match values that end with a linebreak
	//
	// after parsing a post processor replaces all instances of ValueWithComma and
	// ValueWithoutComma with ordinary Value instances
	Row ::= values : ValueWithComma+ values : ValueWithoutComma?;
	
	ValueWithComma ::= text[T_VALUE_WITH_COMMA];
	ValueWithoutComma ::= text[T_VALUE_WITHOUT_COMMA];
	
	// this rule is only used for printing
	Value ::= text[T_VALUE_WITH_COMMA];
}