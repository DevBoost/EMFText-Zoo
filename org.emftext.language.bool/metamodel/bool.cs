SYNTAXDEF bool // == Basic Object-Oriented Language
FOR <http://www.emftext.org/language/bool>
START Class

OPTIONS {
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
}

RULES {
	Class  ::= "class" name "{" members* "}";

	Field  ::= type[] name ";";

	Method ::= "void" name "(" ")" "{" "}";

	Name ::= value[];
}