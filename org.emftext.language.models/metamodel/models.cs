SYNTAXDEF model
FOR <http://www.emftext.org/language/models>
START Model

OPTIONS {
	usePredefinedTokens = "false";
	tokenspace = "1";
}

TOKENS {
	DEFINE SL_COMMENT $'//'(~('\\n'|'\\r'|'\\uffff'))* $ COLLECT IN comments;
	DEFINE ML_COMMENT $'/*'.*'*/'$ COLLECT IN comments;
	DEFINE TEXT $('a'..'z')*$;
	DEFINE NUMBER $('0'..'9')*$;

	DEFINE WHITESPACE $(' '|'\\t'|'\\f')$;
	DEFINE LINEBREAKS $('\\r\\n'|'\\r'|'\\n')$;
}

TOKENSTYLES {
	"SL_COMMENT" COLOR #3a732e;
	"ML_COMMENT" COLOR #3a732e;
	"QUOTED_34_34" COLOR #09096b, BOLD;
	"TEXT" COLOR #400080, BOLD;
	"prototype" COLOR #000000, BOLD;
	"NUMBER" COLOR #000000;
	"hair" COLOR #000000, BOLD;
	"eyes" COLOR #000000, BOLD;
	"lips" COLOR #000000, BOLD;
	"legs" COLOR #000000, BOLD;
}

RULES {
	Model ::= 
		"prototype" name['"','"'] "[" size1[NUMBER] "," size2[NUMBER] "," size3[NUMBER] "]" "{"
			hair[TEXT] "hair" ";"
			eyes[TEXT] "eyes" ";"
			lips[TEXT] "lips" ";"
			legs[TEXT] "legs" ";"
		"}"
	;
}