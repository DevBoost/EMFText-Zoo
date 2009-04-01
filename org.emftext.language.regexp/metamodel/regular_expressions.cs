SYNTAXDEF regexp 
FOR <http://www.emftext.org/language/regexp>
START RegularExpression

OPTIONS {
	usePredefinedTokens = "false";
	reloadGeneratorModel = "true";
}

TOKENS {
	DEFINE CHAR_LITERAL	$'\''('\\'('n'|'r'|'t'|'b'|'f'|'"'|'\''|'\\'|'>'|'u'('0' .. '9'|'a'..'f'|'A'..'F')('0' .. '9'|'a'..'f'|'A'..'F')('0' .. '9'|'a'..'f'|'A'..'F')('0' .. '9'|'a'..'f'|'A'..'F')|.)|~( '\''|'\\'))'\''$;
	DEFINE STRING_LITERAL $'\''('\\'('n'|'r'|'t'|'b'|'f'|'"'|'\''|'\\'|'>'|'u'('0' .. '9'|'a'..'f'|'A'..'F')('0' .. '9'|'a'..'f'|'A'..'F')('0' .. '9'|'a'..'f'|'A'..'F')('0' .. '9'|'a'..'f'|'A'..'F')|.)|~( '\''|'\\'))('\\'('n'|'r'|'t'|'b'|'f'|'"'|'\''|'\\'|'>'|'u'('0' .. '9'|'a'..'f'|'A'..'F')('0' .. '9'|'a'..'f'|'A'..'F')('0' .. '9'|'a'..'f'|'A'..'F')('0' .. '9'|'a'..'f'|'A'..'F')|.)|~( '\''|'\\'))*'\''$;
	DEFINE WHITESPACE $(' '|'\t'|'\r'?'\n')+$;
}

RULES {
	RegularExpression ::= 
		alternatives ( "|" alternatives )*;
	
	EBNF ::=
		block ("?"|"*"|"+"|"^"|"!")?;
	
	Block ::=
		"(" alternatives ( "|" alternatives )* ")";
	
	Range ::=
		from[CHAR_LITERAL] ".." to[CHAR_LITERAL];
	
	Terminal ::=
		value[CHAR_LITERAL] | value[STRING_LITERAL] | ".";
		
	EBNFSuffix ::=
		"?"|"*"|"+";
		
	Alternative ::= 
		elements*;
		
	Element ::= 
		elementNoOptionSpec;
		
	ElementNoOptionSpec ::=
		atom ("^"|"!")? suffix? | ebnf;
		
	Not ::=
		"~" body;
}