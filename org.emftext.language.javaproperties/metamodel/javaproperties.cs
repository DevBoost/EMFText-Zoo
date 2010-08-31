SYNTAXDEF properties
FOR <http://www.emftext.org/language/javaproperties>
START PropertySet

OPTIONS {
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE COMMENT1 $'#'(~('\n'|'\r'|'\uffff'))*('\r\n'|'\r'|'\n')$;
	DEFINE COMMENT2 $'!'(~('\n'|'\r'|'\uffff'))*('\r\n'|'\r'|'\n')$;
	DEFINE KEY $(~(' '|'\t'|'\f'|'='|':'|'#'|'\r\n'|'\r'|'\n'))+$;
	DEFINE VALUE $(('='|':')+)(('\\'('\r\n'|'\r'|'\n'))|('\\''\\')|~('\r\n'|'\r'|'\n'|'\\'))*('\r\n'|'\r'|'\n')$;
	DEFINE WHITESPACE $(' '|'\t'|'f')$;
	DEFINE LINEBREAK $('\r\n'|'\r'|'\n')$;
}

TOKENSTYLES {
	"KEY"   COLOR #07a8ec, BOLD;
	"VALUE" COLOR #9807ec, BOLD;
	"COMMENT1"   COLOR #06bd0e, ITALIC;
	"COMMENT2"   COLOR #06bd0e, ITALIC;
}

RULES {
	PropertySet  ::= properties*;
	KeyValuePair ::= key[KEY] value[VALUE];
}