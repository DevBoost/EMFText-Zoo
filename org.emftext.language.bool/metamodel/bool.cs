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
	Class  ::= visibility[] "class" name "{" members* "}";
		
	Field  ::= visibility[] type[] name ";";
		
	Method ::= visibility[] "void" name "(" ")" "{" "}";
	
	Name ::= value[];	
}