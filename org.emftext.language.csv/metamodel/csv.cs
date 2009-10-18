SYNTAXDEF csv
FOR <http://www.emftext.org/language/csv>
START CSVDocument

OPTIONS {
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