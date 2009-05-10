SYNTAXDEF customer
FOR <http://www.emftext.org/language/customer>
START Customer

OPTIONS {
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
}

TOKENSTYLES {
	"CUSTOMER" COLOR #009bd3, BOLD;
	"WANTS" COLOR #009bd3, BOLD;
	"SOMETHING" COLOR #009bd3, BOLD;
	"TEXT" COLOR #202020;
}

RULES {
	Customer ::= "CUSTOMER" name[] "WANTS" "SOMETHING" requests ("," requests)*;
	Request ::= name[];
}