SYNTAXDEF bool // == Basic Object-Oriented Language
FOR <http://www.emftext.org/language/bool>
START Class

OPTIONS {
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\\n'|'\\r'))*$;
}

TOKENSTYLES {
	"class" COLOR #7F0055, BOLD;
	"void" COLOR #7F0055, BOLD;
}

RULES {
	Class  ::= "class" name "{" members* "}";

	Field  ::= type[] name ";";

	Method ::= "void" name "(" ")" "{" "}";

	Name ::= value[];
}