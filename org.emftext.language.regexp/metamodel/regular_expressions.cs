SYNTAXDEF regexp 
FOR <http://www.emftext.org/language/regexp>
START RegularExpression

OPTIONS {
	usePredefinedTokens = "false";
	reloadGeneratorModel = "true";
	overrideManifest = "false";
}

TOKENS {
	DEFINE CHAR_LITERAL	$'\''('\\'('n'|'r'|'t'|'b'|'f'|'"'|'\''|'\\'|'>'|'u'('0' .. '9'|'a'..'f'|'A'..'F')('0' .. '9'|'a'..'f'|'A'..'F')('0' .. '9'|'a'..'f'|'A'..'F')('0' .. '9'|'a'..'f'|'A'..'F')|.)|~( '\''|'\\'))'\''$;
	DEFINE STRING_LITERAL $'\''('\\'('n'|'r'|'t'|'b'|'f'|'"'|'\''|'\\'|'>'|'u'('0' .. '9'|'a'..'f'|'A'..'F')('0' .. '9'|'a'..'f'|'A'..'F')('0' .. '9'|'a'..'f'|'A'..'F')('0' .. '9'|'a'..'f'|'A'..'F')|.)|~( '\''|'\\'))('\\'('n'|'r'|'t'|'b'|'f'|'"'|'\''|'\\'|'>'|'u'('0' .. '9'|'a'..'f'|'A'..'F')('0' .. '9'|'a'..'f'|'A'..'F')('0' .. '9'|'a'..'f'|'A'..'F')('0' .. '9'|'a'..'f'|'A'..'F')|.)|~( '\''|'\\'))*'\''$;
	DEFINE MULTIPLICITY $'?'|'*'|'+'$;

	DEFINE WHITESPACE $(' '|'\t'|'\r'?'\n')+$;
}

RULES {
	RegularExpression ::= alternatives ( "|" alternatives )*;
	
	Block ::= "(" alternatives ( "|" alternatives )* ")";
	
	Range ::= from[CHAR_LITERAL] ".." to[CHAR_LITERAL];
	
	CharTerminal ::= value[CHAR_LITERAL];
	
	StringTerminal ::= value[STRING_LITERAL];
	
	Dot ::= ".";
	
	Alternative ::= elements*;
	
	Element ::= atom suffix[MULTIPLICITY];
	
	Not ::= "~" body;
}