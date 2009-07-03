SYNTAXDEF fj 
FOR <http://www.emftext.org/language/featherweight_java>
START Class

OPTIONS {
	reloadGeneratorModel = "true";
	backtracking = "true";
	memoize = "true";
	generateCodeFromGeneratorModel = "true";
}

TOKENSTYLES {
	"class"  COLOR #7F0055, BOLD;
	"new"    COLOR #7F0055, BOLD;
	"return" COLOR #7F0055, BOLD;
}

RULES {
	Class  ::= "class" name[] "{" members* "}";
	Constructor ::= name[] "(" parameters* ")" "{" 
			"super" "(" ")" ";"
			initialisations*
		"}";
	Parameter ::= type[] name[];
	FieldInitialisiation ::= "this" "." field[] "=" parameter[] ";";
	Method ::= name[] "(" ")" "{" "return" returnValue "}";
	Field  ::= type[] name[];
	
	// expressions
	ConstructorCall ::= "new" type[] "(" ")";
	FieldAccess     ::= expression : FieldAccessChild "." field[];
	MethodCall      ::= method[] "(" ")";
	Cast            ::= "(" type[] ")" expression;
}