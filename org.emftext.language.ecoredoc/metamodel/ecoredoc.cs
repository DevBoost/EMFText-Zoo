SYNTAXDEF ecoredoc
FOR <http://www.emftext.org/language/ecoredoc>
START Documentation

OPTIONS {
	overrideBuilder = "false";
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE ID $('A'..'Z'|'a'..'z') ('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'.')*$;
	DEFINE COMMENTS $'//'(~('\n'|'\r'))*$;
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAK $('\r\n'|'\r'|'\n')$;
}

TOKENSTYLES {
	"documentation" COLOR #000000, BOLD;
	"for" COLOR #000000, BOLD;
	"COMMENTS" COLOR #008000;
}

RULES {
	Documentation ::= 
		"documentation" "for" #1 documentedPackage['<','>']
		(!0 !0 documentationElements)*;
	
	DocumentationElement ::= documentedElement[ID] #1 ":" #1 text['"','"','\\'];
}